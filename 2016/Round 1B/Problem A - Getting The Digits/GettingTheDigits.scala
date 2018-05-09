/*input
4
OZONETOWER
WEIGHFOXTOURIST
OURNEONFOE
ETHER
 */

import scala.collection.mutable.ListBuffer

object GettingTheDigits extends App {
	val digits = Array("ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE")
		.map(freqMap)
		.zipWithIndex

	def freqMap(str: String): Map[Char, Int] = {
		str.groupBy(_.toChar).mapValues(_.size)
	}

	def canSub(primary: Map[Char, Int], secondary: Map[Char, Int]): Boolean = {
		secondary.forall{case(k, v) => primary.getOrElse(k, 0) - v >= 0}
	}

	def doSub(primary: collection.mutable.Map[Char, Int], secondary: Map[Char, Int]): collection.mutable.Map[Char, Int] = {
		secondary.foreach{case(k, v) => primary(k) = primary(k) - v}
		primary
	}

	def solve(str: String): String = {
		val base = freqMap(str)

		val s = digits.filter{case(m, i) => canSub(base, m)}
		s.foreach(println)
		""

		// val freq = collection.mutable.Map[Char,Int]() ++= base

		// val result = ListBuffer.empty[Int]
		// digits.zipWithIndex.foreach{case(m, index) => {
		// 	while (canSub(freq, m)) {
		// 		doSub(freq, m)
		// 		result += index
		// 	}
		// }}

		// result.mkString("")
	}

	io.Source.stdin.getLines
		.drop(1)
		.map(ln => ln.split(" ").head)
		.zipWithIndex
		.foreach{case(parts, index) => {
			val result = solve(parts)
			println(s"Case #${index+1}: $result")
		}}
}
