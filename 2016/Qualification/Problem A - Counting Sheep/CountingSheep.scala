/*input
5
0
1
2
11
1692
 */

import scala.collection.mutable._

object CountingSheep extends App {
	def digits(num: Integer): Set[Char] = {
		var s:Set[Char] = Set()
		num.toString.foreach(s += _)
		s
	}

	def countSheep(start: Integer): Integer = {
		if (start == 0) return start

		var num = 0
		var s = digits(start)
		while (s.size < 10) {
			num += 1
			s = s ++ digits((num+1)*start)
			// println(s"${(num+1)*start} - $s - ${s.size < 10}")
		}

		(num+1)*start
	}

	val insomnia = "INSOMNIA"
	io.Source.stdin.getLines
		.drop(1)
		.map(ln => ln.split(" ").take(1))
		.zipWithIndex
		.foreach{case(parts, index) => {
			val result = countSheep(parts(0).toInt)
			println(s"Case #${index+1}: ${if (result == 0) insomnia else result.toString}")
		}}
}
