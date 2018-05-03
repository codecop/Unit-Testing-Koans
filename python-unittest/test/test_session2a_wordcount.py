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
        self.assertEqual(9, counter.number_of_words())

    def test_not_count_capitalized_word(self):
        counter = WordCounter("green bar green hat")
        self.assertNotEqual(1, counter.count_of("HAT"))

    def test_containment_of_word(self):
        counter = WordCounter("green bar green hat")
        self.assertTrue(counter.contains_word("bar"))

    def test_non_containment_of_word(self):
        counter = WordCounter("green hat")
        self.assertFalse(counter.contains_word("red"))

    def test_return_none_for_unknown_word_count(self):
        counter = WordCounter("green bar green hat")
        self.assertIsNone(counter.count_of("else"))

    def test_return_not_none_for_existing_word_count(self):
        counter = WordCounter("green bar green hat")
        self.assertIsNotNone(counter.count_of("green"))

    def test_count_green_twice(self):
        counter = WordCounter("green bar green hat")
        self.assertEqual(2, counter.count_of("green"))

    def test_find_unique_words(self):
        counter = WordCounter("green bar green hat")
        self.assertEqual(["bar", "green", "hat"], counter.unique_words())
