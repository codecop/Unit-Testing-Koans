import unittest

from wordcount.wordcounter import WordCounter


# Session 4: WordCounterFailureTestCase - Exceptions and ignoring tests.
# See "https://docs.python.org/2/library/unittest.html#test-cases" and
# "https://docs.python.org/2/library/unittest.html#skipping-tests-and-expected-failures"
class Session4_WordCounterFailureTestCase(unittest.TestCase):

    # TODO Add the needed code to test for an expected exception.

    def testThrowIOErrorOnMissingFile(self):
        def wordCountOfMissingFile():
            WordCounter.load("IamSureThisDoesNotExist.txt")

        self.assertRaises(IOError, wordCountOfMissingFile)
        self.assertRaises(IOError, WordCounter.load, "ThisDoesNotExist.txt")  # drop

    def testThrowValueErrorWithMessage(self):
        def ratioOfMissingWord():
            counter = WordCounter("green bar green")
            return counter.ratioOf("missingWord")

        self.assertRaisesRegexp(ValueError, "missingWord not in sentence", ratioOfMissingWord)

    # TODO The next test does not work, we need to change the code,
    # but we will do that tomorrow. For today let's skip it.

    @unittest.skip("work in progress, will continue tomorrow")
    def testCountUniqueWordsCaseInsensitive(self):
        counter = WordCounter("green bar Green hat")
        self.assertEqual(["bar", "green", "hat"], counter.uniqueWords())  # keep
