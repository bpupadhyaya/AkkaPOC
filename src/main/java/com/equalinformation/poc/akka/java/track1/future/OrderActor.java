package com.equalinformation.poc.akka.java.track1.future;

import akka.actor.UntypedActor;
import com.equalinformation.poc.akka.java.track1.future.messages.Order;

/**
 * Created by bpupadhyaya on 2/12/16.
 */
public class OrderActor extends UntypedActor {

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof Integer) {
            Integer userId = (Integer) message;
            // ideally we will get list of orders for given user id
            Order order = new Order(Integer.valueOf(123), Float.valueOf(345),
                    Integer.valueOf(5));
            getSender().tell(order, getSelf());
        }
    }
}
