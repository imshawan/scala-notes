package com.rockthejvm

object Basics extends App{

  // defining a value
  val meaningOfLife: Int = 42

  // Int, Boolean, Char, Double, Float, String
  val aBoolean = false

  val aString = "I love scala"
  val aComposedString = "I" + " " + "love" + " " + "Scala"
  val anInterpolatedString = s"The meaning of life is $meaningOfLife"

  // Expressions = structures that can be reduced to a value, like 2+3

  val anExpression = 2+3

  // If-expression
  val ifExpression = if (meaningOfLife > 43) 56 else 999
  val chainedIfExpression = if (meaningOfLife > 43) 56
  else if (meaningOfLife < 0) -2
  else if (meaningOfLife >999) 78
  else 0

  //   code blocks
  val aCodeBlock = {
    // definitions
    val aLocalValue = 67

    // Last expression of the code block is the value of the code block
    aLocalValue + 3
  }

  // define a function
  def myFunction(a: Int, b: String): String = b + " " + a

  // define a function with code block
  def myFunctionWithCodeBlock(a: Int, b: String): String = {
    b + " " + a
  }

  // Functions are generally recursive in practice
  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else n * factorial(n-1)
  }

  // In scala, we do not use loops or iterations, we use recursion!

  // The Unit type = no meaningful value === "void" in other languages
  // type of side effects (like printing something to screen etc.) nothing to do with computing

  def unitReturningFunction(): Unit = {
    print("hey there, this function returns unit")
  }

  val myUnit: Unit = ()
}
