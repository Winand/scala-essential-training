package com.rockthejvm.part2oop

object MethodNotation {
  class Person(val name: String) {
    infix def greet(another: Person) =
      s"$name says: Hi, ${another.name}, how are you?"

    infix def likes(movie: String) =
      s"$name says: I adore the movie $movie!!!"

    infix def ?!(another: Person) =
      s"$name says (angry): Hey ${another.name}, how could you do this?!"

    def apply(progLang: String): Unit =
      println(s"[$name] Programming in $progLang")
    def apply(progLang: String, algorithm: String): Unit =
      println(s"[$name] Programming in $progLang, applying the algorithm $algorithm")
  }

  val alice: Person = Person("Alice")
  val bob: Person = Person("Bob")

  def main(args: Array[String]): Unit = {
    println(alice.greet(bob))  // dot notation
    println(alice   greet    bob)  // infix notation - same as .greet(...)
    //        ^       ^       ^
    //     instance method argument
    // Infix notation works with _exactly_ one argument

    println(alice.likes("Forrest Gump"))
    println(alice likes "Forrest Gump")

    println(alice ?! bob)  // popular in Akka/Pekko, Cats, ZIO

    alice("Scala")  // same as alice.apply("Scala")
    alice("Scala", "Dynamic Programming")
  }
}
