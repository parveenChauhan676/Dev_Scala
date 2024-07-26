import scala.io.Source

object PokerHands {
  val cardValues = Map(
    '2' -> 2, '3' -> 3, '4' -> 4, '5' -> 5, '6' -> 6, '7' -> 7, '8' -> 8, '9' -> 9,
    'T' -> 10, 'J' -> 11, 'Q' -> 12, 'K' -> 13, 'A' -> 14
  )

  def evaluateHand(hand: String): (Int, List[Int]) = {
    val cards = hand.grouped(2).toList
    val values = cards.map(card => cardValues(card(0))).sortWith(_ > _)
    val suits = cards.map(_(1))

    val isFlush = suits.distinct.length == 1

    val isStraight = values.sliding(2).forall(pair => pair(0) - pair(1) == 1) || values == List(14, 5, 4, 3, 2)

    val groups = values.groupBy(identity).toList.sortBy(-_._2.length)

    if (isFlush && isStraight && values.head == 14) {
      (10, values)  // Royal Flush
    } 
    
    else if (isFlush && isStraight) {
      (9, if (values == List(14, 5, 4, 3, 2)) List(5, 4, 3, 2, 1) else values)  // Straight Flush
    } 
    
    else if (groups.head._2.length == 4) {
      val fourOfAKindValue = groups.head._1
      val otherValues = values.find(_ != fourOfAKindValue).get
      (8, List(fourOfAKindValue, otherValues))  // Four of a Kind
    } 
    
    else if (groups.head._2.length == 3 && groups(1)._2.length == 2) {
      (7, List(groups.head._1, groups(1)._1))  // Full House
    } 
    
    else if (isFlush) {
      (6, values)  // Flush
    } 
    
    else if (isStraight) {
      (5, if (values == List(14, 5, 4, 3, 2)) List(5, 4, 3, 2, 1) else values)  // Straight
    } 
    
    else if (groups.head._2.length == 3) {
      val threeOfAKindValue = groups.head._1
      val otherValues = values.filter(_ != threeOfAKindValue)
      (4, threeOfAKindValue :: otherValues)  // Three of a Kind
    } 
    
    else if (groups.head._2.length == 2 && groups(1)._2.length == 2) {
      val higherPairValue = groups.head._1
      val lowerPairValue = groups(1)._1
      val otherValue = values.find(v => v != higherPairValue && v != lowerPairValue).get
      (3, List(higherPairValue, lowerPairValue, otherValue))  // Two Pairs
    } 
    
    else if (groups.head._2.length == 2) {
      val pairValue = groups.head._1
      val otherValues = values.filter(_ != pairValue)
      (2, pairValue :: otherValues)  // One Pair
    } 
    
    else {
      (1, values)  // High Card
    }
  }

  def compareHands(hand1: String, hand2: String): Int = {
    val (rank1, values1) = evaluateHand(hand1)
    if(rank1==10)println("Straight flush is there ")
    val (rank2, values2) = evaluateHand(hand2)

    if (rank1 != rank2) {
      rank1 - rank2
    } else {
      for ((v1, v2) <- values1.zip(values2)) {
        if (v1 != v2) return v1 - v2
      }
      0
    }
  }

  def main(args: Array[String]): Unit = {
    val filename = "poker.txt"
    var player1Wins = 0

      val lines = Source.fromFile(filename).getLines()
      for (line <- lines) {
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