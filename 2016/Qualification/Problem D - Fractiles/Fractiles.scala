/*input
5
2 3 2
1 1 1
2 1 1
2 1 2
3 2 3
4 3 4
5 4 5
7 5 7
11 16 11
1 4 1
 */

object Fractiles extends App {
	def tileFinder(K: Int, C: Int, S: Int): List[BigInt] = {
		// i*K^(C-1)+2
		val factor = BigInt(K).pow(C-1)
		K match {
			case S => (1 to K).map(i => BigInt(i)).toList
			case _ if (S * 2 <= K) => List()
			case _ => (0 until K by 2).map(i => i * factor + 2).toList
		}
	}

	io.Source.stdin.getLines
		.drop(1)
		.map(ln => ln.split(" ").take(3))
		.zipWithIndex
		.foreach{case(parts, index) => {
			val tiles = tileFinder(parts(0).toInt, parts(1).toInt, parts(2).toInt)
			val result = if (tiles.isEmpty) "IMPOSSIBLE" else tiles.mkString(" ")
			println(s"Case #${index+1}: $result")
		}}
}
