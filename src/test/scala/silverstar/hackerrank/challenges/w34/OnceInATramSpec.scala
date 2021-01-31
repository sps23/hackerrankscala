package silverstar.hackerrank.challenges.w34

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class OnceInATramSpec extends AnyFunSpec with Matchers {

  val testData: Seq[(Int, String)] = Seq(
    (555555, "555564"),
    (165901, "165903")
  )

  describe("onceInATram") {
    import OnceInATram.onceInATram

    for (t <- testData) {
      it(s"should return '${t._2}' for ${t._1.toString}") {
        onceInATram(t._1) shouldBe t._2
      }
    }
  }
}
