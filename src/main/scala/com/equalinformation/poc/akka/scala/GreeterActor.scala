package com.equalinformation.poc.akka.scala

import akka.actor.Actor

/**
  * Created by bpupadhyaya on 12/20/15.
  */
object Greeter {
  case object Greet
  case object Done
}

class GreeterActor extends Actor {
  def receive = {
    case Greeter.Greet =>
      println("First actor application")
      sender() ! Greeter.Done
  }
}