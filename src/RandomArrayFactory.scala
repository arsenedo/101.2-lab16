import scala.util.Random

class RandomArrayFactory extends ArrayFactory {
  override def create(size: Int): Array[Int] = {
    val rand = new Random()
    val array: Array[Int] = new Array[Int](size)
    for (i <- 0 until size) {
      array(i) = rand.nextInt()
    }

    array
  }
}
