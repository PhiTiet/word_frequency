package nl.phi.wordfrequency.analyzer;

import nl.phi.wordfrequency.pojo.WordFrequency;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
public class WordFrequencyAnalyzerTests {

    @InjectMocks
    private WordFrequencyAnalyzerImpl wordFrequencyAnalyzer;

    String testString = "aword-cword-aword123:;,.123aword123bword123dword123dword";

    @Test
    @DisplayName("calculateHighestFrequency(String text)")
    void testCalculateHighestFrequency() {
        assertEquals(3, wordFrequencyAnalyzer.calculateHighestFrequency(testString));
        assertEquals(0, wordFrequencyAnalyzer.calculateHighestFrequency(""));
    }

    @Test
    @DisplayName("calculateFrequencyForWord(String text, String word)")
    void testCalculateFrequencyForWord() {
        assertEquals(3, wordFrequencyAnalyzer.calculateFrequencyForWord(testString, "aword"));
        assertEquals(1, wordFrequencyAnalyzer.calculateFrequencyForWord(testString, "bword"));
        assertEquals(1, wordFrequencyAnalyzer.calculateFrequencyForWord(testString, "cword"));
        assertEquals(2, wordFrequencyAnalyzer.calculateFrequencyForWord(testString, "dword"));

        assertEquals(0, wordFrequencyAnalyzer.calculateFrequencyForWord(testString, "123"));
        assertEquals(0, wordFrequencyAnalyzer.calculateFrequencyForWord(testString, ""));
    }

    @Test
    @DisplayName("calculateMostFrequentNWords(String text, int n)")
    void testCalculateMostFrequentNWords() {
        List<WordFrequency> expectedFrequencies = new ArrayList<>();
        expectedFrequencies.add(new WordFrequency("aword", 3));
        expectedFrequencies.add(new WordFrequency("dword", 2));
        expectedFrequencies.add(new WordFrequency("bword", 1));
        expectedFrequencies.add(new WordFrequency("cword", 1));

        assertEquals(expectedFrequencies, wordFrequencyAnalyzer.calculateMostFrequentNWords(testString, 10000));
        assertEquals(expectedFrequencies.subList(0, 2), wordFrequencyAnalyzer.calculateMostFrequentNWords(testString, 2));
        assertEquals(expectedFrequencies.subList(0, 3), wordFrequencyAnalyzer.calculateMostFrequentNWords(testString, 3));
        assertEquals(new ArrayList<WordFrequency>(), wordFrequencyAnalyzer.calculateMostFrequentNWords(testString, 0));

    }
}
