package example.akka

import akka.actor.ActorSystem
import akka.actor.Actor
import akka.event.Logging
import akka.actor.ActorRef

object mysystem {
  lazy val ourSystem = ActorSystem("OurExampleSystem")
}

class Pongy extends Actor {
  val log = Logging(context.system, this)
  
  def receive = {
    case "ping" => 
      log.info("Got a ping -- ponging back!")
      sender ! "pong"
      context.stop(self)
  }
  
  override def postStop() = log.info("pongy going down")
}

class Pingy extends Actor {
  val log = Logging(context.system, this)
  
  def receive = {
    case pongyRef: ActorRef =>
      pongyRef ! "ping"
    case "pong" => 
      log.info("Got a ping -- ponging back!")
      sender ! "pong"
      context.stop(self)
  }
  
  override def postStop() = log.info("pingy going down")
}