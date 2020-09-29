package leetcode.medium

import leetcode.Utils._

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
    test(lengthOfLongestSubstring, "abcabcbb", 3)
    test(lengthOfLongestSubstring, "abcabcbbcfacb", 4)
    test(lengthOfLongestSubstring, "abcabcbbcfacbd", 5)

    test(lengthOfLongestSubstring, "pwwkew", 3)

    test(lengthOfLongestSubstring, "bbbbbb", 1)

    test(lengthOfLongestSubstring, "", 0)

    println("Tests completed successfully")
  }

}
