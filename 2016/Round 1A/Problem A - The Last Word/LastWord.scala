/*input
7
CAB
JAM
CODE
ABAAB
CABCBBABC
ABCABCABC
ZXCASDQWE
 */

object LastWord extends App {
	def solver(base: String): String = {
		var buffer = List("")
		base.foreach(c => {
			buffer = List(buffer.map(a => a + c).sorted.last, buffer.map(b => c + b).sorted.last)
		})
		buffer.sorted.last.toString
	}

	io.Source.stdin.getLines
		.drop(1)
		.map(ln => ln.split(" ").take(1))
		.zipWithIndex
		.foreach{case(parts, index) => {
			val result = solver(parts(0))
			println(s"Case #${index+1}: $result")
		}}
}
