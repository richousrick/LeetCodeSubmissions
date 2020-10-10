package leetcode.easy

import leetcode.easy.TwoSum.twoSum
import org.scalatest.funsuite.AnyFunSuite

class TwoSumTest extends AnyFunSuite {

  test("Random examples") {
    assert(twoSum(Array(2, 7, 11, 15), 9).toSet == Set(0, 1))

    assert(twoSum(Array(3, 2, 4), 6).toSet == Set(1, 2))

    assert(twoSum(Array(3, 3), 6).toSet == Set(0, 1))
  }
}
