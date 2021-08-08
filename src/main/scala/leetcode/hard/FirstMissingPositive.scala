package leetcode.hard

object FirstMissingPositive {

	/**
	 * Finds the smallest positive integer not present in the given array, in linear time O(n) and constant memory.
	 *
	 * @param nums array to search
	 * @return the smallest positive integer not in nums
	 */
	def firstMissingPositive(nums: Array[Int]): Int = {
		// move each element to its place in the array

		var i = 0
		while (i < nums.length) {
			// move each element to its place
			if (nums(i) != 0 && nums(i) != i + 1) {

				var toMove = nums(i)

				// Set to ignore
				nums(i) = 0

				while (toMove > 0 && toMove <= nums.length && nums(toMove - 1) != toMove) {
					// number that will be overwritten
					val toReplace = nums(toMove - 1)

					// overwrite it
					nums(toMove - 1) = toMove

					// update toMove
					toMove = toReplace
				}
			}
			i += 1
		}

		// find first element set to ignore (0)
		i = 0
		while (i < nums.length) {
			if (nums(i) == 0) {
				return i + 1
			} else {
				i += 1
			}
		}
		nums.length + 1
	}
}
