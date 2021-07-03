package leetcode.easy

object RemoveElement {

	/**
	 * Removes all instances of the val from the give array
	 *
	 * @param nums  array to modify
	 * @param `val` number to remove
	 * @return the size of the modified array.
	 *         i.e. n where updatedNums = nums.dropRight(nums.size-n)
	 */
	def removeElement(nums: Array[Int], `val`: Int): Int = {
		// number of elements found in the array, that can be ignored when inserting
		var skipped = 0
		// iterate over each element in the array shifting them if necessary
		for (i <- nums.indices) {
			// if the current element in the array is the target push the insertion location back a place
			if (nums(i) == `val`) {
				skipped += 1
			} else {
				// if the current element is not in the array move it to the relevant place
				nums(i - skipped) = nums(i)
			}
		}
		nums.length - skipped
	}
}