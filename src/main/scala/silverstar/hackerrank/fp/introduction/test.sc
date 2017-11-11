import java.text.DecimalFormat

import scala.annotation.tailrec

def f(num: Int, arr: List[Int]): List[Int] = arr.flatMap(a => (1 to num).toList.map(_ => a))

f(3, List(1, 2, 3, 4))

val a = List(-3, 4, -5, 6, -7, 8, 9, -10)
a.zipWithIndex
val b = a.zipWithIndex.collect {
  case aa if aa._2 % 2 == 1 => aa._1
}

a.foldLeft(List.empty[Int])((acc, e) => e :: acc)

a.fold(0)((acc, e) => if (e % 2 != 0) acc + e else acc)
a.filter(_ % 2 != 0)
a.filter(_ % 2 != 0).sum

@tailrec
def factorial(number: Double, result: Double = 1): Double = {
  if (number == 0)
    result
  else
    factorial(number -1, result * number)
}


factorial(0d)

def expand(d: Double): Double = {
  @tailrec
  def factorial(number: Double, result: Double = 1): Double = {
    if (number == 0)
      result
    else
      factorial(number -1, result * number)
  }

  val terms = 10
  (0 until terms).toList.foldLeft(0d)((acc,b) => acc + Math.pow(d, b) / factorial(b))
}

val v2 = expand(0d)
val df = new DecimalFormat("#.####")
println(df.format(v2))



