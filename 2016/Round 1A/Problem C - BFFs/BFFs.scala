/*input
4
4
2 3 4 1
4
3 3 4 1
4
3 3 4 3
10
7 8 10 10 9 2 9 6 3 3
 */

import scala.collection.mutable.ListBuffer
import scala.collection.mutable.Set

class Node(val idx: Int, val bff: Int) {
	var seen: Boolean
}

object BFFs extends App {
	def getCycle(ls: Array[Node], start: Int): List[Int] = {
		val cycle = ListBuffer(ls(start))
		ls(start).seen = true

		var idx = start
		while (cycle.length < ls.length) {
			val n = ls(idx)
			idx = n.idx
			if (n.seen) break
			else {
				n.seen = true
				cycle += n
			}
		}

		// val cycle = ListBuffer(start+1)
		// val visited = Set(1, start)

		// var look_next = true
		// var idx = start
		// while (cycle.length < ls.length && !visited.contains(ls(idx)-1)) {
		// 	idx = ls(idx)-1
		// 	visited += idx
		// 	cycle += idx+1
		// }

		cycle.toList.map(_.idx)
	}

	def largestCycle(ls: Array[Node]): List[Int] = {
		println(ls.mkString(" "))
		println((1 to ls.length).mkString(" "))
		println()
		val g = ls.distinct.map(idx => getCycle(ls, idx-1))
		g.foreach(println)
		g.maxBy(_.length)
	}

	io.Source.stdin.getLines
		.drop(1)
		.grouped(2)
		.map(ln => ln(1).split(" ").zipWithIndex.map{case(p, i) => Node(i.toInt, p.toInt)}.toArray)
		.zipWithIndex
		.foreach{case(parts, index) => {
			val result = largestCycle(parts).length
			println(s"Case #${index+1}: $result")
			println()
		}}
}
