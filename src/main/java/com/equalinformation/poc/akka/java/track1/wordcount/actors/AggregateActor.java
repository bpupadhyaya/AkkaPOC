package com.equalinformation.poc.akka.java.track1.wordcount.actors;

import akka.actor.UntypedActor;
import com.equalinformation.poc.akka.java.track1.wordcount.messages.ReduceData;
import com.equalinformation.poc.akka.java.track1.wordcount.messages.Result;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bpupadhyaya on 2/10/16.
 */
public class AggregateActor extends UntypedActor {
    private Map<String, Integer> finalReducedMap = new HashMap<String, Integer>();

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof ReduceData) {
            ReduceData reduceData = (ReduceData) message;
            aggregateInMemoryReduce(reduceData.getReduceDataList());
        } else if (message instanceof Result) {
//            getSender().tell(finalReducedMap.toString()); //TODO akka code migration to version in sbt
        } else
            unhandled(message);
    }

    private void aggregateInMemoryReduce(Map<String, Integer> reducedList) {
        Integer count = null;
        for (String key : reducedList.keySet()) {
            if (finalReducedMap.containsKey(key)) {
                count = reducedList.get(key) + finalReducedMap.get(key);
                finalReducedMap.put(key, count);
            } else {
                finalReducedMap.put(key, reducedList.get(key));
            }
        }
    }
}
