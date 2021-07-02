package leetcode.medium

import org.scalatest.funsuite.AnyFunSuite

class ZigZagConversionTest extends AnyFunSuite {

	test("example 1") {
		assert(ZigZagConversion.convert("PAYPALISHIRING", 3) == "PAHNAPLSIIGYIR")
	}

	test("example 2") {
		assert(ZigZagConversion.convert("PAYPALISHIRING", 4) == "PINALSIGYAHRPI")
	}

	test("example 3") {
		assert(ZigZagConversion.convert("A", 1) == "A")
	}

	test("Same size") {
		assert(ZigZagConversion.convert("ALL", 3) == "ALL")
	}

	test("too many rows") {
		assert(ZigZagConversion.convert("ALL", 4) == "ALL")
	}
}
