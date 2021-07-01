package leetcode.easy

import org.scalatest.funsuite.AnyFunSuite

class LongestCommonPrefixTest extends AnyFunSuite {
	test("no prefix ever") {
		assert(LongestCommonPrefix.longestCommonPrefix(Array("dog", "racecar", "car")) == "")
	}

	test("some prefix start") {
		assert(LongestCommonPrefix.longestCommonPrefix(Array("dog", "dour", "car")) == "")
	}

	test("some prefix end") {
		assert(LongestCommonPrefix.longestCommonPrefix(Array("tour", "dog", "dour", "car")) == "")
	}

	test("prefix") {
		assert(LongestCommonPrefix.longestCommonPrefix(Array("flower", "flow", "flight")) == "fl")
	}
}
