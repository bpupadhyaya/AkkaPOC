package com.equalinformation.poc.akka.java.track1.wordcount.actors;

import akka.actor.UntypedActor;
import com.equalinformation.poc.akka.java.track1.wordcount.messages.MapData;
import com.equalinformation.poc.akka.java.track1.wordcount.messages.ReduceData;
import com.equalinformation.poc.akka.java.track1.wordcount.messages.WordCount;

import java.util.HashMap;
import java.util.List;

/**
 * Created by bpupadhyaya on 2/10/16.
 */
public class ReduceActor extends UntypedActor {

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof MapData) {
            MapData mapData = (MapData) message;
            // reduce the incoming data and forward the result to Master actor
//            getSender().tell(reduce(mapData.getDataList())); //TODO migrate code to akka version in sbt
        } else
            unhandled(message);
    }

    private ReduceData reduce(List<WordCount> dataList) {
        HashMap<String, Integer> reducedMap = new HashMap<String, Integer>();
        for (WordCount wordCount : dataList) {
            if (reducedMap.containsKey(wordCount.getWord())) {
                Integer value = (Integer) reducedMap.get(wordCount.getWord());
                value++;
                reducedMap.put(wordCount.getWord(), value);
            } else {
                reducedMap.put(wordCount.getWord(), Integer.valueOf(1));
            }
        }
        return new ReduceData(reducedMap);
    }
}
