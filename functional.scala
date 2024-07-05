object mainobject{
    def printArgs(args: Array[String]): Unit = {
        var i = 0
        while (i < args.length) {
            println(args(i))
            i += 1
        }
    }

    def printArgs1(args: Array[String]): Unit = {
        for (arg <- args)
        println(arg)
    }

    def printArgs2(args: Array[String]): Unit = {
        args.foreach(println)
    }
    def main(args: Array[String]): Unit={
        val arr : Array[String]= Array("hii", "there" , "please")
        printArgs1(arr)
        println(" ")
        printArgs2(arr)
    }

    // tail recursive approach for concatenation
    def concatTailrec(str:String , n:Int):String={
        def helper(str: String, t:Int , accum:String):String ={
            if(t<=1) accum
            else helper(str,t-1,str+accum)
        }

        helper(str,n,str)
    }
    println(concatTailrec("hello",3))//hellohellohello

    // tail recursive approach for checking prime
    def isPrime(n:Int): Boolean={
         def isPrimeTailRec(t:Int, isStillPrime: Boolean): Boolean={
            if(!isStillPrime) false
            else if(t<=1) true
            else isPrimeTailRec(t-1,(n%t!=0)&&isStillPrime)
         }
         isPrimeTailRec(n/2,true)
    }
    println(isPrime(2003))//trye
    println(isPrime(69))//false


}



