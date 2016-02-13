package com.equalinformation.poc.akka.java.track1.future;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

/**
 * Created by bpupadhyaya on 2/12/16.
 */
public class TestActorSystem {

    public static void main(String[] args) throws Exception {
        ActorSystem _system = ActorSystem.create("FutureUsage");
        ActorRef processOrder = _system.actorOf(Props.create(
                ProcessOrderActor.class));
        processOrder.tell(Integer.valueOf(456), processOrder); //TODO ??

        Thread.sleep(5000);

        _system.shutdown();
    }

}
