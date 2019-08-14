package uk.org.hexsaw;

import java.util.*;
import java.util.stream.IntStream;

public class Pangram {

    // Assume en_gb basic letters a...z
    private final static int ALPHABET_LETTER_COUNT = 26;

    public static String generatePangram(List<String> words) {
        List<String> wordsInSentence = new ArrayList<>();
        Set<Character> charsInSentence = new HashSet<Character>();
        for (String word : words) {

            Set<Character> charsInWord = new HashSet<>();
            IntStream.range(0, word.toLowerCase().length()).forEach(i -> charsInWord.add(word.charAt(i)));

            charsInWord.removeAll(charsInSentence);
            if (charsInWord.size() > 0) {
                // Word contains letter we can use
                wordsInSentence.add(word);
            }
            if (charsInSentence.size() == ALPHABET_LETTER_COUNT) {
                break;
            }
        }
        return String.join(" ", wordsInSentence);
    }

    public static boolean isPangram(String sentence) {
        long c = sentence.toLowerCase().chars()
                .filter(ch -> ch >= 'a' && ch <= 'z')
                .distinct()
                .count();
        return c == ALPHABET_LETTER_COUNT;
    }

}

