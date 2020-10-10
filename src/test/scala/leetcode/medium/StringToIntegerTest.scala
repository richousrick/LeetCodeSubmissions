package leetcode.medium

import leetcode.medium.StringToInteger._
import org.scalatest.funsuite.AnyFunSuite

class StringToIntegerTest extends AnyFunSuite {

	test("Specified positive sign") {
		assert(myAtoi("+38") == 38)
		assert(myAtoi("+12") == 12)
	}

	test("Specified negative sign") {
		assert(myAtoi("-38") == -38)
		assert(myAtoi("-12") == -12)
	}

	test("leading whitespace") {
		assert(myAtoi("      -42") == -42)
		assert(myAtoi("    +12") == 12)
		assert(myAtoi("         76") == 76)
	}

	test("Multiple signs fail") {
		assert(myAtoi("    +-23") == 0)
		assert(myAtoi("    -+38") == 0)
	}

	test("Invalid start") {
		assert(myAtoi("words and 987") == 0)
		assert(myAtoi("word42") == 0)
		assert(myAtoi("word+36") == 0)
		assert(myAtoi("+ 12") == 0)
		assert(myAtoi(" + 12") == 0)
		assert(myAtoi("- 48") == 0)
		assert(myAtoi(" - 65") == 0)
	}

	test("Ignores trailing integers") {
		assert(myAtoi("-48 3") == -48)
		assert(myAtoi("13a") == 13)
		assert(myAtoi("13 Appt. 12") == 13)
		assert(myAtoi("73-5") == 73)
	}

	test("Handles overflow") {
		assert(myAtoi(Integer.MAX_VALUE + "") == Integer.MAX_VALUE)
		assert(myAtoi(Integer.MAX_VALUE - 1L + "") == Integer.MAX_VALUE - 1)
		assert(myAtoi(Integer.MAX_VALUE + 1L + "") == Integer.MAX_VALUE)
		assert(myAtoi(Integer.MAX_VALUE + 1000L + "") == Integer.MAX_VALUE)
		assert(myAtoi(Long.MaxValue + "") == Integer.MAX_VALUE)
		assert(myAtoi(Long.MaxValue + "1234") == Integer.MAX_VALUE)
	}

	test("Handles underflow") {
		assert(myAtoi(Integer.MIN_VALUE + "") == Integer.MIN_VALUE)
		assert(myAtoi(Integer.MIN_VALUE + 1L + "") == Integer.MIN_VALUE + 1)
		assert(myAtoi(Integer.MIN_VALUE - 1L + "") == Integer.MIN_VALUE)
		assert(myAtoi(Integer.MIN_VALUE - 1000L + "") == Integer.MIN_VALUE)
		assert(myAtoi(Long.MinValue + "") == Integer.MIN_VALUE)
		assert(myAtoi(Long.MinValue + "1234") == Integer.MIN_VALUE)
	}

	test("Missing number") {
		assert(myAtoi("") == 0)
		assert(myAtoi("+") == 0)
		assert(myAtoi("-") == 0)

		assert(myAtoi("+hi") == 0)
		assert(myAtoi("-hi") == 0)
		assert(myAtoi("hi") == 0)

		assert(myAtoi("+ hi") == 0)
		assert(myAtoi("- hi") == 0)
		assert(myAtoi(" hi") == 0)
	}

	test("Leading 0's") {
		assert(myAtoi("  0000000000012345678") == 12345678)
		assert(myAtoi("  -0000000000012345678") == -12345678)
		assert(myAtoi("0100") == 100)
	}

	test("Leading 0's followed by integer") {
		assert(myAtoi("0-1") == 0)
		assert(myAtoi("0+1") == 0)
	}
}
