package com.rockthejvm.part3fp

object AnonymousFunctions {
  // FunctionN + apply
  val doubler: Function1[Int, Int] = new Function[Int, Int] {
    override def apply(n: Int): Int = n * 2
  }

  // function types (lambda types), e.g. Int => Int
  // syntax sugar: Int => Int is equivalent to Function1[Int, Int]
  // lambda (n: Int) => n * 2 is equivalent to new Function[Int, Int] { .. apply .. }
  // it can be invoked as `doublerV2.apply(4)` or `doublerV2(4)`
  val doublerV2: Int => Int = (n: Int) => n * 2
  // equivalent to new Function2[Int, Int, Int] { ... }
  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b
  // Function0[A]
  val justDoSomething: () => Int = () => 42

  // alt syntax with curly braces
  // ?? Maybe braces should be opened after "=>"?
  val stringToInt = { (string: String) =>
    val stringLength = string.length
    stringLength + 45
  }

  // type inference
  val doublerV3: Int => Int = n => n * 2  // type of `n` is inferred
  val adderV2: (Int, Int) => Int = (a, b) => a + b

  // shortest notation possible
  val doublerV4: Int => Int = _ * 2  // same as doubler, doublerV2, doublerV3
  val adderV3: (Int, Int) => Int = _ + _  // each underscore is a different arg

  def main(args: Array[String]): Unit = {
    println(doubler(4))
    println(doublerV2(4))
    println(adder(1, 3))
  }
}
