package tk.coaster3000.modscript

import org.scalatest.testng.TestNGSuite
import org.testng.Assert._
import org.testng.annotations.Test
import tk.coaster3000.modscript.util.{LogicUtil, ValidationUtil}

class TestUtils extends TestNGSuite {

	@Test(
		groups = Array("logic")
	)
	def logicIsNullTest():Unit = {
		assertTrue(LogicUtil.isNull(null), "Was supposed to be null! How the heck does a literal null value return otherwise!")
	}

	@Test(
		groups = Array("logic"),
		dependsOnMethods = Array("logicIsNullTest")
	)
	def logicIsNullOrEmptyTest():Unit = {
		val arg = "" // Empty String!
		assertTrue(LogicUtil.isNullOrEmpty(arg), "Was supposed to be empty! How is it not empty!?")
	}

	@Test(
		groups = Array("validation"),
		dependsOnGroups = Array("logic")
	)
	def validationNotNullTest():Unit = {
		intercept[IllegalArgumentException] {
			ValidationUtil.notNull(null, "You were null!")
		}
	}

	@Test(
		groups = Array("validation"),
		dependsOnGroups = Array("logic")
	)
	def validationNotEmptyTest():Unit = {
		intercept[IllegalArgumentException] {
			ValidationUtil.notNullOrEmpty("", "You were empty!")
		}
	}
}
