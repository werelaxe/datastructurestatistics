import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

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
            input = "file not found";
        }
        ArrayList<String> words = WordsParser.parseWords(input);
        ArrayList<String> randomWords = new ArrayList<>();
        try {
            Scanner in = new Scanner(new File("/home/melon/Desktop/random words")).useDelimiter("\\n");
            while (true) {
                try {
                    randomWords.add(in.next());
                } catch (NoSuchElementException e) {

                    break;
                }
            }
            //throw new FileNotFoundException();
        } catch (FileNotFoundException e) {
        }
        try(FileWriter writer = new FileWriter("output.txt", false))
        {
            for (int wordsCount = 1; wordsCount < words.size(); wordsCount += 1000) {
                long time = Benchmark.TestAddingTime(new TreeMapFrequencyDictionary(), words.subList(0, wordsCount));
                writer.write(Long.toString(time));
                writer.write('\n');
                System.out.println(100 * (double)(wordsCount) / words.size() + "%");
            }
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }

    }
}