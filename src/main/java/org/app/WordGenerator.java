package org.app;

import java.security.SecureRandom;
import java.util.List;

public class WordGenerator {

    private final List<String> words;
    private final SecureRandom secureRandom;

    public WordGenerator(List<String> words, SecureRandom secureRandom) {
        if (words == null || words.isEmpty()) {
            throw new IllegalArgumentException("the list is empty or null");
        }
        this.words = words;
        this.secureRandom = secureRandom;
    }

    public String getRandomWord() {
        int index = secureRandom.nextInt(words.size());
        return words.get(index);
    }

    public String getWord(int index) {
        return words.get(index);
    }
}
