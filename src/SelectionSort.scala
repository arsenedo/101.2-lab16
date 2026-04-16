object SelectionSort extends Sort {
  override def sort(a: Array[Int]): Array[Int] = {
    for (i <- a.indices) {
      var smallestNumberIdx: Int = i

      for (j <- i + 1 until a.length) {
        if (a(j) < a(smallestNumberIdx)) {
          smallestNumberIdx = j
        }
      }

      val temp = a(i)
      val smallestFound = a(smallestNumberIdx)
      a(i) = a(smallestNumberIdx)
      a(smallestNumberIdx) = temp
    }

    a
  }
}
