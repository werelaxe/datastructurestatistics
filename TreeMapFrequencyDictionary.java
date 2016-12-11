import java.util.Comparator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by melon on 12.12.16.
 */

class WordComparator implements Comparator<String> {
    @Override
    public int compare(String a, String b) {
        return b.compareTo(a);
    }
}

public class TreeMapFrequencyDictionary implements IFrequencyDictionary {
    private TreeMap<String, Integer> data = new TreeMap<>(new WordComparator());
    @Override
    public void add(String word) {
        if (!data.containsKey(word))
            data.put(word, 1);
        else {
            int wordCount = data.get(word);
            data.put(word, wordCount + 1);
        }
    }

    @Override
    public List<Pair<String, Integer>> search(int wordsCount, String prefix) {
        SortedMap<String, Integer> subTree = data.headMap(prefix);
        System.out.println(subTree.firstKey());
        return null;
    }
}
