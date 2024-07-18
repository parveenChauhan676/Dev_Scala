abstract class Car{

    def bookingPrice : Double //to know the booking price of car

    def brands : List[String] //brands of car available

    def availability : Int  // total no. of cars avaible 

    def booked(noOfCars : Int ) : Unit // to track how many cars are available after booking a noOfCars


}

object Car{ //factory object 
    val STANDARD = 0
    val DELUXE = 1
    val LUXURY = 2

    private class standardCar extends Car{
        private var _availability = 100

        override def bookingPrice = 2000000

        override def brands = List("Tata","Maruti","Hyundai")

        override def availability = _availability

        override def booked(noOfCars: Int): Unit ={
            _availability=_availability - noOfCars
        }
    }

    private class deluxeCar extends Car{
        private var _availability = 50

        override def bookingPrice = 5000000

        override def brands = List("Honda","Mahindra")

        override def availability = _availability

        override def booked(noOfCars: Int): Unit ={
            _availability=_availability - noOfCars
        }
    }

    private class luxuryCar extends Car{
        private var _availability = 10

        override def bookingPrice = 20000000

        override def brands = List("Audi","BMW","Mercedes")

        override def availability = _availability

        override def booked(noOfCars: Int): Unit ={
            _availability=_availability - noOfCars
        }
    }

    def apply(carType : Int):Car={ //factory method to call various classes\
        carType match {
            case LUXURY => new luxuryCar
            case DELUXE => new deluxeCar
            case STANDARD => new standardCar
            case _ => new standardCar
        }
    }

    def main(args: Array[String]):Unit ={
        val car1= Car(DELUXE)
        println(s"bookig price is ${car1.bookingPrice}")
        println(s"no. of cars available = ${car1.availability}")
        
    }

}

