import java.io
import imported.filesHere
object reader extends App{
    def fileLines(file : java.io.File)=
        scala.io.Source.fromFile(file).getLines().toArray

        
    def grep(pattern: String)={
        val filesHere = (new java.io.File(".")).listFiles
        for{
            file <- filesHere
            if (file.getName.endsWith(".scala"))
            line <- fileLines(file)
            trimmed=line.trim
            if trimmed.matches(pattern)
        } println(s"$file: $trimmed")
    }
    // grep(".*gcd.*")
    def scalaFiles={
        for{
            file <- filesHere
            if file.getName.endsWith(".scala")
        } yield file
    }

    
    
}