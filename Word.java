public class Word {
    private String word;
    private Alist<FrequencyByFile> frequencyList = new Alist<FrequencyByFile>(100);

    public Word(String word, String fileName){
        this.word = word;
        FrequencyByFile frequencyByFile = new FrequencyByFile(fileName);
        frequencyList.add(frequencyByFile);
    }
    
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getFileName(){
        return getFileName();
    }

    public Alist<FrequencyByFile> getFrequencyList() {
        return frequencyList;
    }

    /*public String mostSignificentFile(){//sort files for a word
        String file;
        int length = frequencyList.getLength();
        int biggestFrequency = 0;
        int tempFrequencyF;
        for (int i = 1; i <= length; i++) {
            tempFrequencyF =frequencyList.getEntry(i).getFrequency();
            if(biggestFrequency < tempFrequencyF){
                biggestFrequency =tempFrequencyF;
            }

        }

        return file;
    }*/

    public void updateFrequency(String fileName){
        int position = getPosition(fileName);

        if(position == 0){
            FrequencyByFile frequencyByFile = new FrequencyByFile(fileName);
            frequencyList.add(frequencyByFile);
        }
        else{
            FrequencyByFile tempFreqByFile = frequencyList.getEntry(position);
            tempFreqByFile.increaseFrequency();
            frequencyList.replace(position, tempFreqByFile);
        }
        /*
        position = frequencyList.getPosition(frequencyByFile);
        FrequencyByFile tempFreqByFile = frequencyList.getEntry(position);
        tempFreqByFile.increaseFrequency();
        frequencyList.replace(position, tempFreqByFile);*/
    }

    

    public int getPosition(String fileName) { //for getting where a spesific entry
        boolean found = false;
        int index = 1;
        int numberOfEntries = frequencyList.getLength();
        while (!found && (index <= numberOfEntries)) {
            if (fileName.equals(frequencyList.getEntry(index).getFileName())){
                found = true;
                break;
            }
            index++;
        }
        if(!found){
            return 0;
        }
        else{
            return index;
        }
    }
    
}
