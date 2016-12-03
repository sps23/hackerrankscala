package silverstar.hackerrank.challenges.w26

import org.scalatest.{FunSpec, Matchers}

class MusicOnTheStreetSpec extends FunSpec with Matchers {

  import MusicOnTheStreet._

  val testData: Seq[((List[Int], Int, Int, Int), Int)] = Seq(
    ((List(1, 3), 7, 2, 3), -2),
    ((List(1, 3), 3, 2, 3), -2),
    ((List(1, 4), 7, 2, 3), -1),
    ((List(1, 3, 12), 7, 2, 3), -2),
    ((List(-5, 1, 3, 8), 7, 2, 3), -2),
    ((List(-5, 1, 3), 7, 2, 3), -2),
    ((List(-5, 1, 4), 7, 2, 3), -1),
    ((List(1, 3), 8, 2, 3), -2),
    ((List(1, 3, 5, 9, 11), 10, 2, 5), -3),
    ((List(1, 3), 2, 2, 3), -2),
    ((List(1, 3, 4, 6, 8, 10, 11), 6, 2, 2), 4),
    ((List(-3, -1), 7, 2, 3), -6),
    ((List(1), 4, 2, 3), -1)
  )

  describe("possibleStartPoint") {
    for (t <- testData) {
      it(s"should return '${t._2}' for '${t._1}'") {
        possibleStartPoint(t._1._1, t._1._2, t._1._3, t._1._4) shouldBe t._2
      }
    }
  }
}