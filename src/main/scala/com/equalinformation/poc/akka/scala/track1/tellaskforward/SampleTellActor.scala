package com.equalinformation.poc.akka.scala.track1.tellaskforward

import akka.actor.{Actor, ActorLogging}

/**
  * Created by bpupadhyaya on 2/12/16.
  */
class SampleTellActor extends Actor with ActorLogging {
  def receive = {
    case message: String => {
      log.info("message received", message)
      sender ! message // ! is equivalent to tell
    }

    case _ => log.info("Unknown message")

  }
}
