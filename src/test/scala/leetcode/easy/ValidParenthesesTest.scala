package leetcode.easy

import org.scalatest.funsuite.AnyFunSuite

class ValidParenthesesTest extends AnyFunSuite {

	test("one nonempty") {
		assert(!ValidParentheses.isValid("("))
		assert(!ValidParentheses.isValid("["))
		assert(!ValidParentheses.isValid("{"))
		assert(!ValidParentheses.isValid(")"))
		assert(!ValidParentheses.isValid("]"))
		assert(!ValidParentheses.isValid("}"))
	}

	test("matching pair") {
		assert(ValidParentheses.isValid("{}"))
		assert(ValidParentheses.isValid("[]"))
		assert(ValidParentheses.isValid("()"))
	}

	test("inverse pair pair") {
		assert(!ValidParentheses.isValid("}{"))
		assert(!ValidParentheses.isValid("]["))
		assert(!ValidParentheses.isValid(")("))
	}

	test("deep same") {
		assert(ValidParentheses.isValid("{{}}"))
	}

	test("deep same missing") {
		assert(!ValidParentheses.isValid("{{}{}"))
		assert(!ValidParentheses.isValid("[[[]]"))
	}

	test("deep different") {
		assert(ValidParentheses.isValid("{[]}"))
	}

	test("out of order") {
		assert(!ValidParentheses.isValid("{[}]"))
	}
}
