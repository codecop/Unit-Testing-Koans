import unittest

from wordcount.wordcounter import WordCounter


# Session 2b: WordCounterTestCase - More assertions.
# See "https://docs.python.org/2/library/unittest.html#test-cases"
class Session2b_WordCounterTestCase(unittest.TestCase):

    # TODO Add the proper assertions to complete the tests.

    def testCountNumberOfWords(self):
        counter = WordCounter("Keep the bar green to keep the code clean.")
        self.assertEqual(9, counter.numberOfWords())

    def testContainUniqueWord(self):
        counter = WordCounter("green bar green hat")
        self.assertIn("bar", counter.uniqueWords())

    def testNotContainInUniqueWords(self):
        counter = WordCounter("green bar green hat")
        self.assertNotIn("foo", counter.uniqueWords())

    def testRatioOfWord(self):
        counter = WordCounter("green bar green")
        self.assertAlmostEqual(0.33, counter.ratioOf("bar"), delta=0.01)
        # Note that floating point numbers need an accuracy delta, e.g. 0.01.
        # also assertNotAlmostEqual(a, b) # drop

    def testFirstUniqueWordStartsWithB(self):
        counter = WordCounter("green bar green")
        self.assertRegexpMatches(counter.firstUniqueWord(), "b")
        # also assertNotRegexpMatches(s, r) # drop
