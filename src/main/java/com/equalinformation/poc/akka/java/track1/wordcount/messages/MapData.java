package com.equalinformation.poc.akka.java.track1.wordcount.messages;

import java.util.List;

/**
 * Created by bpupadhyaya on 2/10/16.
 */
public final class MapData {
    private final List<WordCount> dataList;

    public MapData(List<WordCount> dataList) {
        this.dataList = dataList;
    }

    public List<WordCount> getDataList() {
        return dataList;
    }

}