package com.rockthejvm.part3fp

object CollectionsDemo {
  // RANGES (numerical types)
  // - repeat an action
  // - convert to a collection
  val first10Numbers = 1 to 10  // infix notation == 1.to(10)
  val f10numbers = first10Numbers.toList
  val charsRangeList = ('A' to 'H').toList

  // ARRAYS - native arrays in JVM, which are stored natively on the OS
  val anArray = Array.ofDim[Int](1000)  // represented as int[] in JVM
  // - mutable
  anArray.update(31, 42)  // sets the value at index 31 to `42`
  val fifthNumber = anArray(4) // == .apply(4) == anArray[4] in JVM
  // Arrays are not used that much in Scala code. They are used for optimisation purposes in internal code.

  // SETS - collections with no duplicates (decided by .equals method), order is not guaranteed
  val aSet = Set(1, 2, 3, 4, 2, 3, 1, 5)  // [1, 2, 3, 4, 5]
  // test if an item is in the set
  val aSetContains3 = aSet contains 3  // true
  val aSetContains3V2 = aSet(3)  // == contains
  // add or remove items from the set (returns a new set)
  val aBiggerSet = aSet + 99  // [1, 2, 3, 4, 5, 99]
  val aSmallerSet = aSet - 4  // [1, 2, 3, 5]
  // concatenation == union
  val anotherSet = Set(4, 5, 6, 7, 8, 9)
  val muchBiggerSet = aSet.union(anotherSet)
  val muchBiggerSetV2 = aSet ++ anotherSet  // the same ++ is used to concatenate lists
  val muchBiggerSetV3 = aSet | anotherSet  // also does the same
  // difference
  val diffSet = aSet.diff(anotherSet)  // [1, 2, 3]
  val diffSetV2 = aSet -- anotherSet  // [1, 2, 3]
  // intersection
  val intersection = aSet.intersect(anotherSet)  // [4, 5]
  val intersectionV2 = aSet & anotherSet  // [4, 5]

  // RANGES, ARRAYS and SETS have `map`, `flatMap`, `filter` --> have for comprehensions
  val combinations: Set[Int] = for {
    x <- Set(1,2,3,4,5,6)
    y <- Set(1,2,3,4,5,6)
  } yield x * y
  // combinations = { x * y | x in {1,2,3,4,5,6}, y in {1,2,3,4,5,6} }

  def main(args: Array[String]): Unit = {
    println(combinations)  // this is a HashSet - particular implementation of Set
  }
}
