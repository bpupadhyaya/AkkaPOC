package com.equalinformation.poc.akka.scala.track1.wordcount.actors

import akka.actor.Actor

import com.equalinformation.poc.akka.scala.track1.wordcount._

/**
  * Created by bpupadhyaya on 2/10/16.
  */
class ReduceActor extends Actor {
  def receive: Receive = {
    case MapData(dataList) =>
      sender ! reduce(dataList)
  }
  def reduce(words: IndexedSeq[WordCount]): ReduceData = ReduceData {
    words.foldLeft(Map.empty[String, Int]) {  (index, words) =>
      if (index contains words.word)
        index + (words.word -> (index.get(words.word).get + 1))
      else
        index + (words.word -> 1)
    }
  }
}
