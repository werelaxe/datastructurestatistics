import java.util.ArrayList;
import java.util.List;

/**
 * Created by melon on 10.12.16.
 */

public interface IFrequencyDictionary {
    void add(String word);
    List<Pair<String, Integer>> search(int wordsCount, String prefix);
}
