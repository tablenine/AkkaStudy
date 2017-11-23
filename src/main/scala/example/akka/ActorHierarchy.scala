package example.akka

import akka.actor.ActorSystem
import akka.actor.Props

object ActorHierarchy extends App {
  val ourSystem = ActorSystem("mysystem")

  val parent = ourSystem.actorOf(Props[ParentActor], "parent")

  parent ! "create"
  parent ! "create"
  parent ! "create"

  Thread.sleep(1000)

  parent ! "hi"
  Thread.sleep(1000)

  parent ! "stop"
  Thread.sleep(1000)

  ourSystem.terminate()
}