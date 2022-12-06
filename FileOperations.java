import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
public class FileOperations{
	private Alist<String> stopWords = new Alist<String>();
	delimiter delimiter = new delimiter();
	private String delimiters = delimiter.DELIMITERS;
	private HashedDictionary<Integer,Word> searchingWords = new HashedDictionary<>();

	public FileOperations(){
		readStopWords();
		readSports();
	}

    public void readSports(){
		String line;
		int key;
		Alist<String> extractedLine;
		for (int i = 1; i < 101; i++) {
			String path ="sport/" + String.format("%03d",i) + ".txt";
			try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
				while ((line = reader.readLine()) != null) {
					extractedLine = extractStopWords(line); //get words will be searched
					for (int j = 1; j <= extractedLine.getLength(); j++) {
						System.out.println(extractedLine.getEntry(j));//for check is it works
						key = simpleSum(extractedLine.getEntry(j));
						Word word = new Word(extractedLine.getEntry(j), path);
						searchingWords.add(key, word);
						String w = searchingWords.getValue(key).getWord();
					}
				}
			} catch (IOException e) {
			System.out.println(
			"Error while reading a file.");
			}
		}
	}

	public HashedDictionary getSearchingWords() {
		return searchingWords;
	}

	private int simpleSum(String word){
		int sum = 0;
		int length = word.length();
		for (int i = 0; i < length; i++) {
			sum += word.charAt(i);
		}
        sum-= 97;
		return sum;
	}

	private void polynomialAccumulation(String word){

	}

	private void readStopWords() {
		String str;
		try (BufferedReader reader = new BufferedReader(new FileReader("stop_words_en.txt"))) {
			 while ((str = reader.readLine()) != null) {
				  if(str != ""){
					stopWords.add(str);
				  }
			 }
		} catch (IOException e) {
			 System.out.println(
					   "Error while reading a file.");
		}
    }

	private Alist<String> extractStopWords(String text){
		Alist<String> words = new Alist<String>();
		String[] splitted = text.split(delimiters);
		int lengthStopWords = stopWords.getLength();
		boolean isStopWord = false;

		for (int i = 0; i < splitted.length; i++) {
			isStopWord = false;
			for (int j = 1; j <= lengthStopWords; j++) {
				if(splitted[i].equalsIgnoreCase(stopWords.getEntry(j))){
					isStopWord = true;
					break;
				}
			}
			if(!isStopWord){
			words.add(splitted[i]);
			}
		}
		return words;
	}

	
}
