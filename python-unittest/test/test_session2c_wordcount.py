import unittest

from hamcrest import *
from wordcount.wordcounter import WordCounter


class Session2cWordCounterTestCase(unittest.TestCase):
    """
    Bonus Session 2c: WordCounterTestCase - Assertions with Hamcrest.
    See external library "https://github.com/hamcrest/PyHamcrest"
    Install with `pip install PyHamcrest`.
    """

    # TODO Add the proper assertions to complete the tests using Hamcrest.

    def test_count_number_of_words(self):
        counter = WordCounter("Keep the bar green to keep the code clean.")
        self.assertEqual(9, counter.number_of_words())  # keep
        # Hamcrest improves readability:
        assert_that(9, equal_to(counter.number_of_words()))

    def test_contain_unique_word(self):
        counter = WordCounter("green bar green hat")
        self.assertIn("bar", counter.unique_words())  # keep
        # Hamcrest improves readability:
        assert_that(counter.unique_words(), has_item("bar"))

    def test_not_contain_unique_word(self):
        counter = WordCounter("green bar green hat")
        self.assertNotIn("foo", counter.unique_words())  # keep
        # Hamcrest improves readability:
        assert_that(counter.unique_words(), is_not(has_item("foo")))

    def test_find_number_of_unique_words(self):
        counter = WordCounter("green bar green hat")
        self.assertEqual(3, len(counter.unique_words()))  # keep
        # Hamcrest improves readability:
        assert_that(counter.unique_words(), has_length(3))
