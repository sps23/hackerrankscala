package silverstar.hackerrank.challenges.w35

/**
  * Madison, is a little girl who is fond of toys. Her friend Mason works in a toy manufacturing factory .
  * Mason has a 2D board A of size H x W with H rows and W columns. The board is divided into cells of size 1 x 1
  * with each cell indicated by it's coordinate (i, j). The cell (i,j ) has an integer Aij written on it.
  * To create the toy Mason stacks number of cubes of size (1 x 1 x 1) on the cell (i, j).
  * *
  * Given the description of the board showing the values of Aij and that the price of the toy is equal to the 3d
  * surface area find the price of the toy.
  *
  * Input Format
  * The first line contains two space-separated integers H and W the height and the width of the board respectively.
  * The next H lines contains W space separated integers. The jth integer in ith line denotes Aij.
  * *
  * Constraints
  * 1 <= H,W <= 100
  * 1 <= Aij <= 100
  * *
  * Output Format
  * Print the required answer, i.e the price of the toy, in one line.
  * *
  * Sample Input 0
  * 1  1
  * 1
  * *
  * Sample Output 0
  * 6
  * *
  * Explanation 0
  * The surface area of 1 x 1 x 1 cube is 6.
  * *
  * Sample Input 1
  * 3 3
  * 1 3 4
  * 2 2 3
  * 1 2 4
  * *
  * Sample Output 1
  * 60
  */
object SurfaceArea {

  def surfaceArea(A: Array[Array[Int]]): Int = {
    def dif(one: Int, other: Int): Int = if (one - other > 0) one - other else 0

    val rows = A.length
    val cols = A.head.length
    val s: Seq[Int] = for {
      i <- 0 until rows
      j <- 0 until cols
    } yield {
      val centre = A(i)(j)
      val west   = if (j - 1 < 0) 0 else A(i)(j - 1)
      val east   = if (j + 1 >= cols) 0 else A(i)(j + 1)
      val north  = if (i - 1 < 0) 0 else A(i - 1)(j)
      val south  = if (i + 1 >= rows) 0 else A(i + 1)(j)
      dif(centre, west) + dif(centre, east) + dif(centre, north) + dif(centre, south) + 2
    }
    s.sum
  }
}
