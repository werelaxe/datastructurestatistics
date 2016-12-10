import java.util.ArrayList;
import java.util.List;

/**
 * Created by melon on 10.12.16.
 */

public abstract class FrequencyDictionary {
    public abstract void add(String word);
    public abstract List<Pair<String, Integer>> search(int wordsCount, String prefix);
}
