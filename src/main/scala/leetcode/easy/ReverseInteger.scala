package leetcode.easy

import leetcode.Utils._

object ReverseInteger {

	/**
	 * Solution to the problem using string manipulation,
	 * Simple, inline, not very efficient
	 * Beats Approx 61.67% runtime, 25.00% memory
	 *
	 * @param x number to reverse
	 * @return the integer representing x reversed, maintaining the sign, or 0 if the number overflows
	 */
	def reverseStr(x: Int): Int =
		try {
			math.abs(x).toString.reverse.toInt * x.sign
		} catch {
			case _: NumberFormatException => 0
		}

	/**
	 * Reversion using while loop, very Fast, memory heavy
	 * Beats Approx: 99.17% runtime, 16.67% memory
	 *
	 * @param x number to reverse
	 * @return the integer representing x reversed, maintaining the sign, or 0 if the number overflows
	 */
	def reverseWhile(x: Int): Int = {
		var in: Double = math.abs(x.toDouble)
		var rev: Double = 0
		while (in != 0) {
			rev = rev * 10 + in % 10
			in = math.floor(in / 10)
		}
		rev *= x.sign
		if (rev < Integer.MIN_VALUE) {
			0
		} else if (rev > Integer.MAX_VALUE) {
			0
		} else {
			rev.toInt
		}
	}


	def main(args: Array[String]): Unit = {
		val testFunc: Int => Int = reverseWhile
		test(testFunc, 123, 321)
		test(testFunc, -123, -321)
		test(testFunc, 120, 21)

		testMax(testFunc, 1)
		testMax(testFunc, -1)

		println("success")
	}

	/**
	 * Tests the given reverse function on the top range possible integers
	 *
	 * @param testFunc reverse function to run the tests on
	 * @param sign     representing weather the max positive or negative integers should be tested
	 * @return true if the tests were successful
	 * @throws AssertionError if any of the tests were unsuccessful
	 */
	def testMax(testFunc: Int => Int, sign: Int): Boolean = {
		// what i believe is the largest integer that can be reversed and not overflow
		val max_reversed = 1463847412 * sign
		val max_unreversed = 2147483641 * sign
		test(testFunc, max_reversed, max_unreversed)
		test(testFunc, max_unreversed, max_reversed)

		for (sig <- 0 to 10) {
			val newRev = max_reversed + math.pow(10, sig) * sign
			if (newRev < Integer.MAX_VALUE) {
				test(testFunc, newRev.toInt, 0)
			}

			val newUnRev = max_unreversed + math.pow(10, 10 - sig) * sign
			if (newUnRev < Integer.MAX_VALUE) {
				test(testFunc, newUnRev.toInt, 0)
			}
		}
		true
	}
}
