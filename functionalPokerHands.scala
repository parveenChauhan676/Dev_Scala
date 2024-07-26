
import scala.io.Source

object FunctionalPokerHands {
  // Enumeration for hand ranks
  object HandRank extends Enumeration {
    type HandRank = Value
    val HighCard, OnePair, TwoPairs, ThreeOfAKind, Straight, Flush, FullHouse, FourOfAKind, StraightFlush, RoyalFlush = Value
  }

  import HandRank._

  // Class to represent a card
  case class Card(value: Char, suit: Char)

  // Class to represent a hand with its rank and cards
  case class Hand(cards: List[Card], rank: HandRank, rankingValues: List[Int])

  object Hand {
    def apply(cardStrings: List[String]): Hand = {
      val cards = cardStrings.map(s => Card(s(0), s(1)))
      val (rank, values) = evaluateHand(cards)
      new Hand(cards, rank, values)
    }

    def cardValue(c: Char): Int = c match {
      case 'T' => 10
      case 'J' => 11
      case 'Q' => 12
      case 'K' => 13
      case 'A' => 14
      case n => n.asDigit
    }

    def evaluateHand(cards: List[Card]): (HandRank, List[Int]) = {
      val values = cards.map(card => cardValue(card.value)).sorted(Ordering.Int.reverse)
      val suits = cards.map( card => card.suit)

      val isFlush = suits.distinct.length == 1
      val isStraight = values.sliding(2).forall(pair => pair(0) - pair(1) == 1) || values == List(14, 5, 4, 3, 2)
      val groups = values.groupBy(identity).toList.sortBy(-_._2.length)

      groups match {
        case head :: tail if isFlush && isStraight && values.head==14 => 
            (RoyalFlush,values)//RoyalFlush

        case head :: tail if isFlush && isStraight =>
            (StraightFlush, if (values == List(14, 5, 4, 3, 2)) List(5, 4, 3, 2, 1) else values)//StraightFLush

        case (value1, group1) :: tail if group1.length == 4 =>
            (FourOfAKind, value1 :: values.filter(_ != value1))//FourOfAKind

        case (value1, group1) :: (value2, group2) :: tail if group1.length == 3 && group2.length == 2 =>
            (FullHouse, List(value1, value2))  //FullHouse
        
        case head :: tail if isFlush =>
            (Flush, values)//Flush

        case head :: tail if isStraight =>
            (Straight, if (values == List(14, 5, 4, 3, 2)) List(5, 4, 3, 2, 1) else values)//Straight

        case (value, group1) :: tail if group1.length == 3 =>
            (ThreeOfAKind, value :: values.filter(cardval => cardval != value)) //ThreeOfAKind

        case (value1, group1) :: (value2, group2) :: tail if group1.length == 2 && group2.length == 2 =>
            (TwoPairs, List(value1, value2) ++ values.filter(cardval => cardval != value1 && cardval != value2))//TwoPairs  

        case (value, group1) :: tail if group1.length == 2 =>
            (OnePair, value :: values.filter(cardval => cardval != value)) //OnePair

        case _ => (HighCard, values)//HighCard
        }
      }


        def compare(hand1: Hand, hand2: Hand): Int = {
            if (hand1.rank != hand2.rank) {
                hand1.rank.id - hand2.rank.id
            } else {
                hand1.rankingValues.zip(hand2.rankingValues).map { case (v1, v2) => v1 - v2 }.find(_ != 0).getOrElse(0)
            }
        }

    }

    

    
  
    
  def main(args: Array[String]): Unit = {
    val filename = "poker.txt"
    var player1Wins = 0

    try {
      val lines = Source.fromFile(filename).getLines()
      for (line <- lines) {
        val cards = line.split(" ")
        val hand1 = Hand(cards.take(5).toList)
        val hand2 = Hand(cards.drop(5).toList)

        if (Hand.compare(hand1, hand2) > 0) {
          player1Wins += 1
        }
      }
      println(s"Player 1 wins $player1Wins hands.")
    } catch {
      case e: Exception => println(s"An error occurred: ${e.getMessage}")
    }
  }
}
