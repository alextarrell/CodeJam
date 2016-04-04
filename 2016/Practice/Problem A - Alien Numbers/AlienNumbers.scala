import scala.annotation.tailrec

object AlienNumbers extends App {
	def fromLocale(source: String, locale: String): Integer = {
		val base = locale.length
		return source.foldLeft(0)((result, v) => result*base + locale.indexOf(v))
	}

	def toLocale(source: Integer, locale: String): String = {
		val base = locale.length
		@tailrec def inner(result: StringBuilder, remaining: Integer): String = {
			result.append(locale(remaining % base).toString)
			if (remaining < base) result.toString
			else inner(result, remaining / base)
		}

		return inner(StringBuilder.newBuilder, source).reverse
	}

	io.Source.stdin.getLines
		.drop(1)
		.map(ln => ln.split(" ").take(3))
		.zipWithIndex
		.foreach{case(parts, index) => {
			val result = toLocale(fromLocale(parts(0), parts(1)), parts(2))
			println(s"Case #${index+1}: $result")
		}}
}
