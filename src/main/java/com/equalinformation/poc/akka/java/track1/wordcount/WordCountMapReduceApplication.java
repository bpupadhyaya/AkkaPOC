package com.equalinformation.poc.akka.java.track1.wordcount;

//import akka.dispatch.Await;
//import akka.dispatch.Future;
//import akka.util.Duration;


/**
 * Created by bpupadhyaya on 2/10/16.
 */
public class WordCountMapReduceApplication {

    public static void main(String[] args) throws Exception {
        //TODO Akka version migration
//        Timeout timeout = new Timeout(Duration.parse("5 seconds"));
//        ActorSystem _system = ActorSystem.create("MapReduceApp");
//        ActorRef master = _system.actorOf(new Props(MasterActor.class),
//                "master");
//        master.tell("The quick brown fox tried to jump over the lazy dog and fell on the dog");
//        master.tell("Dog is man's best friend");
//        master.tell("Dog and Fox belong to the same family");
//        Thread.sleep(5000);
//        Future<Object> future = Patterns.ask(master, new Result(), timeout);
//        String result = (String) Await.result(future, timeout.duration());
//        System.out.println(result);
//        _system.shutdown();
    }
}
