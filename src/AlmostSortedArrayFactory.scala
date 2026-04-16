object AlmostSortedArrayFactory extends ArrayFactory {
  override def create(size: Int): Array[Int] = {
    new Array[Int](size)
  }
}
