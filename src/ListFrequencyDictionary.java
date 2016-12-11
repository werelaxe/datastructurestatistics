import java.util.ArrayList;
import java.util.List;

/**
 * Created by melon on 12.12.16.
 */
abstract class ListFrequencyDictionary implements IFrequencyDictionary {
    protected List<Pair<String, Integer>> data;
    public abstract void initialize();
    ListFrequencyDictionary() {
        initialize();
    }
    @Override
    public void add(String word) {
        for (Pair<String, Integer> wordPair : data) {
            if (wordPair.word.equals(word)) {
                wordPair.count += 1;
                return;
            }
        }
        data.add(new Pair<>(word, 1));
    }

    @Override
    public List<Pair<String, Integer>> search(int wordsCount, String prefix) {
        ArrayList<Pair<String, Integer>> freqDict = new ArrayList<>();
        for (Pair<String, Integer> wordPair: data) {
            if (wordPair.word.startsWith(prefix))
                freqDict.add(wordPair);
        }
        freqDict.sort(new PairComparator());
        if (freqDict.size() < wordsCount)
            return freqDict;
        return freqDict.subList(0, wordsCount);
    }
}
