package com.equalinformation.poc.akka.scala.track1.tellaskforward

import akka.actor
import akka.actor.Actor

/**
  * Created by bpupadhyaya on 2/12/16.
  */
class SampleForwardActor extends Actor {
  def receive =  {
    case message: String => {
//      actor.forward(message)
    }
  }

}
