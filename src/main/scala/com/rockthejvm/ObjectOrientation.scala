package com.rockthejvm

object ObjectOrientation extends App {

  // class and instance
  class Animal {
    val age = 12

    def eat(): Unit = {
      println("I'm eating")
    }
  }

  val anAnimal = new Animal

  // inheritance
  class Dog(val name: String) extends Animal // constructor definition

  //constructor arguments are not fields: need to put a val before the constructor argument
  val aDog = new Dog("Lassie")
  println(aDog.name)

  // subtype polymorphism

  val aDeclaredAnimal: Animal = new Dog("hachi")
  aDeclaredAnimal.eat() // the most derived method will be called at runtime, here method for dog will be called.

  //abstract class

  abstract class WalkingAnimal {
    val hasLegs = true // all fields and functions are by default public but can restrict them by using private and protected
    private val hasEars = true // Means that the class only has access
    protected val hasEyes = true // means that the class and all it's descendants has access

    def walk(): Unit
  }

  // Interface = ultimate abstract types
  trait Carnivore { // we use traits to denote characteristics of objects which we can later implement in concrete class
    def eat(animal: Animal): Unit
  }

  trait Philosopher {
    def ?!(thought: String): Unit // valid method name
  }

  // scala offers single class inheritance and multi trait inheritance called "mixing"
  class Crocodile extends Animal with Carnivore with Philosopher {
    override def eat(animal: Animal): Unit = println("I'm eating you animal!")

    override def ?!(thought: String): Unit = println(s"I was thinking about: $thought")
  }

  val aCroc = new Crocodile
  aCroc.eat(aDog)
  aCroc eat aDog // methods which has single/ONE arguments can be used in this pattern, called as infix-notation = object - method - argument
  aCroc ?! "What if I could fly?"

  // Operators in Scala are actually methods
  val basicMath = 1 + 2
  val anotherBasicMath = 1.+(2) // equivalent

  // anonymous class
  val dinosaur = new Carnivore {
    override def eat(animal: Animal): Unit = println("I'm a dinosaur so I can eat anything")
  }

  // what happens behind the scene
  /*
   class Carnivore_Anonymous_345436 extends Carnivore  {
    override def eat(animal: Animal): Unit = println("I'm a dinosaur so I can eat anything")
   }

   val dinosaur = new Carnivore_Anonymous_345436
   */

  // singleton object
  object MySingleton {
    val mySpecialValue = 1
    def mySpecialMethod(): Int = 4546
    def apply(x: Int): Int = x+1
  } // Only instance of the MySingleton type

  MySingleton.mySpecialMethod()

  MySingleton.apply(56)
  MySingleton(56) // Equivalent to MySingleton.apply(56)

  // Now we have class called animal and also singleton called Animal, here we call it as companion object (same name of class or trait)
  object Animal {
    // companions can access each other private fields/methods
    // singleton Animal and instances of Animal are different things

    val canLiveIndefinitely = false
  }

  val animalsCanLiveForever = Animal.canLiveIndefinitely   // static methods/fields in java

  /*
    case classes = lightweight data structures with some boilerplate
    when i create the case class, the compiler automatically generates the following-
    - sensible equals and hash code
    - sensible serialization
    - companion with apply
   */

  case class Person(name: String, age: Int)

  // may be constructed with the new keyword
  val bob = Person("Bob", 5) // equivalent to Person.apply("Bob", 5)

  // Exceptions
  try {
    // some code that can throw error
    val x: String = null
    x.length
  } catch {
    case e: Exception => "Some faulty error message"
  } finally {
    // Execute come code no matter what
  }

  // Generics
  abstract class MyList[T] {
    def head: T
    def tail: MyList[T]
  }

  //   using a generic with a concrete type
  val aList: List[Int] = List(1, 2, 4)
  val first = aList.head
  val rest = aList.tail

  val aStringList: List[String] = List("hello", "world")
  val firstString = aStringList.head
  val restString = aStringList.tail

  // Point 1: In scala we operate with immutable value/object
  // Any modification to an object should return another object
  /*
  Benefits 1:
  1. works miracles in multithreaded/distributed env
  2. Helps make sense of the code ("reasoning about")
   */
  val reverseList = aList.reverse //  returns a new list

  // Point 2: Scala is closest to the OO ideal, every piece of code we write are inside the class

}