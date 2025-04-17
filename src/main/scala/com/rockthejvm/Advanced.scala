package com.rockthejvm

import scala.concurrent.Future
import scala.util.{Failure, Success, Try}
import scala.concurrent.ExecutionContext.Implicits.global

object Advanced extends App {

  /*
     Lazy evaluation - an expression is not evaluated until it's first use
   */
  // useful in infinite collections

  lazy val aLazyValue = 2
  lazy val aLazyValueWithSideEffect = {
    println("I'm so very lazy")
    43
  }

  val eagerValue  = aLazyValueWithSideEffect + 1

  /*
    "Pseudo collections": Option, Try -> Can be used with map, flatmap and filter
   */

  def methodWhichCanReturnNull(): String = "Hello Scala"
  val anOption = Option(methodWhichCanReturnNull()) // Some("Hello Scala")
  // option = "collection" which contains at most one element: Some(value) or None

  val stringProcessing = anOption match {
    case Some(value) => s"I have obtained a valid string: $value"
    case None => "I have found nothing"
  }

  def methodWhichCanThrowException(): String = throw new RuntimeException("Exception occurred")
  val aTry = Try(methodWhichCanThrowException())

  // A Try is a "collection" with either a value if the code went well or an exception if occurred
  val anotherTry = aTry match {
    case Success(value) => s"I have obtained the result as valid string: $value"
    case Failure(exception) => s"I have obtained an exception: $exception"
  }

  /*
    Evaluate something on other thread
    Asynchronous programming
   */

  val aFuture = Future({
    println("Loading...")
    Thread.sleep(1000)
    println("I have computed a value.")
    67
  })

  // Future is a "collection" which contains a value when it is evaluated
  // Future is composable with map, flatmap and filter
  // The Future, Try and Option are called monads in functional programming

  /*
    Implicits Basics
   */

  // 1: Implicit Arguments
  def aMethodWithImplicitArgs(implicit arg: Int) = arg + 1
  implicit val myImplicitInt = 47
  println(aMethodWithImplicitArgs)

  // 2: Implicit conversions
  implicit class MyRichInteger(n : Int) {
    def isEven() = n % 2 == 0
  }

  println(22.isEven()) // new MyRichInteger(23).isEven()
}
