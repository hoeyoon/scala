package o1.carsim
import o1.Pos
import scala.math._


class Car(val fuelConsumption: Double, val tankSize: Double, initialFuel: Double, initialLocation: Pos) {

  private var currentfuel = initialFuel
  def location: Pos = ???                                               // TODO: replace ??? with a working implementation
 
  def fuel(toBeAdded: Double): Double = {                               // TODO: replace ??? with a working implementation
    val canBeAddedFuel = tankSize - currentfuel
    val addedFuel = min(canBeAddedFuel, toBeAdded)
    currentfuel = currentfuel + addedFuel
    addedFuel
  }                             
  
  def fuel(): Double =  fuel(tankSize)                                  // TODO: replace ??? with a working implementation
  
  def fuelRatio: Double = ???                                           // TODO: replace ??? with a working implementation
    
  def metersDriven: Double = ???                                        // TODO: replace ??? with a working implementation

  def fuelRange: Double = ???                                           // TODO: replace ??? with a working implementation
  
  def drive(destination: Pos, metersToDestination: Double): Unit = ???  // TODO: replace ??? with a working implementation
  
}

