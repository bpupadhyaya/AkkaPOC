package com.equalinformation.poc.akka.java.track1.wordcount.messages;

import java.util.HashMap;

/**
 * Created by bpupadhyaya on 2/10/16.
 */
public final class ReduceData {
    private final HashMap<String, Integer> reduceDataList;

    public ReduceData(HashMap<String, Integer> reduceDataList) {
        this.reduceDataList = reduceDataList;
    }

    public HashMap<String, Integer> getReduceDataList() {
        return reduceDataList;
    }

}
