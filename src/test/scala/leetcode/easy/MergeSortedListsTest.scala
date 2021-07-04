package leetcode.easy

import leetcode.TestUtils.listBuilder
import leetcode.predef.ListNode
import org.scalatest.funsuite.AnyFunSuite

class MergeSortedListsTest extends AnyFunSuite {

	test("empty lists") {
		assert(MergeSortedLists.mergeTwoLists(null, null) == null)
	}

	test("one list") {
		val l = new ListNode(1, new ListNode(5, null))
		assert(MergeSortedLists.mergeTwoLists(l, null) == l)
		assert(MergeSortedLists.mergeTwoLists(null, l) == l)
	}

	test("two lists no crossover") {
		assert(listPrinter(MergeSortedLists.mergeTwoLists(listBuilder(1, 2, 3, 4), listBuilder(5, 6, 7, 8))) == listPrinter(
			listBuilder(1, 2, 3, 4, 5, 6, 7, 8)))
		assert(listPrinter(MergeSortedLists.mergeTwoLists(listBuilder(5, 6, 7, 8), listBuilder(1, 2, 3, 4))) == listPrinter(
			listBuilder(1, 2, 3, 4, 5, 6, 7, 8)))
	}

	test("example1") {
		val res = MergeSortedLists.mergeTwoLists(listBuilder(1, 2, 4), listBuilder(1, 3, 4))
		assert(listPrinter(res) == listPrinter(listBuilder(1, 1, 2, 3, 4, 4)))
	}

	/**
	 * Simple function to convert a list to a string
	 *
	 * @param listNode list to convert
	 * @return a string representing the contents of the list
	 */
	def listPrinter(listNode: ListNode): String =
		s"${listNode.x}," + {
			if (listNode.next != null) {
				listPrinter(listNode.next)
			} else ""
		}


}
