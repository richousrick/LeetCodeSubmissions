package leetcode.medium

object StringToInteger {

	/**
	 * Converts a list of characters to a signed Integer
	 * Beats Approx: 95.24% runtime, 44.44% memory
	 *
	 * @param str , list of characters to parse as an integer
	 * @return the signed integer located at the start of the string or 0 if none exist
	 */
	def myAtoi(str: String): Int = {
		if (str.isEmpty)
			0
		else {
			atoiInner(str.toList)
		}
	}

	/**
	 * Converts a list of characters to a signed Integer
	 *
	 * @param str , list of characters to parse as an integer
	 * @return the signed integer located at the start of the string or 0 if none exist
	 */
	private def atoiInner(str: List[Char]): Int = {
		//Int in range 0-2 where:
		//	 0: Undefined assumed positive
		//	 1: Defined Positive
		//	 2: Defined negative
		var sign: Byte = 0

		// unsigned current result
		var unsignedResult: Long = 0

		// significance of the next digit, i.e. 3 = 1000s (10^3)
		var significantDigit = 0

		// position of next unchecked char in str
		var i = 0

		// 10^11 > Integer.MAX_VALUE, so when significant digit == 11 max value is returned
		while (i < str.size && significantDigit < 11) {
			(sign + unsignedResult, str(i)) match {
				// ignore leading whitespace
				case (0, ' ') =>

				// handle signs
				case (0, '-') =>
					if (sign == 0)
					// set sign to negative
						sign = 2
					else
					// sign already set, invalid input
						return 0
				case (0, '+') =>
					if (sign == 0)
					// set sign to positive
						sign = 1
					else
					// sign already set, invalid input
						return 0

				// handle numbers

				case (0, num) if Character.isDigit(num) =>
					// set sign
					sign = 1

					// add digit, skipping leading 0's
					if (!(unsignedResult == 0 && num.asDigit == 0)) {
						unsignedResult = num.asDigit + unsignedResult * 10
						significantDigit += 1
					}

				case (_, num) if Character.isDigit(num) =>
					// add digit, skipping leading 0's
					if (!(unsignedResult == 0 && num.asDigit == 0)) {
						unsignedResult = num.asDigit + unsignedResult * 10
						significantDigit += 1
					}


				// handle end
				case _ =>
					// either a sign has been encountered after the number has been signed,
					// or a character that is not a digit or leading whitespace has been encountered.
					// force i to equal str.size (as 1 is added next operation take 1)
					i = (str.size - 1).toByte
			}
			i += 1
		}

		if (significantDigit == 11) {
			// Ensure unsignedResult is rounded down when signed
			unsignedResult = Integer.MAX_VALUE + 100L
		}

		val res = sign match {
			case 2 => math.max(-unsignedResult, Integer.MIN_VALUE).toInt
			case _ => math.min(unsignedResult, Integer.MAX_VALUE).toInt
		}
		res
	}
}
