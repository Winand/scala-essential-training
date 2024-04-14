package com.rockthejvm.part3fp

object FPBasics {
  // apply
  case class Person(name: String, favMovie: String) {
    def apply(n: Int): String =
      s"$name watched $favMovie $n time(s)"
  }

  val daniel: Person = Person("Daniel", "Interstellar")
  val danielStatement = daniel.apply(4)
  val danielStatementV2 = daniel(4)  // the same

  // we can create "function" types (because `apply` allows class instances be invoked on arguments like functions)
  trait SimpleMathFunction {
    def apply(n: Int): Int
  }

  val doubler: SimpleMathFunction = new SimpleMathFunction {
    override def apply(n: Int): Int = n * 2
  }
  val doublerShort: SimpleMathFunction = (n: Int) => n * 2

  val six = doubler(3)

  trait MyFunction[A, B] {
    def apply(arg: A): B
  }

  val doublerV2 = new MyFunction[Int, Int] {
    override def apply(arg: Int): Int = arg * 2
  }

  val sixV2 = doublerV2(3)

  // In functional programming we work with functions as "first class" elements of the language
  // We can pass functions as arguments, we can return them as results
  // Int => Int can be expressed as a trait that has an `apply(Int): Int`
  // (String, Int) => Int can be expressed as a trait that has an `apply(String, Int): Int`

  trait MyStringIntFunction {
    def apply(s: String, i: Int): String
  }

  val myCombinator = new MyStringIntFunction {
    override def apply(s: String, i: Int): String =
      s"$s, ($i)"
  }

  // Scala already has Function traits
  // See `doublerV2` above
  val doublerV3 = new Function1[Int, Int] {
    override def apply(arg: Int): Int = arg * 2
  }
  // see `myCombinator` above
  val myCombinatorV2 = new Function2[String, Int, String] {
    override def apply(s: String, i: Int): String =
      s"$s, ($i)"
  }

  val superFunction = new Function4[Int, String, Double, Boolean, Int] {
    override def apply(v1: Int, v2: String, v3: Double, v4: Boolean): Int = v1 * 10
  }

  // CONCLUSION: all function values in Scala are instances of FunctionN traits with apply methods

  def main(args: Array[String]): Unit = {
    println(danielStatement)
    println(danielStatementV2)
    println(six)
    println(sixV2)
    println(myCombinator("Scala", 99))
    println(myCombinatorV2("Scala", 99))
    println(superFunction(4, "Scala", 3.14, true))
  }
}
