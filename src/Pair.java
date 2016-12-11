import java.util.Comparator;

/**
 * Created by melon on 10.12.16.
 */

class PairComparator implements Comparator<Pair<String, Integer>> {
    @Override
    public int compare(Pair<String, Integer> a, Pair<String, Integer> b) {
        if (a.count.equals(b.count))
            return a.word.compareTo(b.word);
        return b.count.compareTo(a.count);
    }
}

public class Pair<L,R> {
    public L word;
    public R count;

    public Pair(L word, R count) {
        this.word = word;
        this.count = count;
    }
    @Override
    public String toString() {
        return word.toString() + " " + count.toString();
    }
}