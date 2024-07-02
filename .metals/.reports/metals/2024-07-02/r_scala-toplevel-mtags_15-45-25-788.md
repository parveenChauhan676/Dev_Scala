error id: file://<WORKSPACE>/n.sc:[54..55) in Input.VirtualFile("file://<WORKSPACE>/n.sc", "/This is to show that everything in Scala is an object, even all the datatypes
object Nine{
    def OncePerSecond(poc: ()=>Unit):Unit={
        while(true){
            poc()
            Thread.sleep(1000)
        }
    }
    def timeflies():Unit={
        println("Time flies like a bird")
    }
    def main(args:Array[String]):Unit={
        OncePerSecond(timeflies)
        OncePerSecond(()=>println("Iski behen ki mjje mjje"))
    }
}
// Need to learn multithreading for this")
file://<WORKSPACE>/n.sc
file://<WORKSPACE>/n.sc:1: error: expected identifier; obtained comma
/This is to show that everything in Scala is an object, even all the datatypes
                                                      ^
#### Short summary: 

expected identifier; obtained comma