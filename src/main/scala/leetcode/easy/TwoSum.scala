package leetcode.easy

object TwoSum {

	/**
	 * Finds the indices of the two numbers in array nums that add up to target.
	 * Beats Approx: 89.88% runtime, 39.95% memory
	 *
	 * @param nums   array of integers to search though
	 * @param target number that a pair of integers in nums should add to
	 * @return the indices of the pair of integers in nums that add to target
	 */
	def twoSum(nums: Array[Int], target: Int): Array[Int] = {
		//  sort and remove elements that even when added to the smallest number are too large
		val sorted = {
			val s = nums.zipWithIndex.sortBy(identity)
			s.filter(_._1 + s(0)._1 <= target)
		}

		for (i <- sorted.length - 1 to 1 by -1) {
			var j = 0
			while (j < i) {
				val sum = sorted(i)._1 + sorted(j)._1
				if (sum == target)
				// found
					return Array(sorted(i)._2, sorted(j)._2)
				else if (sum > target)
				// cannot be solved with i, so force wile to escape
					j = i
				else
				// continue
					j += 1
			}
		}
		Array()
	}
}
