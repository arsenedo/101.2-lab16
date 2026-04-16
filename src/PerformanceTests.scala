import java.io.{File, FileWriter}
import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Algorithms extends Enumeration {
  type Algorithm = Value

  val SelectionSort, YSort = Value
}

object PerformanceTests extends App {
  def generateSizesToTestArray(min: Int, max: Int, step: Int): Array[Int] = {
    val arrayBuffer: ArrayBuffer[Int] = ArrayBuffer[Int]().empty

    for (i <- min to max by step) {
      arrayBuffer.addOne(i)
    }

    arrayBuffer.toArray
  }

  def getPerformanceResults(array: Array[Int], iterations: Int, algorithm: Algorithms.Algorithm): Array[Long] = {
    val performanceResults: Array[Long] = new Array[Long](iterations)

    for (i <- 0 until iterations) {
      var startTime: Long = 0
      var endTime: Long = 0

      algorithm match {
        case Algorithms.YSort =>
          startTime = System.nanoTime()
          YSort.sort(array)
          endTime = System.nanoTime()
        case Algorithms.SelectionSort =>
          startTime = System.nanoTime()
          SelectionSort.sort(array)
          endTime = System.nanoTime()
      }

      performanceResults(i) = endTime - startTime
    }

    performanceResults
  }

  def writeTestResultsToFile(results: mutable.LinkedHashMap[Int, Double], filename: String): Unit = {
    var fileText: String = ""

    for ((size, msTime) <- results.iterator) {
      fileText += s"${size};${msTime};\n"
    }

    val fw: FileWriter = new FileWriter(new File(s"results/${filename}.csv"))
    fw.write(fileText)
    fw.close()
  }

  // Instead of 10k steps to percentage steps
  val sizesToTest: Array[Int] = generateSizesToTestArray(math.pow(10, 3).toInt, math.pow(10, 5).toInt, 1000)

  val factories: Array[ArrayFactory] = Array(RandomArrayFactory, InvertedSortedArrayFactory, ShuffleArrayFactory, AlmostSortedArrayFactory)
  val algorithms: Array[Algorithms.Algorithm] = Array(Algorithms.YSort, Algorithms.SelectionSort)
  val iterations: Int = 10

  for (factory <- factories) {
    val factoryName: String = "^(\\w*Factory)".r.findFirstIn(factory.toString).getOrElse("UnknownFactory")
    println(s"--- Executing ${factoryName} Tests ---")
    for (algorithm <- algorithms) {
      println(s"Executing tests for ${algorithm} algorithm...")
      val results: mutable.LinkedHashMap[Int, Double] = mutable.LinkedHashMap().empty

      for (size <- sizesToTest) {
        val performanceResults: Array[Long] = getPerformanceResults(factory.create(size), iterations, algorithm)
        results(size) = (performanceResults.sum.toDouble / performanceResults.length.toDouble) / math.pow(10, 6)
      }

      println("Exporting tests to a file...")
      writeTestResultsToFile(results, filename = s"${algorithm.toString}_${factoryName}")
    }
  }
}
