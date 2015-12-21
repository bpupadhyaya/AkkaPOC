package com.equalinformation.poc.akka.scala

import akka.actor.Actor
import akka.actor.Props

/**
  * Created by bpupadhyaya on 12/20/15.
  */
class SampleScalaActor extends Actor {
  override def preStart(): Unit = {
    // create the greeter actor
    val greeterActor = context.actorOf(Props[GreeterActor], "greeter")
    // tell it to perform the greeting
    greeterActor ! Greeter.Greet
  }

  def receive = {
    // when the greeter is done, stop this actor and with it the application
    case Greeter.Done => context.stop(self)
  }
}
