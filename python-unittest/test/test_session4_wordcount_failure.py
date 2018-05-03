import unittest

from wordcount.wordcounter import WordCounter


# Session 4: WordCounterFailureTestCase - Exceptions and ignoring tests.
# See "https://docs.python.org/2/library/unittest.html#test-cases" and
# "https://docs.python.org/2/library/unittest.html#skipping-tests-and-expected-failures"
class Session4_WordCounterFailureTestCase(unittest.TestCase):

    # TODO Add the needed code to test for an expected exception.

    def testThrowIOErrorOnMissingFile(self):
        def wordCountOfMissingFile():
            WordCounter.load("DoesNotExist.txt")

        self.assertRaises(IOError, wordCountOfMissingFile)
        self.assertRaises(IOError, WordCounter.load, "DoesNotExist.txt")  # drop

    def testThrowIOErrorWithFileNameOnMissingFile(self):
        self.assertRaisesRegexp(IOError, "DoesNotExist", WordCounter.load, "DoesNotExist.txt")

    def testThrowValueErrorWithMessageOnUnknownWord(self):
        def ratioOfMissingWord():
            counter = WordCounter("green bar green")
            return counter.ratio_of("missingWord")

        self.assertRaisesRegexp(ValueError, "missingWord not in sentence", ratioOfMissingWord)

    # TODO The next test does not work, we need to change the code,
    # but we will do that tomorrow. For today let's skip it.

    @unittest.skip("work in progress, will continue tomorrow")
    def testCountUniqueWordsCaseInsensitive(self):
        counter = WordCounter("green bar Green hat")
        self.assertEqual(["bar", "green", "hat"], counter.unique_words())  # keep
