package leetcode.medium

import org.scalatest.funsuite.AnyFunSuite

class SearchRotSorArrTest extends AnyFunSuite {

	test("Single match") {
		assert(SearchRotSorArr.search(Array(1), 1) == 0)
	}

	test("Single no match") {
		assert(SearchRotSorArr.search(Array(1), 2) == -1)
		assert(SearchRotSorArr.search(Array(1), 0) == -1)
	}

	test("Pair first") {
		assert(SearchRotSorArr.search(Array(2, 1), 2) == 0)
	}

	test("Pair Second") {
		assert(SearchRotSorArr.search(Array(2, 1), 1) == 1)
	}

	test("Pair no match") {
		assert(SearchRotSorArr.search(Array(2, 1), 3) == -1)
		assert(SearchRotSorArr.search(Array(2, 1), 0) == -1)
	}

	test("Example 1") {
		assert(SearchRotSorArr.search(Array(4, 5, 6, 7, 0, 1, 2), 0) == 4)
	}

	test("Example 2") {
		assert(SearchRotSorArr.search(Array(4, 5, 6, 7, 0, 1, 2), 3) == -1)
	}

	test("End") {
		assert(SearchRotSorArr.search(Array(4, 5, 6, 7, 0, 1), 1) == 5)
	}

	test("C-1-1 A") {
		assert(SearchRotSorArr.search(Array(7, 0, 1, 2, 3), 7) == 0)
	}

	test("C-1-1 B") {
		assert(SearchRotSorArr.search(Array(4, 5, 6, 7, 1), 7) == 3)
	}

	test("C-11") {
		assert(SearchRotSorArr.search(Array(7, 0, 1, 2, 3), 2) == 3)
	}


	test("C1-1") {
		assert(SearchRotSorArr.search(Array(6, 7, 8, 1, 2), 7) == 1)
	}

	test("C11 A") {
		assert(SearchRotSorArr.search(Array(7, 1, 2, 3, 4), 1) == 1)
	}

	test("C11 B") {
		assert(SearchRotSorArr.search(Array(4, 5, 6, 1, 2), 1) == 3)
	}

	test("Regression 1") {
		assert(SearchRotSorArr.search(Array(4, 5, 6, 7, 0, 1, 2), 1) == 5)
	}

	test("Regression 2") {
		assert(SearchRotSorArr.search(Array(6, 7, 8, 1, 2, 3, 4, 5), 6) == 0)
	}

	test("Regression 3") {
		assert(SearchRotSorArr.search(Array(2, 3, 7, 8, 1), 5) == -1)
	}
}
