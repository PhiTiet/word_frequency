package nl.phi.wordfrequency.comparator;

import nl.phi.wordfrequency.pojo.WordFrequency;

import java.util.Comparator;

public class WordFrequencyComparator implements Comparator<WordFrequency> {

    @Override
    public int compare(WordFrequency w1, WordFrequency w2) {
        if (w1.getFrequency() < w2.getFrequency()) {
            return 1;
        } else if (w1.getFrequency() == w2.getFrequency()) {
            return w1.getWord().compareTo(w2.getWord());
        } else {
            return -1;
        }
    }
}
