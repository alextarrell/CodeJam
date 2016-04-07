/*input
2
WRWWLWWLWWLWLWRRWRWWWRWWRWLW WWRRWLWLWWLWWLWWRWWRWWLW
WW WW
 */

import scala.collection.mutable.ArrayBuffer
import scala.language.implicitConversions

import ImplicitDefs._
object ImplicitDefs {
	implicit def tuple2Point(value: Tuple2[Int, Int]) = new Point(value._1, value._2)
}

class Point(val x: Int, val y: Int) {
	def +(that: Point): Point = (this.x + that.x, this.y + that.y)
	def -(that: Point): Point = (this.x - that.x, this.y - that.y)
	override def toString = s"($x, $y)"
}

object AlwaysTurnLeft extends App {
	type Row = ArrayBuffer[Int]
	val NORTH = 1 << 0
	val SOUTH = 1 << 1
	val WEST = 1 << 2
	val EAST = 1 << 3

	def reverse(heading: Int) = heading match {
		case NORTH => SOUTH
		case EAST => WEST
		case SOUTH => NORTH
		case WEST => EAST
	}

	def right(heading: Int) = heading match {
		case NORTH => EAST
		case EAST => SOUTH
		case SOUTH => WEST
		case WEST => NORTH
	}

	def left(heading: Int) = heading match {
		case NORTH => WEST
		case EAST => NORTH
		case SOUTH => EAST
		case WEST => SOUTH
	}

	def meander(path: String): ArrayBuffer[Row] = {
		val grid: ArrayBuffer[Row] = new ArrayBuffer[Row]
		grid.append(new Row)
		grid(0).append(0)

		var heading = SOUTH
		var pos = new Point(0, 0)
		var width = 1

		path.foreach(_ match {
			case 'R' => heading = right(heading)
			case 'L' => heading = left(heading)
			case 'D' => {
				grid(pos.y)(pos.x) |= heading
				heading = reverse(heading)
			}
			case 'W' => {
				grid(pos.y)(pos.x) |= heading

				pos = heading match {
					case NORTH => pos + (0, -1)
					case SOUTH => pos + (0, 1)
					case WEST => pos + (-1, 0)
					case EAST => pos + (1, 0)
				}

				if (pos.y < 0) {
					grid.prepend(new Row)
					pos = (pos.x, 0)
				} else if (pos.y >= grid.length) {
					grid.append(ArrayBuffer.fill[Int](width)(0))
				}

				if (pos.x < 0) {
					grid.foreach(_.prepend(0))
					pos = (0, pos.y)
					width += 1
				} else if (pos.x >= width) {
					grid.foreach(_.append(0))
					width += 1
				}

				grid(pos.y)(pos.x) |= reverse(heading)
			}
		})

		grid(pos.y)(pos.x) |= heading
		grid
	}

	io.Source.stdin.getLines
		.drop(1)
		.map(ln => ln.split(" ").take(2))
		.zipWithIndex
		.foreach{case(parts, index) => {
			val grid = meander(parts(0).dropRight(1).drop(1) + "D" + parts(1).dropRight(1).drop(1))
			println(s"Case #${index+1}: ")
			grid.foreach(r => println(r.map(Integer.toString(_, 16)).mkString("")))
		}}
}
