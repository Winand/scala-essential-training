package com.rockthejvm.part1basics

object Expressions {
  // structures that evaluate to a value
  val meaningOfLife = 40 + 2
  //                  ^^^^^^ expression

  // + - * / & | >> <<
  val mathExpression = 2 + 3 * 4

  // boolean expressions
  val equalityTest = 1 == 2 // expression that returns true/false

  // if expressions
  val anIfExpression = if(equalityTest) 45 else 99
  val anIfExpression2 = if equalityTest then 45 else 99

  // code blocks are expressions
  val aCodeBlock = {
    val localValue = 78
    // last value is the value of the entire block
    localValue + 99
  }

  // indentation syntax
  val aCodeBlock2 =
    // new indentation = start block
    val localValue = 78
    // last value is the value of the entire block
    localValue + 99
    // deindentation = end block

  // pattern matching - advanced switch
  val someValue = 42
  val description = someValue match {
    case 1 => "the first"
    case 2 => "second"
    case 42 => "meaning of life"
    case _ => "something else"
  }

  def main(args: Array[String]): Unit = {
    println(aCodeBlock2)
    println(description)
  }
}
