package leetcode.medium

object SearchRotSorArr {

	/**
	 * Searches for an element in a sorted array of unique integers that has been rotated at an unknown pivot index k (0 <= k < nums.length)
	 * such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1] ] (0-indexed).
	 * For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
	 *
	 * @param nums   Sorted array of unique integers that has been rotated around some index k.
	 * @param target value to find the index of
	 * @return the position of the value in the array, or -1 if it does not occur
	 */
	def search(nums: Array[Int], target: Int): Int = {
		// start of the window to check
		var winStart: Int = 0
		// end of the window to check
		var winEnd: Int = nums.length - 1
		// size of the window
		var winSize = winEnd - winStart

		// while the window has more than 2 elements
		while (winSize > 0) {
			// compute the midpoint (auto rounding down)
			val mid: Int = (winSize / 2) + winStart
			// test if the target is in the midpoint
			if (nums(mid) == target) {
				return mid
			}

			// update the window to be the area left or right of mid point
			if (nums(winStart) > nums(winEnd) && nums(mid).compare(target) == nums(winEnd).compare(target)) {
				// if the window has a rotation in it and the target value is larger or smaller than both the values in the
				// middle and end of the window then the rotation point is between the target value and the middle of the window
				// e.g.
				// target greater than both 7 in [7,0,1,2,3], [4,5,6,7,1],
				// target smaller than both 1 in [7,1,2,3,4], [4,5,6,1,2]

				// determine if the point of rotation is between the middle and end of the window
				if (nums(mid) > nums(winEnd)) {
					// if it does then update window to be its right half
					winStart = mid + 1
				} else {
					// otherwise update it to its left half
					winEnd = mid - 1
				}
				// If the above is false then either the point of rotation is not between middle and the target or the target is at the end
				// this is because if there is no rotation at all the first check above fails.
				// the second check will fail if the target is greater than or smaller than both the value in the middle and at the end of the window.
				// this check fails for one of four reasons:
				// 1) the value at the end of the window is the target value. This is the final else case in this if else block
				// 2) the value in the middle is the target. However this is caught before this conditional.
				// 3) the target is smaller than the end and greater than the middle.
				// In this case the value must be between mid and end,
				// as the only way mid can be smaller than the end is if there is no rotation between them.
				// 4) the target is larger than the end and smaller than the middle.
				// In this case the value must be left of the middle.
				// as being smaller than mid the target must either be left of it or in the un rotated area.
				// However it is larger than the last value so it cannot be in the un-rotated area. Leaving only left of the midpoint.
			} else if (nums(mid) < target) {
				// this covers both case 3 in the above, and where the region in the window is not rotated,
				// but target is right of the midpoint
				// in either of these cases the window should be updated to the right half
				winStart = mid + 1
			} else if (nums(winEnd) != target) {
				// this checks that case 1 in the above is not true.
				// meaning either case 4 must be true or the region in the window is not rotated and the target is left of the midpoint.
				// in either case the window should be updated to its left half
				winEnd = mid - 1
			} else {
				// otherwise the case 1 must be true
				// therefore we know the target value is in the end of the window so we return early
				return winEnd
			}

			// the window has been updated so its size must be recalculated
			winSize = winEnd - winStart
		}

		// if this has been reached then the window must have 1 value in it
		if (nums(winStart) == target) {
			// if it has the target then return it
			winStart
		} else {
			// otherwise return -1 as it was not found
			-1
		}
	}
}
