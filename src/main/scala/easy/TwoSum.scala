package easy

object TwoSum {
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


	def main(args: Array[String]): Unit = {
		println(twoSum(Array(2, 7, 11, 15), 9).toSet == Set(0, 1))

		println(twoSum(Array(3, 2, 4), 6).toSet == Set(1, 2))

		println(twoSum(Array(3, 3), 6).toSet == Set(0, 1))
	}
}
