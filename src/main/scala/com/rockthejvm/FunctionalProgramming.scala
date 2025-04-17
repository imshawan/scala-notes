package com.rockthejvm

object FunctionalProgramming extends App {
  // Scala is OOP language
  class Person(name: String) {
    def apply(age: Int) = println(s" I have aged $age years")
  }

  val bob = new Person("Bob")
  bob.apply(43)
  bob(43) // Equal to bob.apply(43)

  /*
    Scala runs on the JVM
    Functional programming:
    - compose functions
    - pass functions as args
    - return functions as results

    Conclusion: FunctionX = Function1, Function2, ... Function22 (Max 22 arguments)
   */

  val simpleIncrementer = new Function1[Int, Int] { // A function that takes an Int and returns an Int
    override def apply(arg: Int): Int = arg + 1
  }

  simpleIncrementer.apply(23) // returns 24
  simpleIncrementer(23) // same as apply
  // defined a function

  // All Scala functions are instances of these Function_x types

  val stringConcatenator = new Function2[String, String, String] {
    override def apply(arg1: String, arg2: String): String = arg1 + " " + arg2
  }

  stringConcatenator("I love", "Scala")

  // Syntax sugars
  var doubler: Function1[Int, Int] = (x: Int) => 2 * x
  doubler(7)

  /*
    Behind the scenes:
    val doubler = new Function1[Int, Int] { // A function that takes an Int and returns an Int
      override def apply(arg: Int): Int = 2 * arg
     }

     doubler(7)
   */

  var doubler2: Int => Int = (x: Int) => 2 * x
  doubler2(7)

  /*
    Behind the scenes:
    val doubler2: Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(arg: Int): Int = 2 * arg
     }

     doubler2(7)
   */

  var doubler3 = (x: Int) => 2 * x
  doubler3(7)

  // Higher-order functions
  // Function that takes functions as args or return functions as results or both

  val mappedList = List(1,2,3).map(x => x + 1)
  // The application of a method on a list or any object that is due to modify the original object
  // will actually return another instance
  // this means that mappedList is very different from List(1,2,3)

  val flatMappedList = List(1,2,3).flatMap(x => List(x, 2*x))

  val flatMappedList2 = List(1,2,3).flatMap{ x =>
    List(x, 2*x)
  } // Alternative syntax

  val filteredList = List(1,2,3,4,5).filter(x => x <= 3)

  // Alternative syntax
  val filteredList2 = List(1,2,3,4,5).filter(_ <= 3)

  // All the pairs between numbers 1,2,3 and letters a,b,c
  val combinations = List(1,2,3).flatMap(num => List("A", "B", "C").map(char => s"$num-$char"))
  println(combinations)

  // "for" comprehensions
  val alternativePairs = for {
    number <- List(1,2,3)
    letter <- List("A", "B", "C")
  } yield s"$number-$letter" //  equivalent to the previous map/flatmap chain

  // Collections ->
  // Lists
  val list = List(1,2,3,4)
  val listHead = list.head
  val listRest = list.tail
  val prependedList = 0 :: list // similar to pushing element to first, returns List(0,1,2,3,4)
  val anExtendedList = 0 +: list :+ 5 // returns List(0,1,2,3,4,5)

  val maxNumber = list.reduce(_ max _)
  val minNumber = list.reduce(_ min _)
  val added = list.reduce((a, b) => a + b)
  val addedWithInitialValue = list.fold(0)((a, b) => a + b)

  // Sequences
  val sequence: Seq[Int] = Seq(1,2,3) //  Seq.apply(1,2,3)
  val accessedElements = sequence.apply(1) // the element at index 1

  // Vectors, fast Seq implementation
  val vector = Vector(1,2,3,4,5)

  // Sets
  val set = Set(1,2,3,4,1,2,3) // Set(1,2,3,4)
  val setHas5 = set.contains(5) // false
  val anAddedSet = set + 5 // returns Set(1,2,3,4,5)
  val aRemovedSet = set - 5 // returns Set(1,2,3,4)

  // Ranges, used for iterations
  val range = 1 to 1000
  val twoByTwo = range.map(_ * 2).toList

  // Tuples -> groups of values under the same value
  val tuple = ("Bon Jovi", "Book", 1982)

  // Maps
  val map: Map[String, Int] = Map(
    ("Daniel", 6345367),
    "Jane" -> 76345734 // equivalent to ("Jane", 76345734)
  )


}
