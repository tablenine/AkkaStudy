package example.akka

import akka.event.Logging
import akka.actor.Props
import akka.actor.Actor

class ParentActor extends Actor {
  val log = Logging(context.system, this)

  def receive = {
    case "create" => context.actorOf(Props[ChildActor])
    case "hi" =>
      log.info("Kids, say hi!!")
      context.children.foreach { c => c ! "hi" }
    case "stop" =>
      log.info("parent stopping")
      context.stop(self)
      log.info("parent stoped")
  }
}