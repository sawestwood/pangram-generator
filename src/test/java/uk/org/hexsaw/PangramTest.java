package uk.org.hexsaw;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PangramTest {

    private final String CLASSIC_PANGRAM = "The quick brown fox jumps over the lazy dog";
    private final String INCORRECT_PANGRAM = "The brown fox jumps over the lazy dog";


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
        assertThat(pangramSentence.equals(CLASSIC_PANGRAM), is(true));
    }
}
