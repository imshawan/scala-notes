package com.rockthejvm

/*
  1 - Context parameters/arguments
 */

object ContextualAbstraction {
  val aList = List(2,1,3,4)
  val anOrderedList = aList.sorted

  val descendingOrdering: Ordering[Int] = Ordering.fromLessThan(_ > _) // (a, b) => a > b

  def main(args: Array[String]): Unit = {

  }
}
