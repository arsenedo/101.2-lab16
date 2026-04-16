object ArrayTest extends App {
  println(RandomArrayFactory.create(5).mkString(", "))

  println(InvertedSortedArrayFactory.create(5).mkString(", "))

  println(ShuffleArrayFactory.create(7).mkString(", "))
}
