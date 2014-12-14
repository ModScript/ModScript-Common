package tk.coaster3000.modscript.parsing

import java.io.{File, InputStream}

import tk.coaster3000.modscript.util.ValidationUtil

import scala.io.Source

trait Parser {
	def parse(file: File):Any = {
		val source = scala.io.Source fromFile file
		try {
			parse(source.getLines() mkString "\n")
		} catch {
			case e: Exception => println(e)
		}
	}

	def parse(is: InputStream):Any = {
		ValidationUtil.notNull(is)
		try {
			val data = Source.fromInputStream(is).getLines() mkString "\n"

			parse(data)
		} catch {
			case e: Exception => println(e)
		}
	}

	def parse(data: String):Any
}
