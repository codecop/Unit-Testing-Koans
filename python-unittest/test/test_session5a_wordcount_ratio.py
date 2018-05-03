import unittest
import sys

from wordcount.wordcounter import WordCounter


@unittest.skipIf(sys.version_info[0] < 3, "needs Python 3")  # keep
class Session5aWordCounterRatioTestCase(unittest.TestCase):
    """
    Session 5a: WordCounterRatioTestCase - parameterised/table driven.
    See "https://docs.python.org/3/library/unittest.html#distinguishing-test-iterations-using-subtests"
    """

    # We want to test more cases for the ratio.
    def table_data(self):
        """Here is a table of test cases."""
        return [
            ("green", "green", 1.0),  #
            ("green bar green", "green", 0.66),  #
            ("green bar green bar", "green", 0.5),  #
            ("green bar green", "bar", 0.33),  #
        ]

    def test_all_ratios_of_given_words(self):
        for test_case in self.table_data():
            sentence, word, expected_ratio = test_case
            # TODO Add code to run this test with all examples as sub tests.
            with self.subTest("testRatioOfGivenWord_" + sentence + "_" + word):  # drop
                self.ratio_of_given_word(sentence, word, expected_ratio)   # drop

    def ratio_of_given_word(self, sentence, word, expected_ratio):
        """Helper function for each set of parameters."""
        counter = WordCounter(sentence)
        self.assertAlmostEqual(expected_ratio, counter.ratio_of(word), delta=0.01)  # keep
