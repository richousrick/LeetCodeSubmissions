package leetcode.hard

import org.scalatest.funsuite.AnyFunSuite

class FirstMissingPositiveTest extends AnyFunSuite {

	test("Example 1") {
		assert(FirstMissingPositive.firstMissingPositive(Array(1, 2, 0)) == 3)
	}

	test("Example 2") {
		assert(FirstMissingPositive.firstMissingPositive(Array(3, 4, -1, 1)) == 2)
	}

	test("Example 3") {
		assert(FirstMissingPositive.firstMissingPositive(Array(7, 8, 9, 11, 12)) == 1)
	}

	test("None Missing") {
		assert(FirstMissingPositive.firstMissingPositive(Array(1, 4, 2, 3)) == 5)
	}

	test("Duplication 1") {
		assert(FirstMissingPositive.firstMissingPositive(Array(1, 1)) == 2)
	}

	test("Duplication 2") {
		assert(FirstMissingPositive.firstMissingPositive(Array(1, 2, 1)) == 3)
		assert(FirstMissingPositive.firstMissingPositive(Array(1, 1, 2)) == 3)
		assert(FirstMissingPositive.firstMissingPositive(Array(2, 1, 1)) == 3)

		assert(FirstMissingPositive.firstMissingPositive(Array(2, 2, 1)) == 3)
		assert(FirstMissingPositive.firstMissingPositive(Array(1, 2, 2)) == 3)
		assert(FirstMissingPositive.firstMissingPositive(Array(2, 1, 2)) == 3)
	}
}
