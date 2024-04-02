package com.rockthejvm.part2oop

object OOBasics {
  // classes and instances
  class Person(val name: String, age: Int) { // class definition also contains the definition of its constructor
    // inside the body fields (val, var) and methods (def) can be defined
    val allCaps = name.toUpperCase
    // method is a function associated to the class
    def greet(someone: String): String =
      s"$name says: Hi $someone"
    // overloading - different signature
    def greet(): String =
      s"Hi everyone, I'm $name"
  }

  val daniel = new Person("Daniel", 99)  // daniel is an instance of Person (instantiation)

  def main(args: Array[String]): Unit = {
    println(daniel.allCaps)
    println(daniel.greet("Andrey"))
    println(daniel.greet())
    println(daniel.name)  // name is a field because it has `val` in front of it
  }
}
