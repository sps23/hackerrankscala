package silverstar.hackerrank.challenges.w26

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class BestDivisorSpec extends AnyFunSpec with Matchers {

  import BestDivisor._

  val testData: Seq[(Int, Int)] = Seq(
    (12, 6),
    (95, 95),
    (1000, 8),
    (1024, 256),
    (10000, 625),
    (3333, 3333),
    (535, 535)
  )

  describe("findBestDivisor") {
    for (t <- testData) {
      it(s"should return '${t._2.toString}' for '${t._1.toString}'") {
        findBestDivisor(t._1) shouldBe t._2
      }
    }
  }
}
