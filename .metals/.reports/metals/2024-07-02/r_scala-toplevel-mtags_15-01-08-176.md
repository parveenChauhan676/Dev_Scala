error id: file://<WORKSPACE>/.scala-build/Scala_f4dd477a3a/src_generated/main/tst.scala:[117..118) in Input.VirtualFile("file://<WORKSPACE>/.scala-build/Scala_f4dd477a3a/src_generated/main/tst.scala", "

final class tst$_ {
def args = tst_sc.args$
def scriptPath = """tst.sc"""
/*<script>*/
object MainObject{
    def 
}
/*</script>*/ /*<generated>*//*</generated>*/
}

object tst_sc {
  private var args$opt0 = Option.empty[Array[String]]
  def args$set(args: Array[String]): Unit = {
    args$opt0 = Some(args)
  }
  def args$opt: Option[Array[String]] = args$opt0
  def args$: Array[String] = args$opt.getOrElse {
    sys.error("No arguments passed to this script")
  }

  lazy val script = new tst$_

  def main(args: Array[String]): Unit = {
    args$set(args)
    val _ = script.hashCode() // hashCode to clear scalac warning about pure expression in statement position
  }
}

export tst_sc.script as `tst`

")
file://<WORKSPACE>/.scala-build/Scala_f4dd477a3a/src_generated/main/tst.scala
file://<WORKSPACE>/.scala-build/Scala_f4dd477a3a/src_generated/main/tst.scala:9: error: expected identifier; obtained rbrace
}
^
#### Short summary: 

expected identifier; obtained rbrace