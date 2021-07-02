package leetcode.medium

import org.scalatest.funsuite.AnyFunSuite

class PhoneNumCombinationsTest extends AnyFunSuite {

	test("empty") {
		assert(PhoneNumCombinations.letterCombinations("") == List())
	}

	test("single") {
		assert(PhoneNumCombinations.letterCombinations("2") == PhoneNumCombinations
			.letterMappings(0)
			.map(_.toString)
			.toList)
	}

	test("multiple") {
		assert(PhoneNumCombinations.letterCombinations("23").toSet == Set("ad",
			"ae",
			"af",
			"bd",
			"be",
			"bf",
			"cd",
			"ce",
			"cf"))
	}

	test("3") {
		assert(PhoneNumCombinations.letterCombinations("234").toSet == Set(
			"adg", "adh", "adi", "aeg", "aeh", "aei", "afg", "afh", "afi",
			"bdg", "bdh", "bdi", "beg", "beh", "bei", "bfg", "bfh", "bfi",
			"cdg", "cdh", "cdi", "ceg", "ceh", "cei", "cfg", "cfh", "cfi"
		))
	}

	test("failed") {
		assert(PhoneNumCombinations.letterCombinations("5678").toSet ==
			Set("jmpt",
				"jmpu",
				"jmpv",
				"jmqt",
				"jmqu",
				"jmqv",
				"jmrt",
				"jmru",
				"jmrv",
				"jmst",
				"jmsu",
				"jmsv",
				"jnpt",
				"jnpu",
				"jnpv",
				"jnqt",
				"jnqu",
				"jnqv",
				"jnrt",
				"jnru",
				"jnrv",
				"jnst",
				"jnsu",
				"jnsv",
				"jopt",
				"jopu",
				"jopv",
				"joqt",
				"joqu",
				"joqv",
				"jort",
				"joru",
				"jorv",
				"jost",
				"josu",
				"josv",
				"kmpt",
				"kmpu",
				"kmpv",
				"kmqt",
				"kmqu",
				"kmqv",
				"kmrt",
				"kmru",
				"kmrv",
				"kmst",
				"kmsu",
				"kmsv",
				"knpt",
				"knpu",
				"knpv",
				"knqt",
				"knqu",
				"knqv",
				"knrt",
				"knru",
				"knrv",
				"knst",
				"knsu",
				"knsv",
				"kopt",
				"kopu",
				"kopv",
				"koqt",
				"koqu",
				"koqv",
				"kort",
				"koru",
				"korv",
				"kost",
				"kosu",
				"kosv",
				"lmpt",
				"lmpu",
				"lmpv",
				"lmqt",
				"lmqu",
				"lmqv",
				"lmrt",
				"lmru",
				"lmrv",
				"lmst",
				"lmsu",
				"lmsv",
				"lnpt",
				"lnpu",
				"lnpv",
				"lnqt",
				"lnqu",
				"lnqv",
				"lnrt",
				"lnru",
				"lnrv",
				"lnst",
				"lnsu",
				"lnsv",
				"lopt",
				"lopu",
				"lopv",
				"loqt",
				"loqu",
				"loqv",
				"lort",
				"loru",
				"lorv",
				"lost",
				"losu",
				"losv"))
	}
}
