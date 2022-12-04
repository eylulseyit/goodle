import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
public class FileRead {
	private Alist<String> stopWords = new Alist<String>(1141);
	private String str;

	public FileRead(){

	}

    public void ReadSports(){
		for (int i = 1; i < 3; i++) {
			String path ="sport/00" + i + ".txt";
			try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
				while ((str = reader.readLine()) != null) {
					System.out.println(str);
				}
			} catch (IOException e) {
			System.out.println(
			"Error while reading a file.");
			}
		}
	}

	public void ReadStopWords() {
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

	public String[] delimiters(String text){
		String DELIMITERS = "[-+=" +

		        " " +        //space

		        "\r\n " +    //carriage return line fit

				"1234567890" + //numbers

				"’'\"" +       // apostrophe

				"(){}<>\\[\\]" + // brackets

				":" +        // colon

				"," +        // comma

				"‒–—―" +     // dashes

				"…" +        // ellipsis

				"!" +        // exclamation mark

				"." +        // full stop/period

				"«»" +       // guillemets

				"-‐" +       // hyphen

				"?" +        // question mark

				"‘’“”" +     // quotation marks

				";" +        // semicolon

				"/" +        // slash/stroke

				"⁄" +        // solidus

				"␠" +        // space?   

				"·" +        // interpunct

				"&" +        // ampersand

				"@" +        // at sign

				"*" +        // asterisk

				"\\" +       // backslash

				"•" +        // bullet

				"^" +        // caret

				"¤¢$€£¥₩₪" + // currency

				"†‡" +       // dagger

				"°" +        // degree

				"¡" +        // inverted exclamation point

				"¿" +        // inverted question mark

				"¬" +        // negation

				"#" +        // number sign (hashtag)

				"№" +        // numero sign ()

				"%‰‱" +      // percent and related signs

				"¶" +        // pilcrow

				"′" +        // prime

				"§" +        // section sign

				"~" +        // tilde/swung dash

				"¨" +        // umlaut/diaeresis

				"_" +        // underscore/understrike

				"|¦" +       // vertical/pipe/broken bar

				"⁂" +        // asterism

				"☞" +        // index/fist

				"∴" +        // therefore sign

				"‽" +        // interrobang

				"※" +          // reference mark

		        "]";

				

		String[] splitted = text.split(DELIMITERS);
		return splitted;
	}
}
