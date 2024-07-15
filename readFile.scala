import scala.io
import scala.io.Source
import imported.filesHere
object reader extends App{


    // to access files
    def processFile(filename: String, width:Int)={
        val source = Source.fromFile(filename)
        for(line<-source.getLines())
            processLine(filename,width,line)
    }

    def processLine(filename: String, width:Int , line :String)={
        if(line.trim.length>width)
            println(filename + ": "+ line.trim())
    }

    processFile("file.txt",12)


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