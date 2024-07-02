object EvFib{
    def fn(lim: Int): Long={
        var a=0
        var b=2
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
        println(fn(611))
    }
}