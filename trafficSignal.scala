abstract class Signal {
  def color: String

  def description: String

  override def toString: String = s"$color signal - $description"
}

object Signal {
  private class Red extends Signal {
    val color = "Red"
    val description = "Stop"
  }

  private class Yellow extends Signal {
    val color = "Yellow"
    val description = "Prepare to stop or go"
  }

  private class Green extends Signal {
    val color = "Green"
    val description = "Go"
  }

  def red(): Signal = new Red

  def yellow(): Signal = new Yellow

  def green(): Signal = new Green
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