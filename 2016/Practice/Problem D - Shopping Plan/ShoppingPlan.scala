/*input
2
1 2 10
cookies
0 2 cookies:400
4 0 cookies:320
3 3 5
cookies milk! cereal
0 2 cookies:360 cereal:110
4 0 cereal:90 milk:150
-3 -3 milk:200 cookies:200
 */



object ShoppingPlan extends App {
	var source_data = io.Source.stdin.getLines.drop(1).toList
	var cases = List(List.empty[String])

	var (s, e) = (0, 0)
	while (e < source_data.length+1) {
		s += 1

	}

		// .foldLeft(List(List.empty[String]))((list, elm) => elm match {
		// 	case
		// })
		// .span(_.matches("\\d+ \\d+ \\d+"))
		// .toList
		// .flatten
		.zipWithIndex
		.foreach{case(group, index) => {
			println(s"Case #${index+1}: ")
			group.foreach(println(_))
		}}
}