package silverstar.hackerrank.challenges.w34

import scala.annotation.tailrec

/**
 * You are given two arrays A and B containing pair elements each. Choose a pair of elements (x, y) such that:
 * x belongs to array A.
 * y belongs to array B.
 * gcd(x, y) is the maximum of all pairs (x, y).
 * If there is more than one such pair (x, y) having maximum gcd, then choose the one with maximum sum.
 * Print the sum of elements of this maximum-sum pair.
 * *
 * NOTE: gcd(x, y) returns the largest integer that divides both x and y.
 * *
 * Input Format
 * The first line of the input contains  denoting the total number of elements of arrays A and B.
 * Next line contains n space separated positive integers denoting the elements of array A.
 * Next line contains n space separated positive integers denoting the elements of array B.
 * *
 * Constraints
 * 1 <= n <= 5 * 10e5
 * 1 <= x <= 10e6
 * 1 <= y <= 10e6
 *
 * Output Format
 * From all the pairs having maximum gcd, print the sum of one that has the maximum sum.
 * *
 * Sample Input 0
 * 5
 * 3 1 4 2 8
 * 5 2 12 8 3
 * *
 * Sample Output 0
 * 16
 * *
 * Explanation 0
 * Over all the pairs, if we choose 8 from array A, and 8 from array B, we get gcd(8, 8) = 8,
 * which is the maximum gcd over all the pairs. Thus, maximum sum of pair (8, 8) is equal to 8 + 8 = 16.
 */
object MaximumGcdAndSum {

  @tailrec
  def gcd(x: Int, y: Int): Int = if (y == 0) x else gcd(y, x % y)

  def cartesianProduct(a: List[Int], b: List[Int]): List[(Int, Int)] = a.flatMap(aa => b.map(bb => (aa, bb))).distinct

  def maximumGcdAndSum(A: Array[Int], B: Array[Int]): Int = {
    val pairs = cartesianProduct(A.toList, B.toList)
    val gcdAndSum: List[(Int, Int)] = pairs.map(xy => (gcd(xy._1, xy._2), xy._1 + xy._2))
    gcdAndSum.maxByOption(t => (t._1, t._2)).fold(0)(_._2)
  }
}
