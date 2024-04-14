package com.rockthejvm.part2oop

object Generics {
  abstract class IntList {
    def first: Int
    def rest: IntList
  }

  class EmptyIntList extends IntList {
    override def first: Int = throw new NoSuchElementException
    override def rest: IntList = throw new NoSuchElementException
  }

  case class NonEmptyIntList(a: Int, r: IntList) extends IntList {
    def first: Int = a
    def rest: IntList = r
  }

  // How to reuse this logic for strings?
  // 1 - copy everything - impossible
  // 2 - remove type safety by using Any - defeats the purpose of types
  abstract class AnyList {
    def first: Any
    def rest: AnyList
  }

  class EmptyAnyList extends AnyList {
    override def first: Any = throw new NoSuchElementException
    override def rest: AnyList = throw new NoSuchElementException
  }

  case class NonEmptyAnyList(a: Int, r: AnyList) extends AnyList {
    def first: Any = a
    def rest: AnyList = r
  }

  // 3 - type parameters = generics
  abstract class MyList[A] {
    def first: A
    def rest: MyList[A]
    def isEmpty: Boolean
  }

  class EmptyList[A] extends MyList[A] {
    // Note: "override" is not required but is recommended
    override def first: A = throw new NoSuchElementException
    override def rest: MyList[A] = throw new NoSuchElementException
    override def isEmpty: Boolean = true
  }

  case class NonEmptyList[A](a: A, r: MyList[A]) extends MyList[A] {
    def first: A = a
    def rest: MyList[A] = r
    def isEmpty: Boolean = false
  }

  // Type parameters (generics) can be added to traits, abstract classes, case classes, "normal" classes

  // Multiple type arguments can be added to classes/traits/...
  trait MyMap[K, V]

  // can add type args for methods
  def second[A](list: MyList[A]): A =
    if (list.isEmpty) throw new NoSuchElementException
    else if (list.rest.isEmpty) throw new NoSuchElementException
    else list.rest.first

  def main(args: Array[String]): Unit = {
    val numbers = NonEmptyList(1, NonEmptyList(2, NonEmptyList(3, EmptyList())))
    val firstNumber = numbers.first

    val strings = NonEmptyList("Scala", NonEmptyList("rocks", EmptyList()))
    val firstString = strings.first

    println(second(numbers)) // 2
    println(second(strings)) // "rocks"
  }
}
