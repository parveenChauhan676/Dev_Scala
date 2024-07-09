import scala.collection.mutable.ArrayBuffer


// Question 49 : Prime Permutations
object PrimePermutation extends App{
    // to check if a number is prime or not
    def isPrime(n:Int): Boolean={
         def isPrimeTailRec(t:Int, isStillPrime: Boolean): Boolean={
            if(!isStillPrime) false
            else if(t<=1) true
            else isPrimeTailRec(t-1,(n%t!=0)&&isStillPrime)
         }
         isPrimeTailRec(n/2,true)
    }
    // to get the digits of a number
    def digitsOf(n:Int):List[Int]={
        n.toString.map(_.asDigit).toList
    }

    def solve(): Long = {
        val stepsize= 3330  
        val lowerBound = 1000
        val upperBound = 10000 - 2 * stepsize  
        val nonTarget = Set(1487, 4817, 8147)  

        // val primes = LazyList.from(lowerBound).filter(isPrime).takeWhile(_ <= upperBound)

        // val a= for {
        //     prime <- primes
        //      candidates = Seq(prime, prime + stepsize, prime + 2 * stepsize)
        //      if candidates.forall(isPrime)
        //      if !nonTarget(candidates.head)
        //      if {
        //         println(candidates)
        //          val digits = candidates.map(digitsOf).map(_.sorted)
        //          val Seq(aDigits, bDigits, cDigits) = digits
        //          aDigits == bDigits && bDigits == cDigits
                
        //      }
        // } yield {
        // val base = 10000
        // candidates(0) * base * base + candidates(1) * base + candidates(2)
        // }
        
        val primes = (lowerBound to upperBound).filter(isPrime)

        val result = primes.view.flatMap { prime =>
          val candidates = Seq(prime, prime + stepsize, prime + 2 * stepsize)
          if (candidates.forall(isPrime) && !nonTarget(candidates.head)) {
            val digits = candidates.map(digitsOf).map(_.sorted)
            if (digits(0) == digits(1) && digits(1) == digits(2)) {
          // Concatenate the three numbers to form the 12-digit number
            val concatenatedNumber = candidates.mkString("").toLong
            Some(concatenatedNumber)
            } else None
          } else None
        }
        result.head
        
    }

    println(solve())
        

    
}


object EvFib{
    // here the Int lim is the limit on the higest fibonacci number for our example it is set to 4 million
    def fn(lim: Int): Long={
        var a=0
        var b=2
        // first two even fibonacci numbers a and b
        var sum=2
        while(4*b+a<=lim){
            var temp=a
            sum+=4*b+a
            a=b
            b=4*b+temp
        }
        return sum
    }
    def recur(n :Int): Int={
        if(n == 0) return 0
        if(n == 1) return 2
        else
            4*recur(n-1)+recur(n-2)

    }
    def main(args: Array[String]): Unit={
        println(fn(4000000))
    }

    
}