object SelectionSort extends sort {
  override def sort(a: Array[Int]): Array[Int] = {
    var x = 0
    var counter = 0
    var swapvalue = a(x)
    for(j <- 0 to a.length/2.toInt){
      for(i <- counter to a.length-1){
        if((a(x) > a(i))){
          x = i
        }
      }
      counter += 1
        swapvalue = a(j)
        a(j) = a(x)
        a(x)  = swapvalue

    }
    return a
  }
}
