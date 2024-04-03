/**
 * Exercise 02-02
 */
package com.rockthejvm.part2oop

object CarRegistration {
  class Driver(firstName: String, lastName: String, val birthYear: Int) {
    def fullName: String =
      s"$lastName $firstName"
  }

  class Car(val make: String, val model: String, releaseYear: Int, owner: Driver) {
    def ownerAge: Int =
      releaseYear - owner.birthYear
    def isOwnedBy(driver: Driver): Boolean =
      driver == owner
    def copy(newReleaseYear: Int): Car =
      Car(make, model, newReleaseYear, owner)
  }

  def main(args: Array[String]): Unit = {
    val driver = Driver("Savely", "Kramarov", 1934)
    val impostor = Driver("Valery", "Kalmarov", 1935)
    val car = Car("MZMA", "Moskvitch 402", 1960, driver)
    val newCar = car.copy(1961)

    println(s"Car is owned by ${driver.fullName}: ${newCar.isOwnedBy(driver)}")
    println(s"Owner age is ${newCar.ownerAge}")
    println(s"Car is owned by ${impostor.fullName}: ${newCar.isOwnedBy(impostor)}")
  }
}
