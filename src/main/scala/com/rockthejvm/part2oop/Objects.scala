package com.rockthejvm.part2oop

object Objects {
  // singleton pattern
  object MySingleton { // <-- MySingleton type AND the only instance of that type
    val aField = 45
    def aMethod(x: Int): Int = x + 1
  }
  val theSingleton = MySingleton
  val anotherSingleton = MySingleton

  // Companion = OBJECT with the same name as a CLASS in the same file
  class Person(name: String) {
    def sayHi(): String = s"Hi, my name is $name"
  }

  object Person {  // <-- companion
    // define "static" fields and methods (which don't depend on a particular instance of a class)
    val N_EYES = 2
    def canFly: Boolean = false
  }

  // objects can extend class/traits
  object BigFoot extends Person("Big Foot")

  /*
  * Scala compiles to JVM bytecode

  In Java:
  class MyApplication {
    public static void main(String[] args) { }
  }

  In Scala:
  - public - by default
  - static - Object
  - void - Unit
  - String[] - Array[String]
  object MyApplication {
    def main(args: Array[String]): Unit = { }
  }
  * */
  def main(args: Array[String]): Unit = {
    println(theSingleton == anotherSingleton)
    println(MySingleton.aField)
    println(MySingleton.aMethod(5))

    println(BigFoot.sayHi())
  }
}
