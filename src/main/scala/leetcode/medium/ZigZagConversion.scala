package leetcode.medium

object ZigZagConversion {

	/**
	 * Encrypts a string using a zig zag cypher and a given row count.
	 * Beats: 89.36% runtime (540 ms), 100% memory (51.2 MB)
	 *
	 * @param s       string to encrypt
	 * @param numRows row count to be used by the cypher
	 * @return s encrypted
	 */
	def convert(s: String, numRows: Int): String =
	// if 1 row then it is already done
		if (numRows == 1) {
			s
		} else {
			// setup string builder
			val sb = new StringBuilder()
			// determine the string for each row
			for (i <- 0 until numRows) {
				// offset used for the characters in the diagonals of the zig-zag
				// This is set to 10K for top and bottom lines as they do not have characters in diagonals,
				// and the max string size is 1K so it will ensure the if statement always fails.
				val diff = if (i == 0 || i == numRows - 1) 10000 else 2 * (numRows - i) - 2
				for (i <- i until s.length by (2 * numRows - 2)) {
					// character in the vertical line
					sb += s(i)
					// character in the diagonal, if there is one
					if (diff + i < s.length) {
						sb += s(diff + i)
					}
				}
			}
			sb.toString()
		}
}
