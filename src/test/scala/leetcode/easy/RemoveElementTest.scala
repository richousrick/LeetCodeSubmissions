package leetcode.easy

import org.scalatest.funsuite.AnyFunSuite

class RemoveElementTest extends AnyFunSuite {

	test("empty") {
		val a = Array[Int]()
		assert(RemoveElement.removeElement(a, 1) == 0)
		assert(a sameElements Array[Int]())
	}

	test("clear array") {
		val arr = Array[Int](1)
		assert(RemoveElement.removeElement(arr, 1) == 0)
	}

	test("example 1") {
		val nums = Array(3, 2, 2, 3)
		assert(RemoveElement.removeElement(nums, 3) == 2)
		assert(nums.dropRight(2).toSet == Set(2, 2))
	}

	test("example 2") {
		val nums = Array(0, 1, 2, 2, 3, 0, 4, 2)
		assert(RemoveElement.removeElement(nums, 2) == 5)
		assert(nums.dropRight(3).toSet == Set(0, 1, 3, 0, 4))
	}
}
