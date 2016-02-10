package com.equalinformation.poc.akka.java.track1.wordcount.messages;

/**
 * Created by bpupadhyaya on 2/10/16.
 */
public final class  WordCount {
    private final String word;
    private final Integer count;

    public WordCount(String inWord, Integer inCount) {
        word = inWord;
        count = inCount;
    }

    public String getWord() {
        return word;
    }

    public Integer getCount() {
        return count;
    }
}