package com.equalinformation.poc.akka.java.track1.wordcount;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.pattern.Patterns;
import akka.util.Timeout;
import com.equalinformation.poc.akka.java.track1.wordcount.actors.MasterActor;
import com.equalinformation.poc.akka.java.track1.wordcount.messages.Result;
import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;

import java.util.concurrent.TimeUnit;


/**
 * Created by bpupadhyaya on 2/10/16.
 */
public class WordCountMapReduceApplication {

    public static void main(String[] args) throws Exception {

        Timeout timeout = new Timeout(Duration.create(5, TimeUnit.SECONDS));
        ActorSystem _system = ActorSystem.create("MapReduceApp");
        ActorRef master = _system.actorOf(Props.create(MasterActor.class), "master");
//        master.tell("The quick brown fox tried to jump over the lazy dog and fell on the dog"); // old version
        master.tell("The quick brown fox tried to jump over the lazy dog and fell on the dog", master); //TODO getSelf() or suitable ActorRef
        master.tell("Dog is man's best friend", master); // TODO getSelf() or suitable ActorRef
        master.tell("Dog and Fox belong to the same family", master); //TODO getSelf() or suitable ActorRef
        Thread.sleep(5000);
        Future<Object> future = Patterns.ask(master, new Result(), timeout);
        String result = (String) Await.result(future, timeout.duration());
        System.out.println(result);
        _system.shutdown();
    }

}
