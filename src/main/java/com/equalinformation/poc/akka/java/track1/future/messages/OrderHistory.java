package com.equalinformation.poc.akka.java.track1.future.messages;

/**
 * Created by bpupadhyaya on 2/12/16.
 */
public class OrderHistory {

    Order order;
    Address address;

    public OrderHistory(Order inOrder, Address inAddress) {
        order = inOrder;
        address = inAddress;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
