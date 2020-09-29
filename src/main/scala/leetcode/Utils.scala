package leetcode

object Utils {

	/**
	 * Asserts a given function will return the expected value when given a specified input
	 *
	 * @param testFunc       function to test the given input on
	 * @param input          to pass to the function
	 * @param expectedResult of lengthOfLongestSubstring when given the specified input
	 * @tparam I datatype of the input taken by the test function
	 * @tparam O datatype of the output returned by the test function
	 * @throws AssertionError if lengthOfLongestSubstring does not return the expected result
	 */
	def test[I, O](testFunc: I => O, input: I, expectedResult: O): Boolean = {
		val actualResult = testFunc(input)
		if (actualResult != expectedResult) {
			throw new AssertionError(s"""Expected $expectedResult got $actualResult for input "$input"""")
		} else {
			true
		}
	}
}
