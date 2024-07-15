import scala.collection.mutable.ArrayBuffer
import scala.io.Source
import Array._


object Problems extends App{

    // Problem 49 : Prime Permutations
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

    def primePermutation(): Long = {
        val stepsize= 3330  
        val lowerBound = 1000
        val upperBound = 10000 - 2 * stepsize  
        val nonTarget = Set(1487, 4817, 8147)  
        val primes = (lowerBound to upperBound).filter(isPrime)//sequence 
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
    println( "12 digit no. of Prime Permutations : "+ primePermutation())  
    //Problem 49 ends here


    // Problem 2: Even Fibonacci Numbers
    def SumEvenFib(upperBound : Int): Int={
        
        def helper( prevNum2 : Int,prevNum1 : Int ,currNum :Int, currSum:Int): Int={
            if(4*currNum+prevNum1 >= upperBound) return currSum 
            else helper(prevNum1, currNum, 4*currNum+prevNum1, currSum+4*currNum+prevNum1)   
        }
        helper(0,2,8,10)
        
    }
    println("Sum of Even Primes : " + SumEvenFib(4000000))
    //Problem 2 ends here


    //Problem 1: Multiples of 3 or 5
    def sumOfMultiples(num1 : Int,  num2 :Int )={
        val Nums= range(1, 1000).filter(x => x%num1==0 || x%num2==0).toList
        Nums.sum
    }
    println("Sum of Multiples : "+ sumOfMultiples(3,5))
    // Problem 1 ends here

    // Problem 3: Largest Prime Factor
    def largestPrimeFactor(num : Long)={
      def largestPrimeFactorHelper(n: Long, factor: Long): Long =
      if (factor * factor > n) n
      else if (n % factor == 0) largestPrimeFactorHelper(n / factor, factor)
      else largestPrimeFactorHelper(n, factor + 1)

      largestPrimeFactorHelper(num, 2L)
    }
    println("Largest Prime Factor is : " + largestPrimeFactor(600851475143L))
    // Problem 3 ends here

    // Problem 
}
