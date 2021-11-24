package info.codeden.ht.string.search;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



//Corrections provides one method capitalizeFirstWordInSentence that corrects that error .
public final class Corrections {

    //Suppress default constructor for instantiation capabilities
    private Corrections() {
       new AssertionError();
    }

    /**
     *  If the first letter is not capitalize in a sentence then this method capitalises the first letter
     *  in every sentence of the given string parameter.
     * @param s is any string of sentence or sentences.
     */
    public static void capitalizeFirstWordInSentence(String s) {
        Pattern p = Pattern.compile("(?:^)[a-z]|(?<=[.!?]\\s)\\b[a-z]");
        Matcher m = p.matcher(s);
        System.out.println("Is the pattern matching " + m.find());
        m.reset();
        var firstCharacterInSentence = m.replaceAll(mr -> mr.group().toUpperCase());

        System.out.print(firstCharacterInSentence);

        m.reset();
    }

    public static void main(String[] args) {
        var sentence = "hello from Japan. mark. i am will! what is your name? please!";
        capitalizeFirstWordInSentence(sentence);
    }
}
