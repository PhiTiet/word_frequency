package nl.phi.wordfrequency.analyzer;

import nl.phi.wordfrequency.comparator.WordFrequencyComparator;
import nl.phi.wordfrequency.pojo.WordFrequency;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class WordFrequencyAnalyzerImpl implements WordFrequencyAnalyzer {
    @Override
    public int calculateHighestFrequency(String text) {
        List<WordFrequency> frequencies = vocabularyToSortedList(getFrequencies(text));
        if (frequencies.isEmpty()) {
            return 0;
        }
        return frequencies.get(0).getFrequency();
    }

    @Override
    public int calculateFrequencyForWord(String text, String word) {
        HashMap<String, Integer> frequencies = getFrequencies(text);
        if (frequencies.isEmpty() || !frequencies.containsKey(word)) {
            return 0;
        }
        return frequencies.get(word.toLowerCase());
    }

    @Override
    public List<WordFrequency> calculateMostFrequentNWords(String text, int n) {
        List<WordFrequency> frequencies = vocabularyToSortedList(getFrequencies(text));
        if (n > frequencies.size()) {
            return frequencies;
        }
        return frequencies.subList(0, n);
    }

    private HashMap<String, Integer> getFrequencies(String text) {
        HashMap<String, Integer> vocab = new HashMap<>();

        Pattern pattern = Pattern.compile("[a-z]+");
        Matcher matcher = pattern.matcher(text.toLowerCase());

        while (matcher.find()) {
            String currentWord = matcher.group();
            vocab.put(currentWord, vocab.getOrDefault(currentWord, 0) + 1);
        }
        return vocab;
    }

    private List<WordFrequency> vocabularyToSortedList(HashMap<String, Integer> vocab) {
        List<WordFrequency> wordFrequencies = new ArrayList<>();
        for (var entry : vocab.entrySet()) {
            wordFrequencies.add(new WordFrequency(entry.getKey(), entry.getValue()));
        }
        wordFrequencies.sort(new WordFrequencyComparator());
        return wordFrequencies;
    }

}
