public class Word {
    private String word;
    private Alist<FrequencyByFile> frequencyFileList = new Alist<FrequencyByFile>();

    public Word(String word, String fileName){
        this.word = word;
        FrequencyByFile frequencyByFile = new FrequencyByFile(fileName);
        frequencyFileList.add(frequencyByFile);
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

    /*public int checkFrequency(String word){
        boolean flag;
        int length = frequencyFileList.getLength();
        for (int i = 0; i < length; i++) {
            frequencyFileList.getEntry(i).getNam = word;
        }
    }*/
    
    private class FrequencyByFile { // keep frequencies seperately for every file
        String fileName;
        int frequency;
        int fileIndex;
    
        public FrequencyByFile(String fileName){
            this.fileName = fileName;
            frequency = 1;
            this.fileIndex = Integer.parseInt(fileName.replaceAll("[^0-9]", ""));//seperate numbers from fileName
        }

        public void increaseFrequency(){
            frequency++;
        }

        public String getFileName() {
            return fileName;
        }

        public int getFileIndex(){
            return fileIndex;
        }
    }
}
