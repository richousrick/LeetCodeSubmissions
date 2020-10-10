package leetcode.medium

import leetcode.medium.LengthOfLongestSubstring._
import org.scalatest.funsuite.AnyFunSuite

class LengthOfLongestSubstringTest extends AnyFunSuite {

	test("Empty String") {
		assert(lengthOfLongestSubstring("") == 0)
	}

	test("Repeat Same Character") {
		assert(lengthOfLongestSubstring("aa") == 1)
		assert(lengthOfLongestSubstring("bbb") == 1)
		assert(lengthOfLongestSubstring("bbbb") == 1)
		assert(lengthOfLongestSubstring("aaaaaa") == 1)
	}

	test("Simple Examples") {
		assert(lengthOfLongestSubstring("abcabcbb") == 3)
		assert(lengthOfLongestSubstring("abcabcbbcfacb") == 4)
		assert(lengthOfLongestSubstring("abcabcbbcfacbd") == 5)
		assert(lengthOfLongestSubstring("pwwkew") == 3)
	}
}
