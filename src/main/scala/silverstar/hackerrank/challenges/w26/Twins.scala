package silverstar.hackerrank.challenges.w26

import java.util.Scanner

import scala.annotation.tailrec

/**
  * Lia is fascinated by anything she considers to be a twin. She calls a pairs of positive integers, i and j, twins if:
  * * They are both prime. A prime number is an integer greater than 1 that has no positive divisors other than 1
  * and itself.
  * * Their absolute difference is exactly equal to 2 (i.e., |j - i| = 2).
  *
  * Given an inclusive interval of integers from n to m, can you help Lia find the number of pairs of twins there are in
  * the interval (i.e., [n, m])? Note that pairs (i,j) and (j,i) are considered to be the same pair.
  *
  * Input Format
  * * Two space-separated integers describing the respective values of  and .
  *
  * Constraints
  * * l <= n <= m <= 10^9
  * * m - n <= 10^6
  *
  * Output Format
  * * Print a single integer denoting the number of pairs of twins.
  *
  * Sample Input 0
  * 3 13
  * Sample Output 0
  * 3
  * Explanation 0
  * There are three pairs of twins: (3,5), (5,7) and (11,13).
  */
object Twins extends App {

  def calculatePrimes(n: Int, m: Int): List[Int] = {

    def isPrime(number: Int, dividers: List[Int]): Boolean = !dividers.exists(number % _ == 0)

    @tailrec
    def sieve(i: Int, primes: List[Int]): List[Int] = {
      if (i > m) primes
      else if (isPrime(i, primes)) sieve(i + 1, primes :+ i)
      else sieve(i + 1, primes)
    }

    sieve(2, List()).filter(_ >= n)
  }

  def numberOfPairsOfTwins(n: Int, m: Int): Int = {
    if (n == m) 0
    else {
      val primes: List[Int] = calculatePrimes(n, m)
      if (primes.length < 2) 0
      else primes.zip(primes.drop(1)).count(pair => pair._2 - pair._1 == 2)
    }
  }

  val sc = new Scanner(System.in)
  val n  = sc.nextInt()
  val m  = sc.nextInt()
  // println(numberOfPairsOfTwins(n, m))
}
