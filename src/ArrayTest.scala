object ArrayTest extends App {
  println(RandomArrayFactory.create(5).mkString(", "))

  println(InvertedSortedArrayFactory.create(5).mkString(", "))

  println(ShuffleArrayFactory.create(7).mkString(", "))

  println(AlmostSortedArrayFactory.create(7).mkString(", "))

  AlmostSortedArrayFactory.setCompletionPercent(0.7)
  println(AlmostSortedArrayFactory.create(7).mkString(", "))
}
