package leetcode.medium

object DivideTwoIntegers {

	/**
	 * Divides dividend by divisor without using multiplication, division, and mod operator.
	 *
	 * @param dividend the number to be divided
	 * @param divisor  the number to divide the dividend by
	 * @return the truncated integer result of dividing dividend by divisor
	 */
	def divide(dividend: Int, divisor: Int): Int =
		if (dividend.sign == divisor.sign) {
			// round to int bounds
			Math.min(euclidDiv(Math.abs(dividend.toLong), Math.abs(divisor.toLong))._2, Int.MaxValue).toInt
		} else
			-euclidDiv(Math.abs(dividend.toLong), Math.abs(divisor.toLong))._2.toInt


	/**
	 * Recursive Euclid division between two positive integers.
	 *
	 * @param num numerator
	 * @param den denominator
	 * @return (remainder from division, truncated result)
	 */
	private def euclidDiv(num: Long, den: Long): (Long, Long) =
		if (num > den) {
			// get the euclidean division of num / 2*den
			// the result should be doubled and the remainder seen if it can be reduced further by den
			euclidDiv(num, den + den) match {
				case (rem, n) if rem >= den =>
					// the remainder can be divided by den so take it from the remainder and add one to the  result
					(rem - den, n + n + 1)
				case (rem, n) =>
					// the remainder cannot be divided by den (too small) so just forward the result
					(rem, n + n)
			}
		} else if (num < den) {
			// cannot be divided therefore return the unaltered value
			(num, 0)
		} else {
			// numerator = denominator therefore return
			(0, 1)
		}
}
