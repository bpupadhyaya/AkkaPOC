package com.equalinformation.poc.akka.scala.track1.future

import java.util.concurrent.TimeUnit

import akka.actor.Actor
import akka.actor.Props
import akka.pattern.ask
import akka.pattern.pipe
import akka.util.Timeout
//import akka.util.duration._
//import akka.dispatch.Future


import scala.concurrent.Future

/**
  * Created by bpupadhyaya on 2/12/16.
  */
class ProcessOrderActor extends Actor {

  implicit val timeout = Timeout(5, TimeUnit.SECONDS)
  val orderActor = context.actorOf(Props[OrderActor])
  val addressActor = context.actorOf(Props[AddressActor])
  val orderAggregateActor = context.actorOf(Props[OrderAggregateActor])

  def receive = {
    case userId: Integer =>
      val aggResult: Future[OrderHistory] =
        for {
          order <- ask(orderActor, userId).mapTo[Order] // call pattern directly
          address <- addressActor ask userId mapTo manifest[Address] // call by implicit conversion
        } yield OrderHistory(order, address)
//      aggResult pipeTo orderAggregateActor // TODO Check the syntax
  }
}