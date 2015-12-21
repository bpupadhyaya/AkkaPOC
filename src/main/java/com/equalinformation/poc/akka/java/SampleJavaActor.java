package com.equalinformation.poc.akka.java;

import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.actor.ActorRef;

/**
 * Created by bpupadhyaya on 12/20/15.
 */
public class SampleJavaActor extends UntypedActor {
    @Override
    public void preStart() {
        // create the greeter actor
        final ActorRef greeterActor = getContext().actorOf(Props.create(GreeterActor.class), "greeter");
        // tell it to perform the greeting
        greeterActor.tell(GreeterActor.Msg.GREET, getSelf());
    }

    @Override
    public void onReceive(Object msg) {
        if (msg == GreeterActor.Msg.DONE) {
            // when the greeter is done, stop this actor and with it the application
            getContext().stop(getSelf());
        } else
            unhandled(msg);
    }
}