package uk.org.hexsaw;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PangramTest {

    private static final Logger logger = LoggerFactory.getLogger(PangramTest.class.getName());

    private final String CLASSIC_PANGRAM = "The quick brown fox jumps over the lazy dog";
    private final String INCORRECT_PANGRAM = "The brown fox jumps over the lazy dog";

    private List<String> loadTop10000WordsFromFile() {

        List<String> words = null;

        Path path = Paths.get("src/test/resources/google-10000-english.txt");
        try {
            words = new ArrayList<>(Files.readAllLines(path));
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
       return words;
    }

    @Test
    public void thatSentenceContainsAllLettersOfAlphabet() {
        assertThat(Pangram.isPangram(CLASSIC_PANGRAM), is(true));
    }

    @Test
    public void thatSentenceDoesNotContainsAllLettersOfAlphabet() {
        assertThat(Pangram.isPangram(INCORRECT_PANGRAM), is(false));
    }

    @Test
    public void canGenerateAPangram() {
        String pangramSentence = Pangram.generatePangram(Arrays.asList(CLASSIC_PANGRAM.split(" ")));
        assertThat(Pangram.isPangram(CLASSIC_PANGRAM), is(true));
        assertThat(pangramSentence.equals(CLASSIC_PANGRAM), is(true));
    }

    @Test
    public void canGenerateAPangramUsingFileOfCommonlyUsedWords() {
        String pangramSentence = Pangram.generatePangram(loadTop10000WordsFromFile());
        logger.info("Sentence generated was [" + "pangramSentence + " + "]");
        assertThat(Pangram.isPangram(pangramSentence), is(true));
    }


}
