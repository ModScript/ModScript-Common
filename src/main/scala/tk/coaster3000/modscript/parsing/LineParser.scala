package tk.coaster3000.modscript.parsing

import java.io.InputStream

import tk.coaster3000.modscript.util.ValidationUtil

import scala.collection.mutable
import scala.io.Source

trait LineParser extends Parser {
	def parse(line: Line):Any

	private def toLineContexts(lines: List[String]): List[Line] = {
		(for (i <- 1 to lines.length) yield new Line(lines(i), i))(collection.breakOut)
	}

	private def toLineContexts(lines: Array[String]):List[Line] = {
		val l: mutable.MutableList[String] = mutable.MutableList()
		
		for (line <- lines) l :+ line

		toLineContexts(l.toList)
	}

	override def parse(is: InputStream):Any = {
		ValidationUtil.notNull(is)
		toLineContexts(Source.fromInputStream(is).getLines().toArray) foreach parse
	}

	override def parse(data: String):Any = {
		if (data.contains("\r\n")) toLineContexts(data.split("\r\n")) foreach parse
		else if (data.contains("\n\r")) toLineContexts(data.split("\r\n")) foreach parse
		else if (data.contains("\r")) toLineContexts(data.split("\r")) foreach parse
		else if (data.contains("\n")) toLineContexts(data.split("\n")) foreach parse
	}
}
