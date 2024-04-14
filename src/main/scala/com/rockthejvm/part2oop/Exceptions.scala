package com.rockthejvm.part2oop

object Exceptions {
  /**
   * Hierarchy
   * Throwable (trait)
   *  - Error - JVM-related crashes (out of memory, stack overflow)
   *  - Exception - user-facing crashes
   *    - RuntimeException
   *    ^^ can define new exceptions
   */

  class MyException extends RuntimeException("Too big of a number - overflowing Int!")

  private def sumN(n: Int): Int =
    if (n < 0) throw new IllegalArgumentException("Negative numbers unsupported")
    else if (n > 50000) throw new MyException
    else if (n <= 0) 0
    else n + sumN(n - 1)

  // try-catch
  val attempt = try {
    // block of code that can crash
    println(sumN(100000))
  } catch {
    case e: IllegalArgumentException => -1
    case mye: MyException => Int.MaxValue
  }

  // alternative syntax
  val attemptV2 =
    try
      println(sumN(-10))
    catch
      case e: IllegalArgumentException => -1
      case e: RuntimeException => Int.MaxValue


  def main(args: Array[String]): Unit = {
    println(s"attempt=$attempt")
  }
}
