package leetcode.easy

import leetcode.easy.PalindromeNumber.isPalindrome
import org.scalatest.funsuite.AnyFunSuite

class PalindromeNumberTest extends AnyFunSuite {

  test("Zero is Palindrome") {
    assert(isPalindrome(0))
  }

  test("Single positive digit is palindrome") {
    for (i <- 1 until 10) {
      assert(isPalindrome(i))
    }
  }

  test("Repeating digit is palindrome") {
    for (digit <- 1 until 10) {
      var repeatDigit = digit
      for (_ <- 1 until 6) {
        repeatDigit = repeatDigit * 10 + digit
        assert(isPalindrome(repeatDigit))
      }
    }
  }

  test("Random palindromes classed correctly") {
    assert(isPalindrome(121))
    assert(isPalindrome(1221))
    assert(isPalindrome(12321))
    assert(isPalindrome(123321))
    assert(isPalindrome(1234321))
    assert(isPalindrome(12344321))
    assert(isPalindrome(123454321))
    assert(isPalindrome(1234554321))

    assert(isPalindrome(101))
    assert(isPalindrome(96969))
  }

  test("Random non-palindromes classed correctly") {
    assert(!isPalindrome(12))
    assert(!isPalindrome(6547))
    assert(!isPalindrome(19576))
    assert(!isPalindrome(123432))
    assert(!isPalindrome(10))
  }

  test("Single negative digit is not palindrome") {
    for (i <- 1 until 10) {
      assert(!isPalindrome(-i))
    }
  }

  test("Negative repeating digit is not palindrome") {
    for (digit <- 1 until 10) {
      var repeatDigit = digit
      for (_ <- 1 until 6) {
        repeatDigit = repeatDigit * 10 + digit
        assert(!isPalindrome(-repeatDigit))
      }
    }
  }

  test("Random negative palindromes classed correctly") {
    assert(!isPalindrome(-121))
    assert(!isPalindrome(-1221))
    assert(!isPalindrome(-12321))
    assert(!isPalindrome(-123321))
    assert(!isPalindrome(-1234321))
    assert(!isPalindrome(-12344321))
    assert(!isPalindrome(-123454321))
    assert(!isPalindrome(-1234554321))

    assert(!isPalindrome(-101))
    assert(!isPalindrome(-96969))
  }
}
