package com.rockthejvm.part3fp

object TuplesMapsDemo {
  // TUPLES
  val aTuple: (Int, String) = (2, "rock the jvm")
  val firstField = aTuple._1
  val secondField = aTuple._2

  // syntax sugar for tuples of 2 elements
  val aTupleV2 = 2 -> "rock the jvm"  // same as (2, "rock the jvm")

  // MAPS associate unique keys to values
  val aMap = Map()
  val phoneBook = Map(
    "Jim" -> 555,  // same tuple as ("Jim", 555)
    "Daniel" -> 921,
    "Jane" -> 123
  )

  // core methods
  // key exists in a map
  val hasDaniel = phoneBook.contains("Daniel")  // true
  val danielsNumber = phoneBook("Daniel")  // 921 (if the key is not in the map it will CRASH)

  // add a new pair - retrurns a new map
  val newPair = "Mary" -> 678
  val newPhonebook = phoneBook + newPair  // new map, because maps are immutable

  // remove a key
  val noDaniel = phoneBook - "Daniel"  // new map w\o "Daniel" key (if the key doesn't exist it WON'T crash)

  // lists of tuples <-> maps
  val listOfEntries = List(
    "Jim" -> 555,
    "Daniel" -> 921,
    "Jane" -> 123
  )
  val phonebookV2 = listOfEntries.toMap  // detects if the list is of the right type and returns a map
  val listOfEntriesV2 = phoneBook.toList  // list of tuples

  // set of keys
  val allNames = phoneBook.keySet  // ["Jim", "Daniel", "Jane"]
  // .values return an Iterable, not List, because different map classes can have different implementation
  val allNumbers = phoneBook.values.toList  // [555, 921, 123] (order is not guaranteed)

  def main(args: Array[String]): Unit = {

  }
}
