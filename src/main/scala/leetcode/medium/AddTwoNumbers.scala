package leetcode.medium

import leetcode.Utils._

import scala.annotation.tailrec
import scala.util.Random

object AddTwoNumbers {

  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
  }

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

  def main(args: Array[String]): Unit = {
    // test simple cases
    testAdd(42, 16)

    // test adding 0's
    testAdd(0, 100)
    testAdd(100, 0)
    testAdd(0, 0)

    //test rounding
    testAdd(136, 271)
    testAdd(889, 12)
    testAdd(99, 99)

    // Test many cases
    Random.setSeed(42)
    for (_ <- 0 to 1000000) {
      testAdd(Random.nextInt(10000), Random.nextInt(10000))
    }

    println("Success")
  }

  /**
   * Test [[leetcode.medium.AddTwoNumbers#addTwoNumbers]] works as expected on a given pair of integers
   *
   * @param a first integer to add
   * @param b second integer to add
   * @return true if the function successfully added the two integers
   * @throws AssertionError if [[leetcode.medium.AddTwoNumbers#addTwoNumbers addTwoNumbers]] or
   *                        [[leetcode.medium.AddTwoNumbers#convertIntToList convertIntToList]] / [[leetcode.medium.AddTwoNumbers#convertListToInt convertListToInt]]
   *                        are not working as expected
   */
  def testAdd(a: Int, b: Int): Boolean = {
    val linkedA = convertIntToList(a)
    val linkedB = convertIntToList(b)

    val linkedRes = addTwoNumbers(linkedA, linkedB)
    val res = convertListToInt(linkedRes)

    test(convertListToInt, linkedRes, a + b)

    // test conversion functions
    test(convertListToInt, linkedA, a)
    test(convertListToInt, linkedB, b)

    true
  }

  /**
   * Builds a ListNode from a given integer
   *
   * @param targetInteger integer to convert to a ListNode
   * @return a ListNode representing the targetInteger
   */
  def convertIntToList(targetInteger: Int): ListNode = {
    var inStr = targetInteger.toString
    var head: ListNode = null

    while (inStr.nonEmpty) {
      head = new ListNode(Character.getNumericValue(inStr.head), head)
      inStr = inStr.tail
    }
    head
  }

  /**
   * Converts a linked list back into the integer it is representing
   *
   * @param targetInput list to convert into an integer
   * @return the integer represented by the input list
   */
  def convertListToInt(targetInput: ListNode): Int = {
    /**
     * Converts a linked list back into the integer it is representing
     *
     * @param targetInput list to convert into an integer
     * @param result      current recursive result
     * @param sig         significance of current digit. i.e. 2 indicates the head of the list is in hundreds (10^2^)
     * @return the integer represented by the input list
     */
    @tailrec
    def convertListToIntI(targetInput: ListNode, result: Int = 0, sig: Int = 0): Int = {
      val current = result + (targetInput.x * Math.pow(10, sig)).toInt
      targetInput.next match {
        case null => current
        case a => convertListToIntI(a, current, sig + 1)
      }
    }

    convertListToIntI(targetInput)
  }
}
