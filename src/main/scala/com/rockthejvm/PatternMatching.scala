package com.rockthejvm

object PatternMatching extends App {
  // Switch expression
  val anInteger = 55
  val order = anInteger match {
    case 1 => "First"
    case 2 => "Second"
    case 3 => "Third"
    case _ => anInteger + "th"
  }

  println(order)

  // PatternMatch is an expression, which means it can be reduced to a value

  // Case class decomposition
  case class Person(name: String, age: Int)
  val bob = Person("Bob", 43) // Person.apply("Bob", 43)

  val personGreeting = bob match {
    case Person(n, a) => s"Hi, my name is $n and I'm $a years old"
    case _  => "Something else"
  }

  println(personGreeting)

  // Deconstructing tuples
  val aTuple = ("Bon Jovi", "Rock")
  val bandDescription = aTuple match {
    case (band, genre) => s"$band belongs to the genre $genre"
    case _ => "I don't know what you are talking about"
  }

  // decomposing Lists
  val aList = List(1,2,3)
  val listDescription = aList match {
    case List(_, 2, _) => "List containing 2 on it's second position"
    case _ => "unknown list"
  }

  // If pattern matching does not match with anything, that it would throw MatchError.
  // Therefore, we use this approach: case _ => "unknown list"

  // Pattern Matching will try all cases in sequence
}
