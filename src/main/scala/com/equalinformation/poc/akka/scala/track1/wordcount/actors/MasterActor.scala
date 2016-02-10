package com.equalinformation.poc.akka.scala.track1.wordcount.actors

import akka.actor.{Props, Actor}

//import akka.routing.RoundRobinRouter // TODO find how to include this

import com.equalinformation.poc.akka.scala.track1.wordcount._

/**
  * Created by bpupadhyaya on 2/10/16.
  */
class MasterActor extends Actor {
//  val mapActor = context.actorOf(Props[MapActor].withRouter(RoundRobinRouter(nrOfInstances = 5)), name = "map") //TODO find how to tranform and use it
//  val reduceActor = context.actorOf(Props[ReduceActor].withRouter(RoundRobinRouter(nrOfInstances = 5)), name = "reduce") //TODO same as above
  val mapActor = context.actorOf(Props[MapActor], name = "map")
  val reduceActor = context.actorOf(Props[ReduceActor], name = "reduce")
  val aggregateActor = context.actorOf(Props[AggregateActor], name = "aggregate")

  def receive: Receive = {
    case line: String => mapActor ! line
    case mapData: MapData => reduceActor ! mapData
    case reduceData: ReduceData => aggregateActor ! reduceData
    case Result => aggregateActor forward Result
  }
}
