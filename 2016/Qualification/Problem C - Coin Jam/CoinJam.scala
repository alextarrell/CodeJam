/*input
1
32 500
 */
import scala.collection.mutable.ArrayBuffer

object CoinJam extends App {
	def trivDivisor(in: BigInt): BigInt = {
		var d = 2
		while (d < 100) {
			if (in % d == 0) return BigInt(d)
			d += 1
		}
		return -1
	}

	def compute(length: Integer, needed: Integer): ArrayBuffer[String] = {
		val coins = ArrayBuffer.empty[String]
		val maxVal = BigInt(Array.fill[Char](length)('1').mkString(""), 2)
		var curVal = BigInt(("1" +: Array.fill[Char](length-2)('0') :+ "1").mkString(""), 2)

		while (curVal != maxVal && coins.size < needed) {
			val strRep = curVal.toString(2)
			val divisors = ArrayBuffer.empty[BigInt]
			var ok = true
			(2 to 10).toStream.takeWhile(_ => ok).foreach(b => {
				var div = trivDivisor(BigInt(strRep, b))
				ok = div > 0
				divisors.append(div)
			})

			if (ok) {
				val div = strRep + " " + divisors.mkString(" ")
				coins += div
			}
			curVal += 2
		}

		coins
	}

	io.Source.stdin.getLines
		.drop(1)
		.map(ln => ln.split(" ").take(2))
		.zipWithIndex
		.foreach{case(parts, index) => {
			val results = compute(parts(0).toInt, parts(1).toInt)
			println(s"Case #${index+1}:")
			results.foreach(println)
		}}
}
