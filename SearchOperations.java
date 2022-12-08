import java.util.Scanner;
public class SearchOperations {
    
    private FileOperations fileOp = new FileOperations();
    private Alist<FrequencyByFile> seqFrequencyList = new Alist<FrequencyByFile>();//frequency list for given sequence
    private HashedDictionary<String,Word> database = Main.database;
    private String[] input;

    public SearchOperations(){
        searchSequence();
    }

    public void getInput(){
        Scanner sn = new Scanner(System.in);
        System.out.println("Please enter search words:");
        String input = sn.nextLine();
        
        this.input= input.split(fileOp.delimiters);
        sn.close();
    }

    public void searchSequence(){
        getInput();
        int length = input.length;
        String str;
        Alist<FrequencyByFile> frequencyList;
        Word word;

        for (int i = 0; i < length; i++) {
            str = input[i];
            
            if(database.contains(str)){
                word = database.getValue(str);
                frequencyList= word.getFrequencyList();

                if(seqFrequencyList.isEmpty()){
                    seqFrequencyList = frequencyList;
                }
                else{
                    compareFrequencyLists(frequencyList);
                }
            }
        }
        String mostSignificentFile = mostSignificentFile();
        System.out.println("the most relevant document for your words is " + mostSignificentFile);
    }

    public void compareFrequencyLists(Alist<FrequencyByFile> frequencyList){
        /*check a spesific word's frequencylist and find frequencybyfile object, if the same file
         * exists in sequence's frequencylist, add new word's frequency to total frequency value in sequence's
         * frequencybyfile object. If doesn't, add a new frequencybyfile object to sequence's frequency list*/
        FrequencyByFile tempFbF;
        int frequency;
        boolean contains= false; // does sequence's frequency list has new file

        for (int i = 1; i <= frequencyList.getLength(); i++) {
            contains = false;
            frequency = frequencyList.getEntry(i).getFrequency();

            for (int j = 1; j <= seqFrequencyList.getLength(); j++) {

                if((frequencyList.getEntry(i).getFileName()).equals(seqFrequencyList.getEntry(j).getFileName())){
                    tempFbF = seqFrequencyList.getEntry(j);
                    int oldFreq = tempFbF.getFrequency();
                    tempFbF.setFrequency(frequency + oldFreq);
                    seqFrequencyList.replace(j, tempFbF);
                    contains = true;
                }
            }

            if(!contains){
                seqFrequencyList.add(frequencyList.getEntry(i));
            }
        }
    }

    public String mostSignificentFile(){//sort files
        int length = seqFrequencyList.getLength();
        int biggestFrequency = 0;
        int tempFrequencyF;
        FrequencyByFile tempf = seqFrequencyList.getEntry(1);

        for (int i = 1; i <= length; i++) {
            tempFrequencyF =seqFrequencyList.getEntry(i).getFrequency();

            if(biggestFrequency < tempFrequencyF){
                biggestFrequency =tempFrequencyF;
                tempf = seqFrequencyList.getEntry(i);
            }
        }
        return tempf.getFileName();
    }
}
