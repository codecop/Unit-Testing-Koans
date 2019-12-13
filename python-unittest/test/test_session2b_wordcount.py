import unittest

from wordcount.wordcounter import WordCounter


class Session2bWordCounterTestCase(unittest.TestCase):
    """
    Session 2b: WordCounterTestCase - More assertions.
    See "https://docs.python.org/2/library/unittest.html#test-cases"
    """

    # TODO Add the proper assertions to complete the tests.

    def test_count_number_of_words(self):
        counter = WordCounter("Keep the bar green to keep the code clean.")
        # TODO Check that 9, counter.number_of_words() is equal.

    def test_contain_unique_word(self):
        counter = WordCounter("green bar green hat")
        # TODO Check that "bar", counter.unique_words() is included.

    def test_not_contain_unique_word(self):
        counter = WordCounter("green bar green hat")
        # TODO Check that "foo", counter.unique_words() is not included.

    def test_ratio_of_word(self):
        counter = WordCounter("green bar green")
        # TODO Check that 0.33, counter.ratio_of("bar") is equal.
        # Note that floating point numbers need an accuracy delta, e.g. 0.01.

    def test_first_unique_word_starts_with_b(self):
        counter = WordCounter("green bar green")
        # TODO Check that counter.first_unique_word(), "^b" is matched by regular expression.
