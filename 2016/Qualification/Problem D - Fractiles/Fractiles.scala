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
		if (S * C < K) List()
		else {
			(1 to K by C).map(i => {
				(0 until C).foldLeft(BigInt(1))((p, j) => (p-1) * K + Math.min(i+j, K))
			}).toList
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
