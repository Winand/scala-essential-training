package com.rockthejvm.part3fp

object ListsDemo {
  // singly linked list
  val aList: List[Int] = List.apply(1, 2, 3)
  // first element (head), rest of the list (tail)
  val firstElement = aList.head
  val rest = aList.tail
  // add (prepend) an element to a list
  val biggerList = 0 :: aList  // returns a NEW list [0, 1, 2, 3]
  // add (append) an element at the end of a list
  val biggerListV2 = aList :+ 4  // [1, 2, 3, 4]

  // utility methods
  val scalax5 = List.fill(5)("Scala")  // ["Scala", "Scala", "Scala", "Scala", "Scala"]
  // reverse a list
  val reversedList = aList.reverse  // [3, 2, 1]
  // concatenate with another list
  val concatenation = aList ++ List(4, 5, 6)
  // format the collection
  val stringRep = aList.mkString("|")  // "1|2|3"
  val stringRepV2 = aList.mkString("[", ",", "]")  // "[1,2,3]"
  // combine all elements in a list
  val total = aList.reduce(_ + _)  // (same as aList.sum)

  // `map` transforms a list by applying a function on every element of the list
  // there's no concept of iteration in a list, but there's transformer `map`
  val tenxList = aList.map(x => x * 10)  // [10, 20, 30]
  // return a different type
  val scalaList = aList.map(x => s"Scala $x")  // ["Scala 1", "Scala 2", "Scala 3"]

  // `filter` transforms a list by just keeping the items satisfying a boolean function
  val evenNumbers = aList.filter(_ % 2 == 0)  // [2] - new list

  // "Higher-order functions" (e.g. map, filter) take other functions as arguments or return functions as a result
  // `flatMap` applies a function on every element, that returns new lists, then the lists are combined into one list
  val expandedList = aList.flatMap(x => List(x, x + 1))
  def main(args: Array[String]): Unit = {
    println(aList)
    println(biggerList)
    println(biggerListV2)

    println(stringRep)
    println(stringRepV2)

    println(tenxList)
    println(scalaList)
    println(evenNumbers)
    println(expandedList)
  }
}
