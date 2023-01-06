import akka.actor.ActorSystem
import akka.actor.Props
import akka.pattern.ask
import akka.util.Timeout
import com.example.MyActor

import scala.concurrent.Await
import scala.concurrent.duration.DurationInt
import scala.language.postfixOps


object Main extends App {
  val system = ActorSystem("MyActorSystem")
  //val myActor = system.actorOf(Props[MyActor], name = "myActor") //Props is a configuration class
  val myActor = system.actorOf(Props[MyActor].withDispatcher("akka.actor.my-dispatcher"), name = "myActor")
  implicit val timeout = Timeout(15 seconds)
  var name :String = "AIMAN"
  //myActor.tell("hello",myActor) //receiverActor.tell(msg,senderActor)):to send messages
  val future = myActor?name
  val result = Await.result(future, timeout.duration).asInstanceOf[String]
  println(s"number of chars: $result")

}
