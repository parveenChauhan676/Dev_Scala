import scala.io.Source

object PokerHands {
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
      case n => n.toInt
    }

    def evaluateHand(cards: List[Card]): (HandRank, List[Int]) = {
      val values = cards.map(card => cardValue(card.value)).sorted(Ordering.Int.reverse)
      val suits = cards.map( card => card.suit)

      val isFlush = suits.distinct.length == 1
      val isStraight = values.sliding(2).forall(pair => pair(0) - pair(1) == 1) || values == List(14, 5, 4, 3, 2)
      val groups = values.groupBy(identity).toList.sortBy(-_._2.length)

      (isFlush, isStraight, groups) match {
        case (true, true, _) if values.head == 14 => (RoyalFlush, values)
        case (true, true, _) => (StraightFlush, if (values == List(14, 5, 4, 3, 2)) List(5, 4, 3, 2, 1) else values)
        case (_, _, (value, four) :: _) if four.length == 4 => (FourOfAKind, value :: values.filter(_ != value))
        case (_, _, (three, _) :: (two, _) :: _) if three.length == 3 && two.length == 2 => (FullHouse, List(three, two))
        case (true, _, _) => (Flush, values)
        case (_, true, _) => (Straight, if (values == List(14, 5, 4, 3, 2)) List(5, 4, 3, 2, 1) else values)
        case (_, _, (three, _) :: rest) if three.length == 3 => (ThreeOfAKind, three :: rest.flatMap(_._1))
        case (_, _, (two1, _) :: (two2, _) :: rest) if two1.length == 2 && two2.length == 2 => (TwoPairs, two1 :: two2 :: rest.flatMap(_._1))
        case (_, _, (two, _) :: rest) if two.length == 2 => (OnePair, two :: rest.flatMap(_._1))
        case _ => (HighCard, values)
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
