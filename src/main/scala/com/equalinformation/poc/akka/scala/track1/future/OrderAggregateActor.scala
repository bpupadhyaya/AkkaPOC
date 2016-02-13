package com.equalinformation.poc.akka.scala.track1.future

import akka.actor.Actor

/**
  * Created by bpupadhyaya on 2/12/16.
  */
class OrderAggregateActor extends Actor {
  def receive = {
    case orderHistory: OrderHistory =>
      println(orderHistory.toString())
  }
}
