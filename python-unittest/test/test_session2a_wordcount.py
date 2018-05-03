import unittest

from wordcount.wordcounter import WordCounter


class Session2aWordCounterTestCase(unittest.TestCase):
    """
    Session 2: WordCounterTestCase - Basic assertions.
    See "https://docs.python.org/2/library/unittest.html#test-cases"
    """

    # TODO Add the proper assertions to complete the tests.
    # The test name explains what needs to be asserted.

    def test_count_number_of_words(self):
        counter = WordCounter("Keep the bar green to keep the code clean.")
        # TODO Check that 9, counter.number_of_words() is equal.

    def test_not_count_capitalized_word(self):
        counter = WordCounter("green bar green hat")
        # TODO Check that 1, counter.count_of("HAT") is not equal.

    def test_containment_of_word(self):
        counter = WordCounter("green bar green hat")
        # TODO Check that counter.contains_word("bar").

    def test_non_containment_of_word(self):
        counter = WordCounter("green hat")
        # TODO Check that counter.contains_word("red") is false.

    def test_return_none_for_unknown_word_count(self):
        counter = WordCounter("green bar green hat")
        # TODO Check that counter.count_of("else") is None.

    def test_return_not_none_for_existing_word_count(self):
        counter = WordCounter("green bar green hat")
        # TODO Check that counter.count_of("green") is not None.

    def test_count_green_twice(self):
        counter = WordCounter("green bar green hat")
        # TODO Check that 2, counter.count_of("green") is equal.

    def test_find_unique_words(self):
        counter = WordCounter("green bar green hat")
        # TODO Check that ["bar", "green", "hat"], counter.unique_words() is equal.
