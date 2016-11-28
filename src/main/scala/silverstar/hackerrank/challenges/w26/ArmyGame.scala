package silverstar.hackerrank.challenges.w26

import java.util.Scanner

object ArmyGame {

  def supplyAll(n: Int, m: Int): Int = {
    val nDiv2: Int = n / 2
    val mDiv2: Int = m / 2
    val nMod2 = n % 2
    val mMod2 = m % 2
    (nDiv2 * mDiv2) + (mDiv2 * nMod2) + (nDiv2 * mMod2) + (nMod2 * mMod2)
  }

  def main(args: Array[String]) {
    val sc = new Scanner(System.in)
    val n = sc.nextInt()
    val m = sc.nextInt()
    supplyAll(n, m)
  }

}
