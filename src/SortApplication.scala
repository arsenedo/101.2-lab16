object SortApplication extends App {
  def displayArray(a: Array[Int]): Unit = {
    println(a.mkString(","))
  }
  println("test selection sort")
  var array = RandomArrayFactory.create(10)
  displayArray(array)
  displayArray(SelectionSort.sort(array))

}
