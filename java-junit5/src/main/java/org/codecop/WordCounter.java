package org.codecop;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * Counts words of a text and provides basic analysis of that.
 */
public class WordCounter {

    private final List<String> words;

    public WordCounter(String sentence) {
        words = new ArrayList<>(Arrays.asList(sentence.split("\\s+")));
    }

    /**
     * Load words from a text file.
     */
    public WordCounter(File wordFile) throws IOException {
        this(StringToFile.read(wordFile));
    }

    public int numberOfWords() {
        // here some hard core calculation...
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignore) {
            Thread.currentThread().interrupt();
        }
        return words.size();
    }

    /**
     * @return unique words sorted alphabetically.
     */
    public String[] uniqueWords() {
        List<String> uniqueWords = new ArrayList<>(new HashSet<>(words));
        Collections.sort(uniqueWords);
        return uniqueWords.toArray(new String[uniqueWords.size()]);
    }

    public Iterable<String> uniqueWordsAsSequence() {
        return Arrays.asList(uniqueWords());
    }

    public boolean containsWord(String word) {
        return words.contains(word);
    }

    public Integer countOf(String word) {
        int sum = (int) words.stream(). //
                filter(word::equals). //
                count();

        if (sum > 0) {
            return sum;
        }
        return null;
    }

    /**
     * @return ratio of this word's occurrence against all words.
     */
    public double ratioOf(String word) {
        Integer count = countOf(word);
        if (count == null) {
            throw new IllegalArgumentException(word + " not in sentence");
        }
        return 1.0 * count / numberOfWords();
    }

    public Summary summaryOf(String word) {
        return new Summary(word, countOf(word));
    }

    public static class Summary {
        public final String word;
        public final int count;

        public Summary(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
}
