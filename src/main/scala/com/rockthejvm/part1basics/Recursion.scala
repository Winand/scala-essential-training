package com.rockthejvm.part1basics

object Recursion {
  // calculate sum of natural numbers up to `n`
  def sum(n: Int): Int =
    if (n <= 0) 0
    else n + sum(n - 1)

  def printN(string: String, n: Int): Unit =
    if (n <= 0) ()
    else {
      println(string)
      printN(string, n - 1)
    }

  // for all numbers d=2 .. n / 2 test if n % d == 0
  /*
    var d = 2
    while (d < n / 2) {
      if (n % d == 0)
        return false
      d += 1
    }
    return true
   */
  def isPrime(n: Int): Boolean = {
    def testDivisors(d: Int): Boolean = {
      if (d > n / 2) true
      else if(n % d == 0) false
      else testDivisors(d + 1)
    }
    // negative numbers not supported, 1 is not a prime number
    if (n <= 1) false
    else testDivisors(2)
  }

  /**
   * Concatenate a string a set number of times
   * concatenateN("Scala", 3) = "ScalaScalaScala"
   * @param string
   * @param n
   * @return
   */
  def concatenateN(string: String, n: Int): String =
    if (n < 1) ""
//    else if (n == 1) string
    else concatenateN(string, n - 1) + string

  /**
   * Fibonacci: 1, 2, 3(1+2), 5(2+3), 8, 13, 21...
   * @param n
   * @return
   */
  def fibonacci(n: Int): Int =
    if (n <= 0) 0
    else if (n <= 2) n
    else fibonacci(n - 2) + fibonacci(n - 1)

  def main(args: Array[String]): Unit = {
    println(sum(10))
    printN("Scala is awesome", 4)
    println(s"Is 13 a prime: ${isPrime(13)}")

    println(concatenateN("Scala", 3))
    println(fibonacci(6))
  }
}
