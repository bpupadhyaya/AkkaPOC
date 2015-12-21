package com.equalinformation.poc.akka.scala

/**
  * Created by bpupadhyaya on 12/20/15.
  */
object SampleScalaActorApp {
  def main(args: Array[String]): Unit = {
    akka.Main.main(Array(classOf[SampleScalaActor].getName))
  }
}
