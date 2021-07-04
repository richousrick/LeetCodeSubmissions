package leetcode.medium

import leetcode.predef.ListNode

import scala.annotation.tailrec

object SwapPairs {

	/**
	 * Swaps each pairs of nodes in the list.
	 * i.f. for list 1,2,3,4,5 the resultant list will be 2,1,4,3,5.
	 * This method is not as concise however, due to tail recursive optimisation it can work on much larger lists;
	 * up to at least 10,000,000 nodes
	 *
	 * @param head pointer to the head of the list
	 * @return the list with each pair of nodes swapped
	 */
	def swapPairs(head: ListNode): ListNode =
	// if at least 2 elements in the list then they must be swapped, otherwise the head can be returned
		if (head != null && head.next != null) {
			@tailrec
			// tail recursive method to swap all pairs of nodes in the list
			def swapPairsInPlace(head: ListNode, oldTail: ListNode = null): Unit =
				if (head != null && head.next != null) {
					val newHead = head.next
					// set pointer to the next (possible) pair of elements in the list
					val tmp = newHead.next
					// make the second node in the list point to the first
					newHead.next = head
					// make the tail of the previous pair point to the head of this pair
					if (oldTail != null) {
						oldTail.next = newHead
					}
					// if there is another pair, then do this again, otherwise make the tail of this pair point to null
					if (tmp != null)
						swapPairsInPlace(tmp, head)
					else
						head.next = null
				} else {
					// if this is not a pair, then make the old tail point to the current head
					oldTail.next = head
				}

			// get pointer to second element (what will become the head)
			val r = head.next
			// run recursive swap over the list
			swapPairsInPlace(head)
			// return the head
			r
		} else {
			head
		}


	/**
	 * Swaps each pairs of nodes in the list.
	 * i.f. for list 1,2,3,4,5 the resultant list will be 2,1,4,3,5.
	 * This is a short implementation.
	 * However it's stack bloats quickly causing stack overflow on relatively large lists (~10K+ nodes)
	 *
	 * @param head pointer to the head of the list
	 * @return the list with each pair of nodes swapped
	 */
	def swapPairsConcise(head: ListNode): ListNode = {
		// if at least 2 elements in the (sub) list then swap them
		if (head != null && head.next != null) {
			// pointer to second element
			val h = head.next
			// recursively swap all later pairs, and make the first element point to the root of the resultant list
			head.next = Option(h.next).map(swapPairsConcise).orNull
			// make the second element in the list the head and return it
			h.next = head
			h
		} else {
			head
		}
	}
}
