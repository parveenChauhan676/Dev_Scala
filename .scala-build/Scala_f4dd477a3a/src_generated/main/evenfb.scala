

final class evenfb$_ {
def args = evenfb_sc.args$
def scriptPath = """evenfb.sc"""
/*<script>*/

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

