import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by melon on 10.12.16.
 */
public class Program {
    public static void main(String[] args) {
        String input;
        try {
            input = new Scanner(new File("src/input.txt")).useDelimiter("\\A").next();
        } catch (FileNotFoundException e) {
            input = "empty input";
        }
        FrequencyDictionary dict = new HashMapFrequencyDictionary();
        for (String s: WordsParser.parseWords(input))
            dict.add(s);
        for (Pair<String, Integer> key: dict.search(10, "ы"))
            System.out.println(key);
    }
}