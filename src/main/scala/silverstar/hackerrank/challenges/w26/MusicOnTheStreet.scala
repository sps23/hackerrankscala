package silverstar.hackerrank.challenges.w26

import java.util.Scanner

import scala.annotation.tailrec

object MusicOnTheStreet extends App {

  def possibleStartPoint(borderPoints: List[Int], miles: Int, hMin: Int, hMax: Int): Int = {

    def isValidDistance(d: Int): Boolean = d >= hMin && d <= hMax

    def combinationsForBorderPoints(points: List[Int]): List[List[Int]] = {
      points match {
        case head :: _ => (hMin to hMax).toList.reverse.map(i => head - i :: points)
        case _ => List.empty
      }
    }

    @tailrec
    def iterateBorderPoints(borderPointsList: List[List[Int]]): Option[Int] = borderPointsList match {
      case List() => None
      case h :: t =>
        val maybeStartPoint: Option[Int] = iterate(h, miles, None)
        maybeStartPoint match {
          case None => iterateBorderPoints(t)
          case startPoint => startPoint
        }
    }

    @tailrec
    def iterate(a: List[Int], m: Int, startPoint: Option[Int]): Option[Int] = {
      if (m == 0) startPoint
      else {
        a match {
          case h :: i :: tail =>
            val distance = i - h
            if (isValidDistance(m) && m < distance) startPoint.orElse(Option(h))
            else if (isValidDistance(distance)) iterate(i :: tail, m - distance, startPoint.orElse(Option(h)))
            else if (distance > hMax) iterateBorderPoints(combinationsForBorderPoints(i :: tail))
            else iterate(i :: tail, miles, None)
          case List(l) if isValidDistance(m) => startPoint.orElse(Option(l))
          case _ => None
        }
      }
    }

    val allCombinationOfBorderPoints: List[List[Int]] = combinationsForBorderPoints(borderPoints)

    iterateBorderPoints(allCombinationOfBorderPoints).getOrElse(Int.MinValue)
  }

  val sc = new Scanner(System.in)
  val n: Int = sc.nextInt()
  val a: List[Int] = (1 to n).map(_ => sc.nextInt()).toList
  val m: Int = sc.nextInt()
  val hMin: Int = sc.nextInt()
  val hMax: Int = sc.nextInt()
  // println(possibleStartPoint(a, m, hMin, hMax))
}
