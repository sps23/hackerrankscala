package silverstar.hackerrank.challenges.w35

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class LuckyPurchaseSpec extends AnyFunSpec with Matchers {

  it("should print 'BestBook' as a lucky purchase1") {
    val laptops = Seq(
      ("HackerBook", 777444),
      ("RankBook", 3),
      ("TheBook", 777),
      ("BestBook", 47)
    )
    LuckyPurchase.printBestLaptop(laptops) shouldBe "BestBook"
  }

  it("should print 'BestBook' as a lucky purchase2") {
    val laptops = Seq(
      ("B", 777444),
      ("BestBook", 47)
    )
    LuckyPurchase.printBestLaptop(laptops) shouldBe "BestBook"
  }

  it("should print '-1' as a lucky purchase ") {
    val laptops = Seq(("abacab ", 121))
    LuckyPurchase.printBestLaptop(laptops) shouldBe "-1"
  }
}
