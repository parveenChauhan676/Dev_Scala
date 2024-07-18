abstract class Signal {
  def color: String  //declared as abstract method

  def description: String //declared as abstract method

  override def toString: String = s"$color signal - $description"
}

object Signal { //factory object
  private class Red extends Signal {
    val color = "Red"  //overriding the method by making it field
    val description = "Stop" //overriding the method by making it field
  }

  private class Yellow extends Signal {
    val color = "Yellow" 
    val description = "Prepare to stop or go"
  }

  private class Green extends Signal {
    val color = "Green"
    val description = "Go"
  }

  //*****factory methods*****{
  def red(): Signal = new Red

  def yellow(): Signal = new Yellow

  def green(): Signal = new Green
  //}********

}

object TrafficSimulation {
  def main(args: Array[String]): Unit = {
    val redSignal = Signal.red()
    val yellowSignal = Signal.yellow()
    val greenSignal = Signal.green()

    println(redSignal)
    println(yellowSignal)
    println(greenSignal)
    
  }
}