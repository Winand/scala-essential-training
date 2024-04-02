package com.rockthejvm.part1basics

object Functions {
  // Functions - mini-programs / reusable piece of code that can be parametrized
  def aFunction(a: String, b: Int): String =
    a + " " + b

  val anInvocation = aFunction("Scala", 999)

  // function returning Unit
  def aVoidFunction(aString: String): Unit =
    println(aString)

  // can do a lot inside a function implementation
  def functioWithSideEffects(aString: String): String = {
    println(aString) // side effect
    aString + " " + aString // last expression is "returned"
  }

  // define a function inside another function
  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int) = a + b
    aSmallerFunction(n, n + 1)
  }

  def main(args: Array[String]): Unit = {
    println(aBigFunction(8))
  }
}
