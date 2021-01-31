package silverstar.hackerrank.challenges.w34

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class MaximumGcdAndSumSpec extends AnyFunSpec with Matchers {

  it("should return 16 for maximumGcdAndSum") {
    val a = Array(3, 1, 4, 2, 8)
    val b = Array(5, 2, 12, 8, 3)
    MaximumGcdAndSum.maximumGcdAndSum(a, b) shouldBe 16
  }
}
