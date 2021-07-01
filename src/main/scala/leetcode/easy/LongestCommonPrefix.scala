package leetcode.easy

object LongestCommonPrefix {

	/**
	 * Finds the longest prefix shared by all strings in a given array
	 * Beats: 93.75% runtime (452 ms), 97.92% memory (50.8 MB)
	 *
	 * @param strs an array of strings to search for the common prefix
	 * @return the longest prefix shared by all strings in the input array
	 */
	def longestCommonPrefix(strs: Array[String]): String = {
		strs.reduceLeft((l: String, r: String) => {
			// if current prefix is empty then return the empty prefix
			if (l.isEmpty)
				return l
			// otherwise find the index where the two strings stop being identical and return that substring
			l.substring(0, {
				var i = 0
				// find the index where the two strings stop being identical
				while (i < l.size && i < r.size && l(i) == r(i)) {
					i += 1
				}
				i
			})
		})
	}
}
