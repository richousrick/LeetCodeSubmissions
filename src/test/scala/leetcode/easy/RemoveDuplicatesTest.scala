package leetcode.easy

import org.scalatest.funsuite.AnyFunSuite

class RemoveDuplicatesTest extends AnyFunSuite {
	test("empty") {
		assert(RemoveDuplicates.removeDuplicates(Array()) == 0)
	}

	test("example 1") {
		val a = Array(1, 1, 2)
		assert(RemoveDuplicates.removeDuplicates(a) == 2)
		assert(a.dropRight(1) sameElements Array(1, 2))
	}

	test("example 2") {
		val a = Array(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)
		assert(RemoveDuplicates.removeDuplicates(a) == 5)
		assert(a.dropRight(5) sameElements Array(0, 1, 2, 3, 4))
	}
}
