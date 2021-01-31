package silverstar.hackerrank.challenges.w26

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class TwinsSpec extends AnyFunSpec with Matchers {

  import Twins._

  val testData: Seq[((Int, Int), Int)] = Seq(
    ((3, 13), 3),
    ((2, 100), 8),
    ((40000, 40000), 0),
    ((10010, 10030), 0),
    ((10009, 10030), 0),
    ((10000, 10100), 4)
  )

  describe("numberOfPairsOfTwins") {
    for (t <- testData) {
      it(s"should return '${t._2.toString}' for '${t._1.toString}'") {
        numberOfPairsOfTwins(t._1._1, t._1._2) shouldBe t._2
      }
    }
  }
}
