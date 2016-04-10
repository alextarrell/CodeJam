/*input
5
-
-+
+-
+++
--+-
 */

object RevengeOfThePancakes extends App {
	def flipper(pancakes: String): Integer = {
		var state = '+'
		var flips = 0
		pancakes.reverse.foreach(p => {
			if (p != state) {
				state = p
				flips += 1
			}
		})
		flips
	}

	io.Source.stdin.getLines
		.drop(1)
		.map(ln => ln.split(" ").take(1))
		.zipWithIndex
		.foreach{case(parts, index) => {
			val result = flipper(parts(0)).toString
			println(s"Case #${index+1}: $result")
		}}
}
