package silverstar.hackerrank.challenges.w26

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class ArmyGameSpec extends AnyFunSpec with Matchers {

  import ArmyGame._

  val testData: Seq[((Int, Int), Int)] = Seq(
    ((2, 2), 1),
    ((5, 6), 9),
    ((3, 3), 4),
    ((5, 5), 9),
    ((4, 3), 4),
    ((4, 4), 4)
  )

  describe("supplyAll") {
    for (t <- testData) {
      it(s"should return '${t._2.toString}' for '${t._1.toString}'") {
        supplyAll(t._1._1, t._1._2) shouldBe t._2
      }
    }
  }
}
