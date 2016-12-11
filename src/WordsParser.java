import java.util.ArrayList;

/**
 * Created by melon on 10.12.16.
 */
public class WordsParser {
    public static ArrayList<String> parseWords(String input) {
        ArrayList<String> finalWords = new ArrayList<>();
        for (String s : input.split("[^а-яА-ЯёЁ\\']"))
            if (!s.equals(""))
                finalWords.add(s.toLowerCase());
        return finalWords;
    }
}
