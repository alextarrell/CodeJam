/*input
1
3
1 2 3
2 3 5
3 5 6
2 3 4
1 2 3
 */

object RankAndFile extends App {
	val input = io.Source.stdin.getLines
		.drop(1)
		.map(ln => ln.split(" ").map(_.toInt).toList)
		.toList

	var itrs = 0
	var index = 0
	while (index < input.length) {
		itrs += 1
		val size = input(index).head
		val gridSet = input.slice(index+1, 2*size+index)
		index += gridSet.length + 1

		val result = gridSet.flatten
			.toSeq
			.groupBy(identity)
			.mapValues(_.size)
			.filter(_._2 % 2 != 0)
			.keys
			.toList
			.sorted
			.mkString(" ")

		println(s"Case #$itrs: $result")
	}

}
