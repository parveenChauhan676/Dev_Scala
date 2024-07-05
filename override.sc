class Rational(n:Int,d:Int){
    require(d!=0)
    val numer: Int =n 
    val denom: Int = d

    override def toString= s"$numer/$denom"
    
    def add(inp : Rational): Rational = {
        new Rational(numer*inp.denom+inp.numer*denom,denom*inp.denom)
    }
}
 
object Rational extends App{
    val a = new Rational(1,2)
    val b = new Rational(1,2)
    val c = a.add(b)
    println(c)
}