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

  def main(args: Array[String]): Unit = {
    println(aList)
    println(biggerList)
    println(biggerListV2)

    println(stringRep)
    println(stringRepV2)
  }
}
