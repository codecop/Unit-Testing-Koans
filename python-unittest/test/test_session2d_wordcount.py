import unittest

from assertpy import assert_that
from wordcount.wordcounter import WordCounter


# Bonus Session 2d: WordCounterTestCase - Assertions with assertpy.
# See external library "https://github.com/ActivisionGameScience/assertpy"
# Install with `pip install assertpy`.
class Session2d_WordCounterTestCase(unittest.TestCase):

    # TODO Add the proper assertions to complete the tests using assertpy.

    def testCountNumberOfWords(self):
        counter = WordCounter("Keep the bar green to keep the code clean.")
        self.assertEqual(9, counter.number_of_words())  # keep
        # assertpy is fluent:
        assert_that(counter.number_of_words()).is_equal_to(9)

    def testContainUniqueWord(self):
        counter = WordCounter("green bar green hat")
        self.assertIn("bar", counter.unique_words())  # keep
        # assertpy is fluent:
        assert_that(counter.unique_words()).contains("bar")

    def testNotContainInUniqueWords(self):
        counter = WordCounter("green bar green hat")
        self.assertNotIn("foo", counter.unique_words())  # keep
        # assertpy is fluent:
        assert_that(counter.unique_words()).does_not_contain("foo")

    def testFindNumberOfUniqueWords(self):
        counter = WordCounter("green bar green hat")
        self.assertEqual(3, len(counter.unique_words()))  # keep
        # assertpy is fluent:
        assert_that(counter.unique_words()).is_length(3)
