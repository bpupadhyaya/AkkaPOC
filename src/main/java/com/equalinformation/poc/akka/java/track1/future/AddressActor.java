package com.equalinformation.poc.akka.java.track1.future;

import akka.actor.UntypedActor;
import com.equalinformation.poc.akka.java.track1.future.messages.Address;

/**
 * Created by bpupadhyaya on 2/12/16.
 */
public class AddressActor extends UntypedActor {

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof Integer) {
            Integer userId = (Integer) message;
            // ideally we will get address for given user id
            Address address = new Address(userId, "Bhim Upadhyaya",
                    "Sunnyvale", "CA, USA");
            getSender().tell(address, getSelf());
        }
    }
}
