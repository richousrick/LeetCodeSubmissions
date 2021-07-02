package leetcode.medium

import leetcode.predef.ListNode

import scala.annotation.tailrec

object AddTwoNumbers {

  /**
   * Adds two integers with both the input and output being represented by a linked list.
   * Each list contains integers indexed by their significance, with the head pointing to the least significant integer.
   * e.g. 1234 would be represented as 4 -> 3 -> 2 -> 1.
   * Beats Approx: 95.98% runtime, 37.08% memory
   *
   * @param l1 first integer to add
   * @param l2 second integer to add
   * @return the result of l1 + l2 represented as a linked list
   */
  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    @tailrec
    def addNumbers(l1: ListNode, l2: ListNode, remainder: Int, callStack: ListNode => ListNode): ListNode = {
      val sum = l1.x + l2.x + remainder
      val iterativeSum: ListNode => ListNode = (tail: ListNode) => callStack(new ListNode(sum % 10, tail))
      (l1.next, l2.next, math.floor(sum / 10).toInt) match {
        case (null, null, 0) =>
          iterativeSum(null)
        case (null, null, nextRemainder) =>
          iterativeSum(new ListNode(nextRemainder))
        case (_, _, nextRemainder) =>
          addNumbers(Option(l1.next).getOrElse(new ListNode(0)), Option(l2.next).getOrElse(new ListNode(0)), nextRemainder, iterativeSum)
      }
    }

    addNumbers(Option(l1).getOrElse(new ListNode(0, null)), Option(l2).getOrElse(new ListNode(0, null)), 0, identity)
  }
}
