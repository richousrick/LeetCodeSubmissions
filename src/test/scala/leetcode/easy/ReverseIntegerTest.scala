package leetcode.easy

import leetcode.easy.ReverseInteger.reverse
import org.scalatest.funsuite.AnyFunSuite

class ReverseIntegerTest extends AnyFunSuite {

	test("Trailing zeroes handled correctly") {
		assert(reverse(120) == 21)
		assert(reverse(0) == 0)
		assert(reverse(-1010200) == -20101)
	}

	test("Sign is preserved") {
		assert(reverse(-123) == -321)
		assert(reverse(-1) == -1)
		assert(reverse(-98012) == -21089)
	}

	test("Handles overflow") {
		assert(reverse(1463847412) == 2147483641)
		assert(reverse(1463847413) == 0)
		assert(reverse(Integer.MAX_VALUE) == 0)
	}

	test("Handles underflow") {
		assert(reverse(-1463847412) == -2147483641)
		assert(reverse(-1463847413) == 0)
		assert(reverse(Integer.MIN_VALUE) == 0)
	}
}
