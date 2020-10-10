package leetcode.easy

import scala.annotation.tailrec

object PalindromeNumber {

	/**
	 * Tests if an integer is a palindrome.
	 * Beats: 100.00% runtime, 37.86% memory
	 *
	 * @param x integer to test if it is a palindrome
	 * @return true if x is a palindrome
	 */
	def isPalindrome(x: Int): Boolean = {
		/**
		 * Test if a number is a palindrome
		 *
		 * @param x               a positive integer that is to be tested for reversibility
		 * @param maxSigDigitMask 10^floor(log10(x))^ this is used as a mask to separate the most significant (left most) digit from the target input x
		 * @return true if x is a palindrome, false otherwise
		 */
		@tailrec
		def isPalindrome(x: Double, maxSigDigitMask: Double): Boolean = {
			if (maxSigDigitMask <= 1) {
				true
			} else {
				// test the most and least significant digits are the same
				if (math.floor(x / maxSigDigitMask) == x % 10) {
					isPalindrome(math.floor((x % maxSigDigitMask) / 10), math.floor(maxSigDigitMask / 100))
				} else {
					false
				}
			}
		}

		// if negative return false
		if (x < 0)
			false
		else
			isPalindrome(x, math.pow(10, math.floor(math.log10(x))))
	}
}
