import java.util.*;

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
        ArrayList<Pair<String, Integer>> freqDict = new ArrayList<>();
        //int size = 0;
        while (true)
        {
            if (subTree.size()  == 0)
                break;
            String currentWord = subTree.lastKey();
            if (!currentWord.startsWith(prefix))
                break;
            freqDict.add(new Pair<>(currentWord, subTree.get(currentWord)));
            subTree = subTree.headMap(currentWord);
        }
        freqDict.sort(new PairComparator());
        if (freqDict.size() < wordsCount)
            return freqDict;
        return freqDict.subList(0, wordsCount);
    }
}
