import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by melon on 10.12.16.
 */


public class HashMapFrequencyDictionary implements IFrequencyDictionary {
    public HashMap<String, Integer> data = new HashMap<>();
    @Override
    public void add(String word) {
        if (!data.containsKey(word))
            data.put(word, 0);
        data.put(word, data.get(word) + 1);
    }

    @Override
    public List<Pair<String, Integer>> search(int wordsCount, String prefix) {
        ArrayList<Pair<String, Integer>> words = new ArrayList<>();
        for (String word: data.keySet())
            if (word.startsWith(prefix)) {
                //if (word.charAt(0) == 'ы') System.out.println(word);
                words.add(new Pair<>(word, data.get(word)));
            }

        words.sort(new PairComparator());
        if (words.size() < wordsCount)
            return words;
        return words.subList(0, wordsCount);
    }
}