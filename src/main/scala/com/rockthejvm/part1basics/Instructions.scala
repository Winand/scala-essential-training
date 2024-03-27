package com.rockthejvm.part1basics

object Instructions {
  // instructions vs expressions:
  // imperative programming - instructions (do, repeat...) are executed
  // functional programming - expressions are evaluated

  // Instruction in Scala is a structure (expression) which return Unit
  val printing: Unit = println("This is an instruction")  // side effect
  val theUnit: Unit = ()  // the only value of Unit

  // code blocks may return Unit
  val aCodeBlock = {
    val aLocalValue = 45
    println("Instruction 1")
    println("Instruction 2")
  }

  // Variables
  var aVariable = 10
  aVariable += 1
  val reassignment: Unit = aVariable += 1  // everything is an expression

  def main(args: Array[String]): Unit = {
    // Loops
    var theNumber = 1
    while (theNumber <= 10) {
      println(theNumber)
      theNumber += 1
    }
  }
}
