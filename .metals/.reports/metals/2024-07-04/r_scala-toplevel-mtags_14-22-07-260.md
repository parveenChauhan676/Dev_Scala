error id: file:///tmp/metals-scala-cli5910593509471773769/.scala-build/metals-scala-cli5910593509471773769_4573a40c3f-b3b30f429d/src_generated/main/functional.scala:[197..198) in Input.VirtualFile("file:///tmp/metals-scala-cli5910593509471773769/.scala-build/metals-scala-cli5910593509471773769_4573a40c3f-b3b30f429d/src_generated/main/functional.scala", "

final class functional$_ {
def args = functional_sc.args$
def scriptPath = """<WORKSPACE>/functional.sc"""
/*<script>*/
object 
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

")
file:///tmp/metals-scala-cli5910593509471773769/.scala-build/metals-scala-cli5910593509471773769_4573a40c3f-b3b30f429d/src_generated/main/functional.scala
file:///tmp/metals-scala-cli5910593509471773769/.scala-build/metals-scala-cli5910593509471773769_4573a40c3f-b3b30f429d/src_generated/main/functional.scala:9: error: expected identifier; obtained rbrace
}
^
#### Short summary: 

expected identifier; obtained rbrace