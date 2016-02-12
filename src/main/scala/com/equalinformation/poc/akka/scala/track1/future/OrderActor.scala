package com.equalinformation.poc.akka.scala.track1.future

import akka.actor.Actor

/**
  * Created by bpupadhyaya on 2/12/16.
  */
class OrderActor extends Actor {

  def receive = {
    case userId: Int =>
      sender ! new Order(userId, 123, 345, 5)
  }
}
