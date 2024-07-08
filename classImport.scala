import rational._
object imported extends App{
    val num1= new Rational(1,2)
    val num2 = new Rational(3,4)
    val num3 = num1 +num2
    println(num3)


    val filesHere=(new java.io.File(".")).listFiles
    for(file <- filesHere if file.getName.endsWith(".scala")){
        println(file)
    }

}