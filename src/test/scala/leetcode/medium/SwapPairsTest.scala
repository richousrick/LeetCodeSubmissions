package leetcode.medium

import leetcode.TestUtils.listBuilder
import leetcode.predef.ListNode
import org.scalatest.funsuite.AnyFunSuite

class SwapPairsTest extends AnyFunSuite {

	test("empty") {
		assert(SwapPairs.swapPairs(null) == null)
	}

	test("single") {
		assert(SwapPairs.swapPairs(new ListNode(1)).toString == "1")
	}

	test("double") {
		assert(SwapPairs.swapPairs(listBuilder(1, 2)).toString == "2,1")
	}

	test("triple") {
		assert(SwapPairs.swapPairs(listBuilder(1, 2, 3)).toString == "2,1,3")
	}

	test("quad") {
		assert(SwapPairs.swapPairs(listBuilder(1, 2, 3, 4)).toString == "2,1,4,3")
	}
}
