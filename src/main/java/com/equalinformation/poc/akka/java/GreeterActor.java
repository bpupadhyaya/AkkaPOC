package com.equalinformation.poc.akka.java;

import akka.actor.UntypedActor;

/**
 * Created by bpupadhyaya on 12/20/15.
 */
public class GreeterActor extends UntypedActor {

    public static enum Msg {
        GREET, DONE;
    }

    @Override
    public void onReceive(Object msg) {
        if (msg == Msg.GREET) {
            System.out.println("First actor application");
            getSender().tell(Msg.DONE, getSelf());
        } else
            unhandled(msg);
    }
}