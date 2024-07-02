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
    def main(args: Array[String]): Unit={
        println(fn(4000000))
    }
}