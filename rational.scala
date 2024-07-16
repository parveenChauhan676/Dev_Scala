package  rational
import scala.math._
class Rational(n:Int,d:Int){
    require(d!=0)
    private val g = gcd(n.abs, d.abs)
    val numer: Int =n/g 
    val denom: Int = d/g
    
    def this(n:Int)=this(n,1) //auxiliary constructor used to write an integer as rational number
    
    // addition
    def +(inp : Rational): Rational = {
        new Rational(numer*inp.denom+inp.numer*denom,denom*inp.denom)
    }
    //substraction
    def -(inp : Rational): Rational = {
        new Rational(numer*inp.denom-inp.numer*denom,denom*inp.denom)
    }
    // multiplicaton
    def *(inp: Rational): Rational ={
        new Rational(numer*inp.numer, denom*inp.denom)
    }
    //division
    def /(inp:Rational):Rational={
        new Rational(numer*inp.denom,denom*inp.numer)
    }
    
    def ^(inp: Int): Rational={
        
        new Rational(math.pow(numer,n).toInt,math.pow(denom,n).toInt)
    }
    //to calculate the gcd of two numbers.
    private def gcd(num1:Int , num2:Int):Int={
        if(num2==0) num1
        else gcd(num2,num1%num2)
    }

    

    override def toString= s"$numer/$denom"

    //now begin method overloading...
    //overloaded addition
    def +(inp:Int): Rational= new Rational(numer+inp*denom,denom)
    //overloaded subsraction
    def -(inp:Int):Rational = new Rational(numer-inp*denom,denom)
    //overloaded multiplication
    def *(inp:Int ):Rational= new Rational(numer*inp,denom)
    //overloaded division
    def /(inp:Int): Rational= new Rational(numer,denom*inp)
}
 
object Rational {
    val a = new Rational(3,2)
    val b = new Rational(1,2)
    def main(args: Array[String])={
        val c = a^3
        println(c)
        println("hii")

    }
    

}
