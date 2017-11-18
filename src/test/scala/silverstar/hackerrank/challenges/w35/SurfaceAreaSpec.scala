package silverstar.hackerrank.challenges.w35

import org.scalatest.{FunSpec, Matchers}

class SurfaceAreaSpec extends FunSpec with Matchers {

  it("should return '60' for the example1") {
    val A = Array(
      Array(1, 3, 4),
      Array(2, 2, 3),
      Array(1, 2, 4)
    )
    SurfaceArea.surfaceArea(A) shouldBe 60
  }

  it("should return '24' for the example2") {
    val A = Array(
      Array(1, 2, 3)
    )
    SurfaceArea.surfaceArea(A) shouldBe 24
  }
}
