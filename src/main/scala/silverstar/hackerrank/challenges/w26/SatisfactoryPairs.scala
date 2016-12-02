package silverstar.hackerrank.challenges.w26

import java.util.Scanner

import scala.annotation.tailrec

object SatisfactoryPairs {

  def numberOfSatisfactoryPairs(n: Int): Int = {

    @tailrec
    def possibleABPairs(a: Int, b: Int, acc: List[(Int, Int)]): List[(Int, Int)] = {
      if (a + b < n) possibleABPairs(a, b + 1, acc :+(a, b))
      else if (a + b == n) possibleABPairs(a + 1, a + 2, acc :+(a, b))
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

  def main(args: Array[String]) {
    val sc = new Scanner(System.in)
    val n = sc.nextInt()
    println(numberOfSatisfactoryPairs(n))
  }
}
