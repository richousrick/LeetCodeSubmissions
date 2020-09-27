package medium

import scala.collection.mutable

object LengthOfLongestSubstring {

  def lengthOfLongestSubstring(s: String): Int = {
    // current longest substring found
    var longest = 0
    // current section of the string being looked at
    val window = mutable.Queue[Char]()
    // set of characters in the window
    var windowSet = mutable.Set[Char]()

    for (c <- s) {
      if (windowSet.contains(c)) {
        // update longest
        longest = math.max(longest, window.size)

        // update window
        // don't need to remove c from set just from window so dequeue after
        var last = window.dequeue()
        while (last != c) {
          windowSet -= last
          last = window.dequeue()
        }
      } else {
        windowSet += c
      }
      window.enqueue(c)
    }
    math.max(longest, window.size)
  }

  def main(args: Array[String]): Unit = {
    test("abcabcbb", 3)
    test("abcabcbbcfacb", 4)
    test("abcabcbbcfacbd", 5)

    test("pwwkew", 3)

    test("bbbbbb", 1)

    test("", 0)

    println("Tests completed successfully")
  }

  /**
   * Asserts [[medium.LengthOfLongestSubstring#lengthOfLongestSubstring lengthOfLongestSubstring]] will return the expected value when given a specified input
   *
   * @param input          to pass to lengthOfLongestSubstring
   * @param expectedResult of lengthOfLongestSubstring when given the specified input
   * @throws AssertionError if lengthOfLongestSubstring does not return the expected result
   */
  def test(input: String, expectedResult: Int): Unit = {
    val actualResult = lengthOfLongestSubstring(input)
    if (actualResult != expectedResult) {
      throw new AssertionError(s"""Expected $expectedResult got $actualResult for input "$input"""")
    }
  }
}
