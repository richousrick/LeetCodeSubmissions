package leetcode.medium

import leetcode.predef.ListNode

object RemoveFromList {

	/**
	 * Removes the n'th last element from the list.
	 * Trimmed down version of the above.
	 *
	 * @param head pointer to the head of the list
	 * @param n    index of the element that should be removed
	 * @return the list with the desired node removed
	 */
	def removeNthFromEnd(head: ListNode, n: Int): ListNode = {
		// current suspect for the node before the one to remove
		var target = head
		// pointer used to find the last element in the list
		var pointer = head
		// put pointer n nodes ahead of target
		for (_ <- 1 until n + 1) {
			pointer = pointer.next
		}

		// if the node n nodes ahead of target is null, then target is the head of the list
		if (pointer == null) {
			// if removing first element, return second
			head.next
		} else {
			// if not removing the head of the list, iterate thought the list to find the end
			while (pointer.next != null) {
				pointer = pointer.next
				target = target.next
			}
			// remove the node after target from the list
			target.next = target.next.next
			head
		}
	}
}