import java.io.IOException;
import java.util.Iterator;

import java.io.BufferedReader;
import java.io.FileReader;
public class FileOperations{
	private Alist<String> stopWords = new Alist<String>();
	delimiter delimiter = new delimiter();
	public String delimiters = delimiter.DELIMITERS;
	private HashedDictionary<String,Word> database = Main.database;

	public FileOperations(){
		getDatabase();
	}

    public void getDatabase(){
		String line;
		String key;
		Alist<String> extractedLine;
		readStopWords();
		for (int i = 1; i < 5; i++) {

			String path ="sport/" + String.format("%03d",i) + ".txt";
			try (BufferedReader reader = new BufferedReader(new FileReader(path))) {

				while ((line = reader.readLine()) != null) {
					extractedLine = extractStopWords(line); //get words will be searched

					for (int j = 1; j <= extractedLine.getLength(); j++) {
						key = extractedLine.getEntry(j);

						if(database.contains(key)){
							Word tempWord = database.getValue(key);
							tempWord.updateFrequency(path);
							database.add(key, tempWord);
						}

						else{
							Word word = new Word(extractedLine.getEntry(j), path);
							database.add(key, word);
						}
					}
				}
			} catch (IOException e) {
			System.out.println(
			"Error while reading a file.");
			}
		}
	}

	public HashedDictionary<String,Word> getdatabase() {
		return database;
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

	public void display() {
        Iterator<String> keyIterator = database.getKeyIterator();
        Iterator<Word> valueIterator = database.getValueIterator();
        while (keyIterator.hasNext()) {
            Word value = valueIterator.next();

            Alist<FrequencyByFile> fc =  value.getFrequencyList();
            String key = keyIterator.next();

            for (int i = 1; i < fc.getLength()+1; i++) {
                String file = fc.getEntry(i).fileName;
                String word = value.getWord();
                int count = fc.getEntry(i).frequency;
                System.out.println("Key: " + word + " File:" + file + ": " + count);
            }
        }
    }
	
}
