/*input
3
3
HYDROCARBON COMBUSTION
QUAIL COMBUSTION
QUAIL BEHAVIOR
3
CODE JAM
SPACE JAM
PEARL JAM
2
INTERGALACTIC PLANETARY
PLANETARY INTERGALACTIC
 */

import scala.collection.mutable.Set

object Technobabble extends App {
	val input = io.Source.stdin.getLines
		.drop(1)
		.toList

	var itrs = 0
	var index = 0
	while (index < input.length) {
		itrs += 1
		val size = input(index).toInt
		val inputs = input.slice(index+1, size+index+1)
			.map(s => s.split(" ").take(2))

		// inputs.foreach(s => println(s.mkString("  ")))

		var dupes = 0
		val lefts = Set[String]()
		val rights = Set[String]()
		inputs.foreach{parts => {
				if (lefts.contains(parts(0)) && rights.contains(parts(1))) dupes +=1
				else {
					lefts += parts(0)
					rights += parts(1)
				}
			}}
		// val dupes = inputs.filter(parts => lefts.contains(parts(0)) && rights.contains(parts(1))).size

		println(s"Case #$itrs: $dupes")

		index += inputs.length + 1
	}

}
