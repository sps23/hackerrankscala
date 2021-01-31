package silverstar.hackerrank.challenges.w26

import java.util.Scanner

import scala.annotation.tailrec

object SatisfactoryPairs extends App {

  def numberOfSatisfactoryPairs(n: Int): Int = {

    @tailrec
    def possibleABPairs(a: Int, b: Int, acc: List[(Int, Int)]): List[(Int, Int)] = {
      val aPlusB: Int         = a + b
      val abTuple: (Int, Int) = (a, b)
      if (aPlusB < n) possibleABPairs(a, b + 1, acc :+ abTuple)
      else if (aPlusB == n) possibleABPairs(a + 1, a + 2, acc :+ abTuple)
      else acc
    }

    def validXYPairExists(a: Int, b: Int): Boolean = {

      def iterate(x: Int, y: Int): Boolean = {
        if (x * a + y * b < n) iterate(x, y + 1) || iterate(x + 1, y)
        else if (x * a + y * b == n) true
        else false
      }

      iterate(1, 1)
    }

    val pairs = possibleABPairs(1, 2, List())
    pairs.foldLeft(0)((acc, tuple) => if (validXYPairExists(tuple._1, tuple._2)) acc + 1 else acc)
  }

  val sc = new Scanner(System.in)
  val n  = sc.nextInt()
  // println(numberOfSatisfactoryPairs(n))
}
