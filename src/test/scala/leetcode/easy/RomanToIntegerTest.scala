package leetcode.easy

import leetcode.easy.RomanToInteger._
import org.scalatest.funsuite.AnyFunSuite

class RomanToIntegerTest extends AnyFunSuite {

	test("I") {
		assert(romanToInt("I") == 1)
	}

	test("IV") {
		assert(romanToInt("IV") == 4)
	}
	test("V") {
		assert(romanToInt("V") == 5)
	}

	test("IX") {
		assert(romanToInt("IX") == 9)
	}

	test("X") {
		assert(romanToInt("X") == 10)
	}

	test("XL") {
		assert(romanToInt("XL") == 40)
	}

	test("L") {
		assert(romanToInt("L") == 50)
	}

	test("XC") {
		assert(romanToInt("XC") == 90)
	}

	test("C") {
		assert(romanToInt("C") == 100)
	}

	test("CD") {
		assert(romanToInt("CD") == 400)
	}

	test("D") {
		assert(romanToInt("D") == 500)
	}

	test("CM") {
		assert(romanToInt("CM") == 900)
	}

	test("M") {
		assert(romanToInt("M") == 1000)
	}

	test("LVIII") {
		assert(romanToInt("LVIII") == 58)
	}

	test("MCMXCIV") {
		assert(romanToInt("MCMXCIV") == 1994)
	}
}
