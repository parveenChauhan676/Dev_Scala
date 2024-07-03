

final class evenfb$_ {
def args = evenfb_sc.args$
def scriptPath = """evenfb.sc"""
/*<script>*/
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
/*</script>*/ /*<generated>*//*</generated>*/
}

object evenfb_sc {
  private var args$opt0 = Option.empty[Array[String]]
  def args$set(args: Array[String]): Unit = {
    args$opt0 = Some(args)
  }
  def args$opt: Option[Array[String]] = args$opt0
  def args$: Array[String] = args$opt.getOrElse {
    sys.error("No arguments passed to this script")
  }

  lazy val script = new evenfb$_

  def main(args: Array[String]): Unit = {
    args$set(args)
    val _ = script.hashCode() // hashCode to clear scalac warning about pure expression in statement position
  }
}

export evenfb_sc.script as `evenfb`

