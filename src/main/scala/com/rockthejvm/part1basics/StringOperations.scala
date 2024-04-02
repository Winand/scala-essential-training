package com.rockthejvm.part1basics

object StringOperations {
  val aString = "Scala Rocks"
  // String methods
  val length = aString.length
  val checkEmpty = aString.isEmpty
  val startsWithScala = aString.startsWith("Scala")
  val combine = aString + " very much!"
  val findIndex = aString.indexOf("Astronaut") // -1

  // interpolation - inject values or expressions inside a string
  val name = "Alice"
  val age = 12
  val greeting = s"Hi, name is $name and I am $age years old" // s-interpolated string
  val greeting_next = s"Hi, name is $name and I will be turning ${age + 1} years old"

  def main(args: Array[String]): Unit = {
    println(length)
    println(findIndex)
    println(greeting_next)
  }
}
