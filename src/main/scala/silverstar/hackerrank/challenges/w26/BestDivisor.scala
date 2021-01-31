package silverstar.hackerrank.challenges.w26

import java.util.Scanner

import scala.annotation.tailrec

object BestDivisor extends App {

  def findBestDivisor(n: Int): Int = {

    @tailrec
    def allDivisors(i: Int, divisors: List[Int]): List[Int] = {
      if (i > n / 2) divisors :+ n
      else {
        if (n % i == 0) allDivisors(i + 1, divisors :+ i)
        else allDivisors(i + 1, divisors)
      }
    }

    val divisors = allDivisors(1, List())
    val divisorsTuples: List[(Int, Int)] = divisors.map(number => {
      (number, number.toString.map(_.asDigit).sum)
    }).sortBy(_._2)(Ordering[Int].reverse)
    divisorsTuples.headOption.fold(-1)(_._1)
  }

  val sc = new Scanner(System.in)
  val n = sc.nextInt()
  // println(findBestDivisor(n))
}
