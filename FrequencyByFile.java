public class FrequencyByFile { // keep frequencies seperately for every file
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

    public int getFrequency() {
        return frequency;
    }
}
