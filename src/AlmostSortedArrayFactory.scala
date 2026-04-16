import scala.util.Random

object AlmostSortedArrayFactory extends ArrayFactory {
  private var completionPercent: Double = 0.3;

  def setCompletionPercent(newPercent: Double): Unit = {
    completionPercent = newPercent
  }

  override def create(size: Int): Array[Int] = {
    var array: Array[Int] = new Array[Int](size)

    // Created sorted array
    for (i <- 0 until size) {
      array(i) = i
    }

    // Shuffle
    val completedUpTo = (size.toDouble * completionPercent).toInt
    val rand = new Random()
    for (i <- completedUpTo until size) {
      val swapIdx = rand.between(i, size)
      val elemAtSwapIdx = array(swapIdx)

      array(swapIdx) = array(i)
      array(i) = elemAtSwapIdx
    }

    array
  }
}
