package leetcode.medium

import scala.annotation.tailrec

object CountNSay {

	/**
	 * Tail recursive count and say starting at "1"
	 * countAndSay(n) where n>1 is how you would say count and say(n-1)
	 * for example the sequence starts: 1, 11 (1 one), 21 (2 ones), 1211 (1 two & 1 one), ...
	 *
	 * @param n    desired number of recursive calls
	 * @param curr current answer for this value (data forwarded for tail recursion)
	 * @return the desired
	 */
	@tailrec
	def countAndSay(n: Int, curr: String = "1"): String =
		if (n <= 1) {
			curr
		} else {
			/**
			 * Computes the CountAndSay for a given string
			 *
			 * @param str string to do a count and say for
			 * @return the count and say result for str
			 */
			def parse(str: String): String = {
				// result
				val sb = new StringBuilder
				// current digit
				var cd: Char = str.head
				// counter for current digit
				var c = 1
				// iterate over each digit and build the resulting string
				Option(str.tail).getOrElse("").foreach(d => {
					if (d == cd) {
						// if the digit at this position matches the previous digit then increment the counter
						c += 1
					} else {
						// if this digit does not match the last one then
						// append the previous groups count and digit
						sb.append(c).append(cd)
						// reset the counter and current digit
						c = 1
						cd = d
					}
				})
				// as the last group will not be appended to the string append it now then return the string
				sb.append(c).append(cd).toString()
			}
			// recursive call
			countAndSay(n - 1, parse(curr))
		}
}
