//package com.equalinformation.poc.akka.scala.track1.future
//
//import akka.actor.{ActorSystem, Props}
//
///**
//  * Created by bpupadhyaya on 2/12/16.
//  */
//case class Order(userId: Int, orderNo: Int, amount: Float, noOfItems: Int)
//case class Address(userId: Int, fullName: String, address1: String, address2: String)
//case class OrderHistory(order: Order, address: Address)
//
//object TestActorSystem {
//
//  def main(args: Array[String]): Unit = {
//
//    val _system = ActorSystem("FutureUsageExample")
//    val processOrder = _system.actorOf(Props[ProcessOrderActor])
//    processOrder ! 456
//    Thread.sleep(5000)
//    _system.shutdown
//  }
//}
