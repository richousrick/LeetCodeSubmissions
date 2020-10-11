package leetcode.easy

object RomanToInteger {

	/**
	 * Converts a Roman numeral to an integer.
	 * Beats: 100.00% runtime, 5.88% memory
	 *
	 * @param s roman numeral to convert
	 * @return the integer represented by the roman numeral
	 */
	def romanToInt(s: String): Int = {
		s.foldRight(0) {
			case ('I', sum) => if (sum >= 5) {
				sum - 1
			} else {
				sum + 1
			}
			case ('V', sum) => sum + 5
			case ('X', sum) => if (sum >= 50) {
				sum - 10
			} else {
				sum + 10
			}
			case ('L', sum) => sum + 50
			case ('C', sum) => if (sum >= 500) {
				sum - 100
			} else {
				sum + 100
			}
			case ('D', sum) => sum + 500
			case ('M', sum) => sum + 1000
			case _ => throw new UnsupportedOperationException("This case should not be called unless the input is invalid")
		}
	}
}
