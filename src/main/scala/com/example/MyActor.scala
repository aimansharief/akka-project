package com.example

import akka.actor.Actor

class MyActor extends Actor {
  def receive = { //defines the behaviour of the actor when it receives messages
    case "hello" => println("Hello World!")
    case name :String  =>
      println("name of sender :" + name)
      val count = name.length
      sender ! count.toString
      sender ! count.toString
    case _ =>println("unknown message")
  }
}
