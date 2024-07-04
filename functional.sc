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

}