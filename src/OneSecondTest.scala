import scala.io.StdIn.readLine

object OneSecondTest extends App {
  def toMs(nanoTime: Long): Double = {
    nanoTime.toDouble / math.pow(10, 6)
  }

  print("Choose an algorithm (YSort, SelectionSort): ")
  val userChoice = readLine()

  var chosenAlgo: Algorithms.Algorithm = if (userChoice.toLowerCase == "ysort") Algorithms.YSort else Algorithms.SelectionSort

  val iterations: Int = 1
  var timeTakenNano: Long = 0
  var arraySize: Int = 10000 // Base size
  do {
    println(s"Trying to sort ${arraySize} elements...")
    timeTakenNano = PerformanceTests.getPerformanceResults(RandomArrayFactory.create(arraySize), iterations, chosenAlgo).sum

    println(s"Sorted in ${toMs(timeTakenNano)}")
    if (toMs(timeTakenNano) < 1000) {
      arraySize = (arraySize.toDouble * 1.1).ceil.toInt
      println("Too quick! NEED MORE ELEMENTS!!!!")
    } else {
      arraySize = (arraySize.toDouble * 0.95).ceil.toInt
      println("Daym too slow! Remove some elements!")
    }
  } while (toMs(timeTakenNano) < 950.0 || toMs(timeTakenNano) > 1050.0)


  println(s"Your PC can sort an array of ${arraySize} elements in +- 1 second")
}