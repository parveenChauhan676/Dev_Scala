

final class tp$_ {
def args = tp_sc.args$
def scriptPath = """tp.sc"""
/*<script>*/
object test{
    def main(args: Array[String]): Unit={
        
    }
    
}
/*</script>*/ /*<generated>*//*</generated>*/
}

object tp_sc {
  private var args$opt0 = Option.empty[Array[String]]
  def args$set(args: Array[String]): Unit = {
    args$opt0 = Some(args)
  }
  def args$opt: Option[Array[String]] = args$opt0
  def args$: Array[String] = args$opt.getOrElse {
    sys.error("No arguments passed to this script")
  }

  lazy val script = new tp$_

  def main(args: Array[String]): Unit = {
    args$set(args)
    val _ = script.hashCode() // hashCode to clear scalac warning about pure expression in statement position
  }
}

export tp_sc.script as `tp`

