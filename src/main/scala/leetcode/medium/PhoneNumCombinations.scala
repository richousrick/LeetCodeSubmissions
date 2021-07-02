package leetcode.medium

/**
 * Array based implementation
 * Beats: 95.28% runtime (420 ms), 82.08% memory (50.9 MB)
 */
object PhoneNumCombinations {
	val letterMappings = Array[Array[Char]](Array('a', 'b', 'c'),
		Array('d', 'e', 'f'),
		Array('g', 'h', 'i'),
		Array('j', 'k', 'l'),
		Array('m', 'n', 'o'),
		Array('p', 'q', 'r', 's'),
		Array('t', 'u', 'v'),
		Array('w', 'x', 'y', 'z'))

	def letterCombinations(digits: String): List[String] =
		if (digits.isEmpty) {
			List()
		} else {
			// digits mapped to their respective index in letterMappings
			val dArr: Array[Int] = digits.toCharArray.map(_.asDigit - 2)
			// number of strings that will be returned
			val combinations = {
				val quadOpt = dArr.count {
					case 5 | 7 => true
					case _ => false
				}
				Math.pow(4, quadOpt) * Math.pow(3, dArr.length - quadOpt)
			}.toInt
			// array of dims [num combinations, string size]
			val resultArray = Array.ofDim[Char](combinations, dArr.length)
			// number to divide each index by before it can be used in conjunction with the modulo operator
			val mods: Array[Int] = {
				var i = 1
				dArr.drop(1).reverse.map { c =>
					i *= letterMappings(c).size
					i
				}.reverse :+ 1
			}
			for (str <- 0 until combinations) {
				for (char <- dArr.indices) {
					// possible characters represented by the given digit
					val mappings = letterMappings(dArr(char))
					resultArray(str)(char) = mappings(math.floor(str / mods(char)).toInt % mappings.size)
				}
			}
			// Convert 2D array into List[String]
			resultArray.map(_.mkString).toList
		}
}
