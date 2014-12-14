package tk.coaster3000.modscript

import java.io.File

import org.scalatest.testng.TestNGSuite
import org.testng.Assert._
import org.testng.annotations.Test
import tk.coaster3000.modscript.parsing.{Line, LineParser}
import scala.io.{Source, BufferedSource}

class TestParsing extends TestNGSuite {

	@Test(groups = Array("parsing"))
	def defLineParse():Unit = {
		val is = getClass.getResourceAsStream("/testLines.test")

		val size = Source.fromInputStream(is).getLines().size
		var lines = 0
		val parser = new LineParser {
			override def parse(line: Line): Any = {
				lines += 1
			}
		}

		parser.parse(is)
		assertEquals(lines, size)
	}
}
