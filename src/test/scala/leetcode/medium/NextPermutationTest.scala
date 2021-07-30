package leetcode.medium

import org.scalatest.funsuite.AnyFunSuite

class NextPermutationTest extends AnyFunSuite {

	test("Example 1") {
		assert(funWrapper(1, 2, 3) sameElements Array(1, 3, 2))
	}

	test("Example 2") {
		assert(funWrapper(3, 2, 1) sameElements Array(1, 2, 3))
	}

	test("Example 3") {
		assert(funWrapper(1, 1, 5) sameElements Array(1, 5, 1))
	}

	test("Example 4") {
		assert(funWrapper(1) sameElements Array(1))
	}

	test("Regression 1") {
		assert(funWrapper(1, 3, 2) sameElements Array(2, 1, 3))
	}

	test("longer") {
		assert(funWrapper(7, 1, 4, 6, 5, 3, 2) sameElements Array(7, 1, 5, 2, 3, 4, 6))
	}

	def funWrapper(values: Int*): Array[Int] = {
		val arr: Array[Int] = values.toArray
		NextPermutation.nextPermutation(arr)
		arr
	}
}
