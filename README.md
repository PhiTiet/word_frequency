# WordFrequencyAnalyzer
## Tailed to the following specification:

Create a class which implements the following interface:
```
public interface WordFrequency {
String getWord();
int getFrequency();
}
```
Create a class which implements the following interface:

```
public interface WordFrequencyAnalyzer {
int calculateHighestFrequency(String text);
int calculateFrequencyForWord (String text, String word);
List<WordFrequency> calculateMostFrequentNWords (String text, int n);
}
```

Implement the three methods defined in this interface
- CalculateHighestFrequency should return the highest frequency in the text (several
words might have this frequency)
- CalculateFrequencyForWord should return the frequency of the specified word
- CalculateMostFrequentNWords should return a list of the most frequent „n‟ words in
the input text, all the words returned in lower case. If several words have the same
frequency, this method should return them in ascendant alphabetical order (for input
text “The sun shines over the lake” and n = 3, it should return the list {(“the”, 2),
(“lake”, 1), (“over”, 1) }
- Implement test cases for this class. You may use 3rd party frameworks to support your
  tests.
- Return deliverables as Github or Gitlab public repository
  

As a final note, please follow the instructions (which are not complicated) and perform the
  tasks on an industry-standard level.

## Frameworks used:
- Spring boot
- Junit / Jupiter

## How to run:
use
```mvn clean install```
or
```mvn test```
to verify the test cases.


