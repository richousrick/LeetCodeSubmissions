package medium

object StringToInteger {
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
	def atoiInner(str: List[Char]): Int = {
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

	def main(args: Array[String]): Unit = {
		// test simple +- nums
		testAtoi("42", 42)
		testAtoi("+38", 38)
		testAtoi("-27", -27)

		// test leading whitespace
		testAtoi("      -42", -42)
		testAtoi("    +12", 12)
		testAtoi("         76", 76)

		// test multiSign fails
		testAtoi("+-23", 0)
		testAtoi("-+38", 0)

		// test invalid start
		testAtoi("words and 987", 0)
		testAtoi("word42", 0)
		testAtoi("word+36", 0)
		testAtoi("+ 12", 0)
		testAtoi(" + 12", 0)
		testAtoi("- 48", 0)
		testAtoi(" - 65", 0)

		// test end
		testAtoi("-48 3", -48)
		testAtoi("13a", 13)
		testAtoi("13 Appt. 12", 13)
		testAtoi("73-5", 73)

		// test range
		testAtoi(Integer.MAX_VALUE + "", Integer.MAX_VALUE)
		testAtoi(Integer.MAX_VALUE - 1L + "", Integer.MAX_VALUE - 1)
		testAtoi(Integer.MAX_VALUE + 1L + "", Integer.MAX_VALUE)
		testAtoi(Integer.MAX_VALUE + 1000L + "", Integer.MAX_VALUE)
		testAtoi(Long.MaxValue + "", Integer.MAX_VALUE)
		testAtoi(Long.MaxValue + "1234", Integer.MAX_VALUE)

		testAtoi(Integer.MIN_VALUE + "", Integer.MIN_VALUE)
		testAtoi(Integer.MIN_VALUE + 1L + "", Integer.MIN_VALUE + 1)
		testAtoi(Integer.MIN_VALUE - 1L + "", Integer.MIN_VALUE)
		testAtoi(Integer.MIN_VALUE - 1000L + "", Integer.MIN_VALUE)
		testAtoi(Long.MinValue + "", Integer.MIN_VALUE)
		testAtoi(Long.MinValue + "1234", Integer.MIN_VALUE)

		// test None
		testAtoi("", 0)
		testAtoi("+", 0)
		testAtoi("-", 0)

		testAtoi("+hi", 0)
		testAtoi("-hi", 0)
		testAtoi("hi", 0)

		testAtoi("+ hi", 0)
		testAtoi("- hi", 0)
		testAtoi(" hi", 0)

		// test leading 0's
		testAtoi("  0000000000012345678", 12345678)
		testAtoi("  -0000000000012345678", -12345678)
		testAtoi("0100", 100)

		testAtoi("0-1", 0)
		testAtoi("0+1", 0)


		println("Sucessful")
	}


	/**
	 * Tests the [[medium.StringToInteger#myAtoi]] function returns the expected integer when given a specified input
	 *
	 * @param input    to test the function on
	 * @param expected return from calling myAtoi(input)
	 * @return true if myAtoi(input) results in the expected value
	 * @throws AssertionError if myAtoi(input) does not return the expected value
	 */
	def testAtoi(input: String, expected: Int): Boolean =
		myAtoi(input) match {
			case got if got == expected => true
			case result => throw new AssertionError(s"Expected '$input' to result in $expected, Got $result")
		}
}
