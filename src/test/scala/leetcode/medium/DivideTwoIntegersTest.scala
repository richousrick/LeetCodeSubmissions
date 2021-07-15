package leetcode.medium

import org.scalatest.funsuite.AnyFunSuite

class DivideTwoIntegersTest extends AnyFunSuite {

	test("Example 1") {
		assert(DivideTwoIntegers.divide(10, 3) == 3)
	}

	test("Example 2") {
		assert(DivideTwoIntegers.divide(7, -3) == -2)
	}

	test("Example 3") {
		assert(DivideTwoIntegers.divide(0, 1) == 0)
	}

	test("Example 4") {
		assert(DivideTwoIntegers.divide(1, 1) == 1)
	}

	test("div 0") {
		// for speed div by 0 is not checked, but it should quickly cause a stack overflow from too many recursive calls
		assertThrows[StackOverflowError](DivideTwoIntegers.divide(7, 0))
	}

	test("always rounds to 0") {
		assert(DivideTwoIntegers.divide(12, 10) == 1) // 1.2 => 1
		assert(DivideTwoIntegers.divide(12, 8) == 1) // 1.5 => 1
		assert(DivideTwoIntegers.divide(12, 7) == 1) // ~1.71 => 1
		assert(DivideTwoIntegers.divide(12, 6) == 2) // 2.0 => 2
	}

	test("overflow test") {
		assert(DivideTwoIntegers.divide(Int.MinValue, -1) == Int.MaxValue)
	}

	test("largeDiv") {
		assert(DivideTwoIntegers.divide(Int.MaxValue, 1) == Int.MaxValue)
	}
}
