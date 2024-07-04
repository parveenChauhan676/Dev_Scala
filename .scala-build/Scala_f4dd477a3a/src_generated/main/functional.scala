

final class functional$_ {
def args = functional_sc.args$
def scriptPath = """functional.sc"""
/*<script>*/
object mainobject{
    def main(args: Array[String]): Unit ={
        println("hii")
    }
}
/*</script>*/ /*<generated>*//*</generated>*/
}

object functional_sc {
  private var args$opt0 = Option.empty[Array[String]]
  def args$set(args: Array[String]): Unit = {
    args$opt0 = Some(args)
  }
  def args$opt: Option[Array[String]] = args$opt0
  def args$: Array[String] = args$opt.getOrElse {
    sys.error("No arguments passed to this script")
  }

  lazy val script = new functional$_

  def main(args: Array[String]): Unit = {
    args$set(args)
    val _ = script.hashCode() // hashCode to clear scalac warning about pure expression in statement position
  }
}

export functional_sc.script as `functional`

