package com.rockthejvm.part2oop

object Inheritance {

  class VideoGame {
    val gameType = "interactive"
    def play(): Unit = println("game running")
  }

  // single-class inheritance
  class Shooter extends VideoGame {
    def multiplayer(): Unit = {
      play()
      println("boom, boom!")
    }
  }

  val crysis = new Shooter

  class Person(val name: String, age: Int)
  class Adult(name: String, age: Int) extends Person(name, age)  // MUST specify constructor arguments
  val daniel: Adult = Adult("Daniel", 99)

  // overriding = provide a new implementation for methods in derived class
  class RPG extends VideoGame {
    override val gameType = "role-playing"

    override def play(): Unit = println("level up!")
  }

  // subtype polymorphism
  val wow: VideoGame = new RPG  // declare a value of a parent class, provide an instance of a derived class

  // anonymous classes
  val psychonauts: VideoGame = new VideoGame {
    override val gameType: String = "platformer"
  }

  /*
    class AnonClass$13579 extends VideoGame {
      override val gameType: String = "platformer"
    }

    val psychonauts = new AnonClass$13579
   */

  def main(args: Array[String]): Unit = {
    println(crysis.gameType)
    crysis.multiplayer()
    println(daniel.name)

    println(wow.gameType)
    wow.play()
  }
}
