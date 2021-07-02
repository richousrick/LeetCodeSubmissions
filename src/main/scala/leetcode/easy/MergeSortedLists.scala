package leetcode.easy

import leetcode.predef.ListNode

import scala.annotation.tailrec

object MergeSortedLists {

	/**
	 * Merges two sorted lists, utilizing the nodes.
	 * Implemented using recursion to be concise.
	 * Beats: 86.09% runtime (484 ms), 73.91% memory (53.8 MB)
	 *
	 * @param l1 first sorted list
	 * @param l2 second sorted list
	 * @return a list containing all the nodes in l1 and l2 sorted.
	 */
	def mergeTwoListsSmall(l1: ListNode, l2: ListNode): ListNode =
		(l1, l2) match {
			case (null, null) => null
			case (l, null) => l
			case (null, l) => l
			case _ =>
				if (l1.x <= l2.x) {
					l1.next = mergeTwoListsSmall(l1.next, l2)
					l1
				} else {
					l2.next = mergeTwoListsSmall(l1, l2.next)
					l2
				}
		}


	/**
	 * Merges two sorted lists, utilizing the nodes.
	 * Implemented to be tail recursive.
	 * Beats: 94.78% runtime (472 ms), 73.91% memory (53.7 MB)
	 *
	 * @param l1   first sorted list
	 * @param l2   second sorted list
	 * @param head pointer to the head of the return list
	 * @param tail pointer to the tail of the return list
	 * @return a list containing all the nodes in l1 and l2 sorted.
	 */
	@tailrec
	def mergeTwoLists(l1: ListNode, l2: ListNode, head: ListNode = null, tail: ListNode = null): ListNode =
		(l1, l2) match {
			case (null, l) =>
				if (head == null)
					l
				else {
					tail.next = l
					head
				}
			case (l, null) =>
				if (head == null)
					l
				else {
					tail.next = l
					head
				}
			case (l, r) =>
				val (lH, rH, n) = {
					if (l.x <= r.x) {
						(l.next, r, l)
					} else {
						(l, r.next, r)
					}
				}
				mergeTwoLists(lH, rH, Option(head).getOrElse(n), Option(tail).map(t => {
					t.next = n
					n
				}).getOrElse(n))
		}


	/**
	 * Merges two sorted lists, utilizing the nodes.
	 * Implemented without recursion
	 * Beats: 75.65% runtime (492 ms), 62.61% memory (53.8 MB)
	 *
	 * @param l1 first sorted list
	 * @param l2 second sorted list
	 * @return a list containing all the nodes in l1 and l2 sorted.
	 */
	def mergeTwoListsNoRecursion(l1: ListNode, l2: ListNode): ListNode = {
		// null handling
		if (l1 == null) {
			return l2
		} else if (l2 == null) {
			return l1
		}
		// pointers to list heads
		var l1h: ListNode = l1
		var l2h: ListNode = l2
		// setup return value
		val resH: ListNode = if (l1.x <= l2.x) {
			l1h = l1h.next
			l1
		} else {
			l2h = l2h.next
			l2
		}
		var resT: ListNode = resH
		// main loop
		while (l1h != null && l2h != null) {
			resT.next = if (l1h.x < l2h.x) {
				val r = l1h
				l1h = l1h.next
				r
			} else {
				val r = l2h
				l2h = l2h.next
				r
			}
			resT = resT.next
		}
		// append longest list
		(l1h, l2h) match {
			case (null, l) => resT.next = l
			case (l, null) => resT.next = l
			case _ => throw new Exception("Should still be in while loop")
		}
		resH
	}
}
