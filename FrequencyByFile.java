public class FrequencyByFile { // keep frequencies seperately for every file
    String fileName;
    int frequency;

    public FrequencyByFile(String fileName){
        this.fileName = fileName;
        frequency = 1;
    }

    public void increaseFrequency(){
        frequency++;
    }

    public String getFileName() {
        return fileName;
    }

    public int getFileIndex(){
        int fileIndex = Integer.parseInt(fileName.replaceAll("[^0-9]", ""));//seperate numbers from fileName
        return fileIndex;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency){
        this.frequency = frequency;
    }
}
