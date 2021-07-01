package leetcode.easy

object ValidParentheses {

	/**
	 * Tests if a given string of different brackets: (), {}, [], is valid.
	 * To be valid all brackets must be closed in the correct order and by the same bracket type.
	 * Beats: 98.52% runtime (412 ms), 99.26% memory (50.3 MB)
	 *
	 * @param s string containing the brackets.
	 * @return true if all brackets are closed in the correct order and by the same bracket type.
	 */
	def isValid(s: String): Boolean = {
		var bracketStack = List[Char]()
		s.toCharArray.foreach {
			case c@('{' | '[' | '(') => bracketStack = c +: bracketStack
			case '}' => if (bracketStack.nonEmpty && bracketStack.head == '{') {
				bracketStack = bracketStack.tail
			} else {
				return false
			}
			case ']' => if (bracketStack.nonEmpty && bracketStack.head == '[') {
				bracketStack = bracketStack.tail
			} else {
				return false
			}
			case ')' => if (bracketStack.nonEmpty && bracketStack.head == '(') {
				bracketStack = bracketStack.tail
			} else {
				return false
			}
			case _ => throw new Exception("Unexpected character")
		}
		bracketStack.isEmpty
	}
}
