object InvertedSortedArrayFactory extends ArrayFactory {
  override def create(size: Int): Array[Int] = {
    val array: Array[Int] = new Array[Int](size)
    for (i <- size - 1 to 0 by -1) {
      array((size - 1) - i) = i
    }

    array
  }
}
