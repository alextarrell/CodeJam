/*input
2
3 3 3
7 5 3
 */

object EggDrop extends App {
	def fmax(floors: Int, drops: Int, breaks: Int):Int = {
		floors
	}

	def dmin(floors: Int, drops: Int, breaks: Int):Int = {
		drops
	}

	def bmin(floors: Int, drops: Int, breaks: Int):Int = {
		breaks
	}

	io.Source.stdin.getLines
		.drop(1)
		.map(ln => ln.split(" ").take(3).map(_.toInt))
		.zipWithIndex
		.foreach{case(parts, index) => {
			val f = fmax(parts(0), parts(1), parts(2))
			val d = dmin(parts(0), parts(1), parts(2))
			val b = bmin(parts(0), parts(1), parts(2))
			println(s"Case #${index+1}: $f $d $b")
		}}
}
