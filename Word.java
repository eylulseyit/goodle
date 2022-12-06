public class Word {
    String word;
    String fileName;
    int howManyTimes;

    public Word(String word, String fileName){
        this.word = word;
        this.fileName = fileName;
    }
    
    public String getWord() {
        return word;
    }
    
    public String getFileName() {
        return fileName;
    }
    
    public int getHowManyTimes() {
        return howManyTimes;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setHowManyTimes(int howManyTimes) {
        this.howManyTimes = howManyTimes;
    }
}
