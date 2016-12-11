import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by melon on 10.12.16.
 */
public class Program {
    public static void main(String[] args) {
        String input;
        try {
            input = new Scanner(new File("src/input.txt")).useDelimiter("\\A").next();
            //throw new FileNotFoundException();
        } catch (FileNotFoundException e) {
            input = "было было чтобы было молодые способны";
        }
        /*
        IFrequencyDictionary dict = new HashMapIFrequencyDictionary();
        for (String s: WordsParser.parseWords(input))
            dict.add(s);

        for (Pair<String, Integer> key: dict.search(10, "при"))
            System.out.println(key);
        */
        TreeMapFrequencyDictionary dict = new TreeMapFrequencyDictionary();
        dict.add("bitch");
        dict.add("guys");
        dict.add("hey");
        dict.add("huy");
        dict.add("yo");
        dict.search(0, "hu");
    }
}