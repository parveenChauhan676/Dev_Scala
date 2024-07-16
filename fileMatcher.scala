
object fileMatcher extends App{
    private def filesHere = (new java.io.File(".")).listFiles()

    // def filesEnding(query: String)={
    //     for(file <- filesHere; if file.getName.endsWith(query))
    //         yield file
    // }
    
    // def filesContaining(query: String)={
    //     for(file <- filesHere; if file.getName.contains(query))
    //         yield file
    // }

    // def filesRegex(query: String)={
    //     for(file<-filesHere; if file.getName.matches(query))
    //         yield file
    // }
    // the above commented out lines have repeated syntax to reduce this syntax we can 
    // use  higher order functions (takes functions as a parameter)
     private def filesMatching(matcher: String => Boolean) =
    for (file <- filesHere; if matcher(file.getName))
    yield file
    def filesEnding(query: String) =
        filesMatching(_.endsWith(query))

    def filesContaining(query: String) =
        filesMatching(_.contains(query))

    def filesRegex(query: String) =
        filesMatching(_.matches(query))
        
}
object Curry extends App{
    def normalSum(x:Int, y:Int)=x+y //normally adding two numbers 

    def currySum(x:Int)(y:Int)=x+y // addition using currying 

    val plus = currySum(1)_  //using partially applied function to add two numbers
    val ans = plus(2)
    println("using partially applied function : " +ans)
    println("using curried function : " + currySum(1)(2))
    println("using normal addition : " +normalSum(1,2))
}