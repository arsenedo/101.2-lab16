object ShuffleArrayFactory extends ArrayFactory {
  override def create(size: Int): Array[Int] = {
    val array: Array[Int] = new Array[Int](size)

    // 0 -> 0
    // 1 -> size - 1
    // 2 -> 1
    // 3 -> size - 1 - 1

    // Work on pair places first
    var counter = 0
    for (i <- 0 until size by 2) {
       array(i) = counter
      counter += 1
    }

    // Work on unpair places second
    counter = 0
    for (i <- 1 until size by 2) {
      array(i) = size - 1 - counter
      counter += 1
    }

    array
  }
}
