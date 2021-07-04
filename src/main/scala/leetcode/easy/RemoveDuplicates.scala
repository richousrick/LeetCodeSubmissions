package leetcode.easy

object RemoveDuplicates {

	/**
	 * Removes all duplicate integers from a sorted array in place.
	 *
	 * @param nums array of integers to remove the duplicates from
	 * @return the size of the updated array.
	 */
	def removeDuplicates(nums: Array[Int]): Int =
		if (nums.isEmpty) {
			// As the lowest value the return case can return is 1, this case is necessary
			0
		} else {
			// pointer to where non duplicate elements should be inserted in the array
			var insert = 1
			for (i <- 1 until nums.length) {
				// copy single instance of each integer in the array
				// as the array is sorted, this can be done by only using numbers that differ from their predecessor.
				if (nums(i) != nums(i - 1)) {
					nums(insert) = nums(i)
					insert += 1
				}
			}
			insert
		}
}
