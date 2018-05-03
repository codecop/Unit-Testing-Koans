import unittest

from wordcount.wordcounter import WordCounter


# Session 2: WordCounterTestCase - Basic assertions.
# See "https://docs.python.org/2/library/unittest.html#test-cases"
class Session2a_WordCounterTestCase(unittest.TestCase):

    # TODO Add the proper assertions to complete the tests.
    # The test name explains what needs to be asserted.

    def testCountNumberOfWords(self):
        counter = WordCounter("Keep the bar green to keep the code clean.")
        self.assertEqual(9, counter.number_of_words())

    def testNotCountCapitalizedWord(self):
        counter = WordCounter("green bar green hat")
        self.assertNotEqual(1, counter.count_of("HAT"))

    def testContainmentOfWord(self):
        counter = WordCounter("green bar green hat")
        self.assertTrue(counter.contains_word("bar"))

    def testNonContainmentOfWord(self):
        counter = WordCounter("green hat")
        self.assertFalse(counter.contains_word("red"))

    def testReturnNoneForUnknownWordCount(self):
        counter = WordCounter("green bar green hat")
        self.assertIsNone(counter.count_of("else"))

    def testReturnNotNoneWordCountForExistingWord(self):
        counter = WordCounter("green bar green hat")
        self.assertIsNotNone(counter.count_of("green"))

    def testCountGreenTwice(self):
        counter = WordCounter("green bar green hat")
        self.assertEqual(2, counter.count_of("green"))

    def testFindUniqueWords(self):
        counter = WordCounter("green bar green hat")
        self.assertEqual(["bar", "green", "hat"], counter.unique_words())
