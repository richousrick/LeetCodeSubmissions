package leetcode.easy

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

	def reverse(x: Int): Int = reverseWhile(x)
}
