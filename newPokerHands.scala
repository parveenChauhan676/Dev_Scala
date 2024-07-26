import scala.io.Source

object PokerHandsEvaluator {

  val cardValues: Map[Char, Int] = Map(
    '2' -> 2, '3' -> 3, '4' -> 4, '5' -> 5, '6' -> 6, '7' -> 7, '8' -> 8, '9' -> 9,
    'T' -> 10, 'J' -> 11, 'Q' -> 12, 'K' -> 13, 'A' -> 14
  )

  case class Hand(rank: Int, values: List[Int])

  def evaluateHand(hand: String): Hand = {
  val cards = hand.grouped(2).toList
  val values = cards.map(card => cardValues(card.head)).sorted.reverse  // converting card values from Char to Int , using the cardValues map
  val suits = cards.map(card => card(1))// created a list of the suits in hand , 


  val isFlush = suits.distinct.length == 1 //distinct basically create a new list with ony the unique values. 
  val groups = values.groupBy(identity).toList.sortBy { case (value, group) => -group.length }

  val isStraight =
    if (values == List(14, 5, 4, 3, 2)) true 
    else values.sliding(2).forall {
      case List(a, b) if a - b == 1 => true
      case List(14, 2) => true 
      case _ => false
    }


  groups match {
      case (value1, group1) :: tail if group1.length == 4 =>
        Hand(8, value1 :: values.filter(card => card != value1))  // Four of a Kind
      case (value1, group1) :: (value2, group2) :: tail if group1.length == 3 && group2.length == 2 =>
        Hand(7, List(value1, value2))  // Full House
      case head :: tail if isFlush && isStraight =>
        Hand(9, values)  // Straight Flush
      case head :: tail if isFlush =>
        Hand(6, values)  // Flush
      case head :: tail if isStraight =>
        Hand(5, values)  // Straight
      case (value, group1) :: tail if group1.length == 3 =>
        Hand(4, value :: values.filter(card => card != value))  // Three of a Kind
      case (value1, group1) :: (value2, group2) :: tail if group1.length == 2 && group2.length == 2 =>
        Hand(3, List(value1, value2) ++ values.filter(card => card != value1 && card != value2))  // Two Pairs
      case (value, group1) :: tail if group1.length == 2 =>
        Hand(2, value :: values.filter(card => card != value))  // One Pair
      case head :: tail =>
        Hand(1, values)  // High Card
      case _ => Hand(1, values)
    }
}


  def compareHands(hand1: String, hand2: String): Int = {
    val h1 = evaluateHand(hand1)
    // if(h1.rank==9)println("Straight flush is there ")
    val h2 = evaluateHand(hand2)
    // if(h2.rank==9)println("straight flush is there")

    if (h1.rank != h2.rank) h1.rank - h2.rank
    else compareValues(h1.values, h2.values)
  }

  def compareValues(values1: List[Int], values2: List[Int]): Int = {
    values1.zip(values2).find { case (v1, v2) => v1 != v2 } match {
      case Some((v1, v2)) => v1 - v2
      case None => 0
    }
  }

  def main(args: Array[String]): Unit = {
    val filename = "poker.txt"
    var player1Wins = 0
    var lineNumber = 0

    
      val lines = Source.fromFile(filename).getLines().toList
      for (line <- lines) {
        lineNumber += 1
        val cards = line.split(" ")
        val hand1 = cards.take(5).mkString
        val hand2 = cards.drop(5).mkString

        val result = compareHands(hand1, hand2)
        if (result > 0) {
          player1Wins += 1
        }

        
      }
      println(s"Player 1 wins $player1Wins hands.")
    
  }
}
