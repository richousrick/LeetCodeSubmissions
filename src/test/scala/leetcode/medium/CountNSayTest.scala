package leetcode.medium

import org.scalatest.funsuite.AnyFunSuite

class CountNSayTest extends AnyFunSuite {

	test("1") {
		assert(CountNSay.countAndSay(1) == "1")
	}

	test("2") {
		assert(CountNSay.countAndSay(2) == "11")
	}

	test("3") {
		assert(CountNSay.countAndSay(3) == "21")
	}

	test("4") {
		assert(CountNSay.countAndSay(4) == "1211")
	}

	test("5") {
		assert(CountNSay.countAndSay(5) == "111221")
	}

	test("6") {
		assert(CountNSay.countAndSay(6) == "312211")
	}

	test("7") {
		assert(CountNSay.countAndSay(7) == "13112221")
	}

	test("8") {
		assert(CountNSay.countAndSay(8) == "1113213211")
	}

	test("9") {
		assert(CountNSay.countAndSay(9) == "31131211131221")
	}
}
