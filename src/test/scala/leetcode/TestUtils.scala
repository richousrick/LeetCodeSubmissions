package leetcode

import leetcode.predef.ListNode

object TestUtils {

	/**
	 * Builder method for constructing lists
	 *
	 * @param ints desired list of integers
	 * @return a ListNode representing the given list of integers
	 */
	def listBuilder(ints: Int*): ListNode =
		ints.dropRight(1).foldRight(new ListNode(ints.last))((i, l) => new ListNode(i, l))
}
