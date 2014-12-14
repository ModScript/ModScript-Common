package tk.coaster3000.modscript

import java.io.File

import org.scalatest.testng.TestNGSuite
import org.testng.Assert._
import org.testng.annotations.Test
import tk.coaster3000.modscript.parsing.{Line, LineParser}
import scala.io.{Codec, Source, BufferedSource}

class TestParsing extends TestNGSuite {

	@Test(groups = Array("parsing"))
	def defLineParse():Unit = {
		val is = Source.fromInputStream(getClass.getResourceAsStream("/testLines.test"))(Codec.UTF8)
		val lines = Array[String]()
		is.getLines().copyToArray(lines)
		is.close()
		val size = lines.size
		var lineCount = 0

		val parser = new LineParser {
			override def parse(line: Line): Any = {
				lineCount += 1
			}
		}

		parser.parse(getClass.getResourceAsStream("/testLines.test"))
		assertEquals(lineCount, size)
	}
}
