package com.rockthejvm.part2oop

object CaseClasses {
  // case classes - lightweight data structures
  case class Pet(name: String, age: Int) {
    // fields and methods
  }

  // 1 - constructor agrs are promoted to fields automatically (without "val" keyword)
  // 2 - case classes can be built without "new" keyword, see (5)
  // Note: since Scala 3 any class can be instantiated w/o "new
  val dino = Pet("Dino", 2)
  val dino_v2 = Pet("Dino", 2)
  val dinoAge = dino.age

  // 3 - toString, equals, hashCode method implementations
  // These methods belong to Any type which is a parent of all types in Scala,
  // but case classes have different default implementation of those methods:
  // - toString is human-readable representation of fields
  // - equals compares field data, not instance ids
  class PetSimple(name: String, age: Int)
  def dinoSimple = PetSimple("Dino", 2)
  def dinoSimple_v2 = PetSimple("Dino", 2)

  // 4 - utility methods, e. g. copy
  val dinoYounder = dino.copy(age = 1)  // new instance with same data EXCEPT for replaced `age`

  // 5 - case classes have companion objects pre-created, with `apply` method with the same signature as constructor
  // Note: "Normal" classes in Scala 3 also have `apply` method (?)
  val dino_v3 = Pet.apply("Dino", 2)

  // 6 - serializable, which is important for parallel/distributed systems e. g. Akka, Pekko
  // 7 - can be used in pattern matching


  // Case objects:
  case object UnitedKingdom {
    val name: String = "th uk of gb an ni"
  }

  // case objects are used to create hierarchies of data structures, some are their own type
  trait Message
  case class InitialInteraction(message: String) extends Message
  // other case classes
  case object EndConversation extends Message

  // pattern matching
  def getMessage(): Message =  // some external method
    InitialInteraction("hello")
  val message: Message = getMessage()
  val contents = message match
    // deconstruct the structure of the message
    case InitialInteraction(someContent) => s"I have received: $someContent"
    case EndConversation => "end of chat"

  def main(args: Array[String]): Unit = {
    println(dinoSimple.toString)
    println(dino.toString)
    println(dinoSimple == dinoSimple_v2) // false (class)
    println(dino == dino_v2) // true (case class)
    println(dinoYounder)
    println(contents)
  }
}
