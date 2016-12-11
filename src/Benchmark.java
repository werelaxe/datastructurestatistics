import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by melon on 12.12.16.
 */
public class Benchmark {
    public static long TestAddingTime(IFrequencyDictionary dictionary, List<String> words) {
        long startTime = System.nanoTime();
        for (String word : words) {
            dictionary.add(word);
        }
        return System.nanoTime() - startTime;
    }
    public static long TestSearchRandomWords(IFrequencyDictionary dictionary, List<String> words, List<String> randomWords) {
        for (String word : words) {
            dictionary.add(word);
        }
        long startTime = System.nanoTime();
        for (String randomWord : randomWords)
            dictionary.search(10, randomWord);
        return System.nanoTime() - startTime;
    }
}
