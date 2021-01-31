package silverstar.hackerrank.challenges.w35

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class TripleRecursionSpec extends AnyFunSpec with Matchers {

  it("should return matrix for '5, 10, 7'") {
    val expected = Array(10, 9, 8, 7, 6, 9, 17, 16, 15, 14, 8, 16, 24, 23, 22, 7, 15, 23, 31, 30, 6, 14, 22, 30, 38)
    TripleRecursion.tripleRecursion(5, 10, 7).flatten shouldBe expected
  }

  it("should return matrix for '6, 5, 2'") {
    val expected = Array(5, 4, 3, 2, 1, 0, 4, 7, 6, 5, 4, 3, 3, 6, 9, 8, 7, 6, 2, 5, 8, 11, 10, 9, 1, 4, 7, 10, 13, 12,
      0, 3, 6, 9, 12, 15)
    TripleRecursion.tripleRecursion(6, 5, 2).flatten shouldBe expected
  }
}
