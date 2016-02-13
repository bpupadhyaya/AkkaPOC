package com.equalinformation.poc.akka.java.track1.future;

import akka.actor.UntypedActor;
import com.equalinformation.poc.akka.java.track1.future.messages.OrderHistory;

/**
 * Created by bpupadhyaya on 2/12/16.
 */
public class OrderAggregateActor extends UntypedActor {

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof OrderHistory) {
            OrderHistory orderHistory = (OrderHistory) message;
            System.out.println("Order History -> " + orderHistory.getOrder()
                    + "\n" + orderHistory.getAddress());
        }
    }
}
