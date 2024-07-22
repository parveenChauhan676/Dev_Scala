// Trait: Vehicle with basic vehicle features
trait Vehicle {
  def brand: String
  def model: String
  def year: Int
  def price: Double
  def displayDetails(): Unit = println(s"$brand $model ($year)")
  def displayPrice(): Unit = println(s"Price: $$${price}")
}


class GasolineCar(val brand: String, val model: String, val year: Int, val price: Double) extends Vehicle {
  override def displayDetails(): Unit = {
    super.displayDetails()
    println("Fuel Type: Gasoline")
  }
}


class ElectricCar(val brand: String, val model: String, val year: Int, val price: Double) extends Vehicle  {
  override def displayDetails(): Unit = {
    super.displayDetails()
    println("Fuel Type: Electric")
  }
}


class HybridCar(val brand: String, val model: String, val year: Int, val price: Double) extends Vehicle {
  override def displayDetails(): Unit = {
    super.displayDetails()
    println("Fuel Type: Hybrid (Gasoline + Electric)")
  }
}

object CarDetails {
  def main(args: Array[String]): Unit = {
    val gasolineCar = new GasolineCar("Toyota", "Camry", 2023, 25000.0)
    val electricCar = new ElectricCar("Tesla", "Model S", 2024, 80000.0)
    val hybridCar = new HybridCar("Toyota", "Prius", 2022, 30000.0)

    println("Gasoline Car Details:")
    gasolineCar.displayDetails()

    gasolineCar.displayPrice()

    println("\nElectric Car Details:")
    electricCar.displayDetails()
  
    electricCar.displayPrice()

    println("\nHybrid Car Details:")
    hybridCar.displayDetails()
   
    hybridCar.displayPrice()


  }
}
