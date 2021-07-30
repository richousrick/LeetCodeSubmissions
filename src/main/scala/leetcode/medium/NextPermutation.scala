package leetcode.medium

import scala.util.control.Breaks.{break, breakable}

object NextPermutation {

	/**
	 * Rearranges numbers into the lexicographically next greater permutation of numbers.
	 * If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
	 * Note: this is done inplace, updating nums.
	 *
	 * @param nums the numbers to be rearranged
	 */
	def nextPermutationWhile(nums: Array[Int]): Unit = {
		/**
		 * Updates the array and returns index i where array[i .. n] needs to be sorted into ascending order
		 *
		 * @return the start index of the subarray that needs to be sorted
		 */
		def update(): Int = {
			// from right to left find first value not in ascending order
			var i = nums.length - 2
			while (i >= 0) {
				if (nums(i) < nums(i + 1)) {
					// swap it with the smallest value that is larger than it
					var j = nums.length - 1
					while (j > i) {
						if (nums(j) > nums(i)) {
							swap(i, j)
							// area after the larger of the newly swapped values needs to be sorted in ascending order, so return its index
							return i + 1
						}
						j -= 1
					}
				}
				i -= 1
			}
			// no swap occurred so the whole array must be sorted
			0
		}

		/**
		 * Swaps the values at positions a and b with one another
		 *
		 * @param a index of the first value to swap
		 * @param b index of the second value to swap
		 */
		def swap(a: Int, b: Int): Unit = {
			val old = nums(a)
			nums(a) = nums(b)
			nums(b) = old
		}

		// get the starting index of the subarray that needs to be sorted
		val sortStart = update()

		// sort the subarray
		// as the subarray is already sorted but in the wrong direction, it can be reversed.
		var i = 0
		while (i < (nums.length - sortStart) / 2) {
			swap(i + sortStart, nums.length - i - 1)
			i += 1
		}
	}


	/**
	 * Rearranges numbers into the lexicographically next greater permutation of numbers.
	 * If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
	 * Note: this is done inplace, updating nums.
	 *
	 * This implementation is based on the above, however it is optimised to minimize variables.
	 *
	 * @param nums the numbers to be rearranged
	 */
	def nextPermutation(nums: Array[Int]): Unit = {
		// auxiliary integer
		var j = 0
		var sortStart = 0
		var i: Int = nums.length - 2

		def swap(a: Int, b: Int): Unit = {
			j = nums(a)
			nums(a) = nums(b)
			nums(b) = j
		}

		// from right to left find first value not in ascending order
		breakable {
			while (i >= 0) {
				if (nums(i) < nums(i + 1)) {
					// swap it with the smallest value that is larger than it
					j = nums.length - 1
					while (j > i) {
						if (nums(j) > nums(i)) {
							swap(i, j)
							// area after the larger of the newly swapped values needs to be sorted in ascending order, so return its index
							sortStart = i + 1
							break
						}
						j -= 1
					}
				}
				i -= 1
			}
		}

		// if not returned then the array is sorted so reverse inplace
		i = 0
		while (i < (nums.length - sortStart) / 2) {
			swap(i + sortStart, nums.length - i - 1)
			i += 1
		}
	}
}
