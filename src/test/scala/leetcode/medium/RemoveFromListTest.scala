package leetcode.medium

import leetcode.TestUtils.listBuilder
import org.scalatest.funsuite.AnyFunSuite

class RemoveFromListTest extends AnyFunSuite {

	test("multiple") {
		assert(RemoveFromList.removeNthFromEnd(listBuilder(1, 2, 3, 4, 5), 2).toString == listBuilder(1, 2, 3, 5).toString)
	}

	test("single") {
		assert(RemoveFromList.removeNthFromEnd(listBuilder(1), 1) == null)
	}

	test("double end") {
		assert(RemoveFromList.removeNthFromEnd(listBuilder(1, 2), 1).toString == listBuilder(1).toString)
	}

	test("double front") {
		assert(RemoveFromList.removeNthFromEnd(listBuilder(1, 2), 2).toString == listBuilder(2).toString)
	}

	test("triple") {
		assert(RemoveFromList.removeNthFromEnd(listBuilder(1, 2, 3), 3).toString == listBuilder(2, 3).toString)
		assert(RemoveFromList.removeNthFromEnd(listBuilder(1, 2, 3), 2).toString == listBuilder(1, 3).toString)
		assert(RemoveFromList.removeNthFromEnd(listBuilder(1, 2, 3), 1).toString == listBuilder(1, 2).toString)
	}


}
