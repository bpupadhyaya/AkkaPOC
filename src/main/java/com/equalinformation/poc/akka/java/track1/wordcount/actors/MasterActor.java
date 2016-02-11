package com.equalinformation.poc.akka.java.track1.wordcount.actors;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import com.equalinformation.poc.akka.java.track1.wordcount.messages.MapData;
import com.equalinformation.poc.akka.java.track1.wordcount.messages.ReduceData;
import com.equalinformation.poc.akka.java.track1.wordcount.messages.Result;

/**
 * Created by bpupadhyaya on 2/10/16.
 */

public class MasterActor extends UntypedActor {
    //TODO migrate akka code to version in sbt
//    ActorRef mapActor = getContext().actorOf(new Props(MapActor.class).withRouter(new RoundRobinRouter(5)), "map"); //old version
//    ActorRef reduceActor = getContext().actorOf(new Props(ReduceActor.class).withRouter(new RoundRobinRouter(5)),"reduce"); // old version
    ActorRef mapActor = getContext().actorOf(Props.create(MapActor.class), "map");
    ActorRef reduceActor = getContext().actorOf(Props.create(ReduceActor.class),"reduce");
    ActorRef aggregateActor = getContext().actorOf(Props.create(AggregateActor.class), "aggregate");

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof String) {
            mapActor.tell(message,getSelf());
        } else if (message instanceof MapData) {
            reduceActor.tell(message,getSelf());
        } else if (message instanceof ReduceData) {
//            aggregateActor.tell(message); // old version
            aggregateActor.tell(message, getSelf());
        } else if (message instanceof Result) {
            aggregateActor.forward(message, getContext());
        } else
            unhandled(message);
    }

}
