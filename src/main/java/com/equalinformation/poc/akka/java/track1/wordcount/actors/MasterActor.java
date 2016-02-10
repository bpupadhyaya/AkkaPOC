package com.equalinformation.poc.akka.java.track1.wordcount.actors;

import akka.actor.UntypedActor;

/**
 * Created by bpupadhyaya on 2/10/16.
 */

public class MasterActor extends UntypedActor {
    //TODO migrate akka code to version in sbt
//    ActorRef mapActor = getContext().actorOf(
//            new Props(MapActor.class).withRouter(new RoundRobinRouter(5)),    "map");
//    ActorRef reduceActor = getContext().actorOf(
//            new Props(ReduceActor.class).withRouter(new RoundRobinRouter(5)),"reduce");
//    ActorRef aggregateActor = getContext().actorOf(
//            new Props(AggregateActor.class), "aggregate");
    @Override
    public void onReceive(Object message) throws Exception {
        //TODO migrate
    }
//        if (message instanceof String) {
//            mapActor.tell(message,getSelf());
//        } else if (message instanceof MapData) {
//            reduceActor.tell(message,getSelf());
//        } else if (message instanceof ReduceData) {
//            aggregateActor.tell(message);
//        } else if (message instanceof Result) {
//            aggregateActor.forward(message, getContext());
//        } else
//            unhandled(message);
//    }
}
