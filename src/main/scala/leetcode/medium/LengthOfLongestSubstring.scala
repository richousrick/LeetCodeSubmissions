package leetcode.medium

import leetcode.Utils._

import scala.collection.mutable

object LengthOfLongestSubstring {

  /**
   * Finds the length of the longest substring without any repeating characters
   * Beats Approx: 88.13% runtime, 55.00% memory
   *
   * @param s target string to search though
   * @return the length of the longest substring that contains no duplicate characters
   */
  def lengthOfLongestSubstring(s: String): Int = {
    // current longest substring found
    var longest = 0
    // current section of the string being looked at
    var windowStart = 0
    var windowEnd = 0
    // set of characters in the window
    val windowSet = mutable.Set[Char]()

    for (c <- s) {
      if (windowSet.contains(c)) {
        // update longest
        longest = math.max(longest, windowEnd - windowStart)

        // update window
        // don't need to remove c from set just from window so dequeue after
        var last = s(windowStart)
        windowStart += 1
        while (last != c) {
          windowSet -= last
          last = s(windowStart)
          windowStart += 1
        }
      } else {
        windowSet += c
      }
      windowEnd += 1
    }
    math.max(longest, windowEnd - windowStart)
  }


  def main(args: Array[String]): Unit = {
    test(lengthOfLongestSubstring, "abcabcbb", 3)
    test(lengthOfLongestSubstring, "abcabcbbcfacb", 4)
    test(lengthOfLongestSubstring, "abcabcbbcfacbd", 5)

    test(lengthOfLongestSubstring, "pwwkew", 3)

    test(lengthOfLongestSubstring, "bbbbbb", 1)

    test(lengthOfLongestSubstring, "", 0)

    println("Tests completed successfully")
  }

}
