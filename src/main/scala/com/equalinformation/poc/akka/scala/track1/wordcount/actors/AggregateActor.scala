package com.equalinformation.poc.akka.scala.track1.wordcount.actors

import akka.actor.Actor
import scala.collection.immutable.Map
import scala.collection.mutable.HashMap

import com.equalinformation.poc.akka.scala.track1.wordcount._


/**
  * Created by bpupadhyaya on 2/10/16.
  */
class AggregateActor extends Actor {
  val finalReducedMap = new HashMap[String, Int]
  def receive: Receive = {
    case ReduceData(reduceDataMap) =>
      aggregateInMemoryReduce(reduceDataMap)
    case Result =>
      sender ! finalReducedMap.toString()
  }
  def aggregateInMemoryReduce(reducedList: Map[String, Int]): Unit = {
    for ((key,value) <- reducedList) {
      if (finalReducedMap contains key)
        finalReducedMap(key) = (value + finalReducedMap.get(key).get)
      else
        finalReducedMap += (key -> value)
    }
  }
}