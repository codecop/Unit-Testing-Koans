import unittest

from hamcrest import *
from wordcount.wordcounter import WordCounter


# Bonus Session 2c: WordCounterTestCase - Assertions with Hamcrest.
# See external library "https://github.com/hamcrest/PyHamcrest"
# Install with `pip install PyHamcrest`.
class Session2c_WordCounterTestCase(unittest.TestCase):

    # TODO Add the proper assertions to complete the tests using Hamcrest.

    def testCountNumberOfWords(self):
        counter = WordCounter("Keep the bar green to keep the code clean.")
        self.assertEqual(9, counter.number_of_words())  # keep
        # Hamcrest improves readability:
        assert_that(9, equal_to(counter.number_of_words()))

    def testContainUniqueWord(self):
        counter = WordCounter("green bar green hat")
        self.assertIn("bar", counter.unique_words())  # keep
        # Hamcrest improves readability:
        assert_that(counter.unique_words(), has_item("bar"))

    def testNotContainInUniqueWords(self):
        counter = WordCounter("green bar green hat")
        self.assertNotIn("foo", counter.unique_words())  # keep
        # Hamcrest improves readability:
        assert_that(counter.unique_words(), is_not(has_item("foo")))

    def testFindNumberOfUniqueWords(self):
        counter = WordCounter("green bar green hat")
        self.assertEqual(3, len(counter.unique_words()))  # keep
        # Hamcrest improves readability:
        assert_that(counter.unique_words(), has_length(3))
