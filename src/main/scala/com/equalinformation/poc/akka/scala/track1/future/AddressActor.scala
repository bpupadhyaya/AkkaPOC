package com.equalinformation.poc.akka.scala.track1.future

import akka.actor.Actor

/**
  * Created by bpupadhyaya on 2/12/16.
  */
class AddressActor extends Actor {

  def receive = {
    case userId: Int =>
      sender ! new Address(userId, "Bhim Upadhyaya", "Wildwood Ave", "Sunnyvale, CA, USA")
  }
}
