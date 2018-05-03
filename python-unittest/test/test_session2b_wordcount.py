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
        self.assertEqual(9, counter.number_of_words())

    def test_contain_unique_word(self):
        counter = WordCounter("green bar green hat")
        self.assertIn("bar", counter.unique_words())

    def test_not_contain_unique_word(self):
        counter = WordCounter("green bar green hat")
        self.assertNotIn("foo", counter.unique_words())

    def test_ratio_of_word(self):
        counter = WordCounter("green bar green")
        self.assertAlmostEqual(0.33, counter.ratio_of("bar"), delta=0.01)
        # Note that floating point numbers need an accuracy delta, e.g. 0.01.
        # also assertNotAlmostEqual(a, b) # drop

    def test_first_unique_word_starts_with_b(self):
        counter = WordCounter("green bar green")
        self.assertRegexpMatches(counter.first_unique_word(), "^b")
        # also assertNotRegexpMatches(s, r) # drop
