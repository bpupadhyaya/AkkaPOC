package com.equalinformation.poc.akka.scala.track1.wordcount

import java.util.concurrent.TimeUnit

import scala.collection.immutable.Map
import scala.collection.mutable.ArrayBuffer

import akka.actor.actorRef2Scala
import akka.actor.ActorSystem
import akka.actor.Props

import scala.concurrent.Await

//import akka.dispatch.Await
import akka.pattern.ask
//import akka.util.duration.intToDurationInt
import akka.util.Timeout

import com.equalinformation.poc.akka.scala.track1.wordcount.actors.MasterActor;

/**
  * Created by bpupadhyaya on 2/10/16.
  */
sealed trait MapReduceMessage
case class WordCount(word: String, count: Int) extends MapReduceMessage
case class MapData(dataList: ArrayBuffer[WordCount]) extends MapReduceMessage
case class ReduceData(reduceDataMap: Map[String, Int]) extends MapReduceMessage
//case class Result() extends MapReduceMessage // older version allowed this
case class Result(nothing: Int) extends MapReduceMessage

object MapReduceApplication extends App {
  val _system = ActorSystem("MapReduceApp")
  val master = _system.actorOf(Props[MasterActor], name = "master")
  implicit val timeout = Timeout(5,TimeUnit.SECONDS)

  master ! "The quick brown fox tried to jump over the lazy dog and fell on the dog"
  master ! "Dog is man's best friend"
  master ! "Dog and Fox belong to the same family"

  Thread.sleep(500)

  val future = (master ? Result).mapTo[String]
  val result = Await.result(future, timeout.duration)
  println(result)
  _system.shutdown
}
