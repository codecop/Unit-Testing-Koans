import unittest

from wordcount.wordcounter import WordCounter


# Session 2a: WordCounterTestCase - Basic assertions.
# See "https://docs.python.org/2/library/unittest.html#test-cases"
class Session2a_WordCounterTestCase(unittest.TestCase):

    # TODO Add the proper assertions to complete the tests.
    # The test name explains what needs to be asserted.

    def testCountNumberOfWords(self):
        counter = WordCounter("Keep the bar green to keep the code clean.")
        self.assertEqual(9, counter.numberOfWords())

    def testNotCountCapitalizedWord(self):
        counter = WordCounter("green bar green hat")
        self.assertNotEqual(1, counter.countOf("HAT"))

    def testContainmentOfWord(self):
        counter = WordCounter("green bar green hat")
        self.assertTrue(counter.containsWord("bar"))

    def testNonContainmentOfWord(self):
        counter = WordCounter("green hat")
        self.assertFalse(counter.containsWord("red"))

    def testReturnNoneForUnknownWordCount(self):
        counter = WordCounter("green bar green hat")
        self.assertIsNone(counter.countOf("else"))

    def testReturnNotNoneWordCountForExistingWord(self):
        counter = WordCounter("green bar green hat")
        self.assertIsNotNone(counter.countOf("green"))

    def testFindUniqueWords(self):
        counter = WordCounter("green bar green hat")
        self.assertEqual(["bar", "green", "hat"], counter.uniqueWords())

    def testRatioOfWords(self):
        counter = WordCounter("green bar green")
        self.assertAlmostEqual(0.33, counter.ratioOf("bar"), delta=0.01)
        # Note that floating point numbers need an accuracy delta, e.g. 0.01.
