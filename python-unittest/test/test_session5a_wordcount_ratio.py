import unittest
import sys

from wordcount.wordcounter import WordCounter


@unittest.skipIf(sys.version_info[0] < 3, "needs Python 3")  # keep
class Session5aWordCounterRatioTestCase(unittest.TestCase):
    """
    Session 5a: WordCounterRatioTestCase - parameterised/table driven.
    See "https://docs.python.org/3/library/unittest.html#distinguishing-test-iterations-using-subtests"
    """

    # We want to test more cases for the ratio. Here is a table of test cases.
    def table_data(self):
        return [
            ("green", "green", 1.0),  #
            ("green bar green", "green", 0.66),  #
            ("green bar green bar", "green", 0.5),  #
            ("green bar green", "bar", 0.33),  #
        ]

    def test_all_ratios_of_given_words(self):
        # TODO Add the needed code to run this test with all examples.
        for test_case in self.table_data():
            sentence, word, expected_ratio = test_case
            with self.subTest("testRatioOfGivenWord_" + sentence + "_" + word):
                self.ratio_of_given_word(sentence, word, expected_ratio)

    def ratio_of_given_word(self, sentence, word, expected_ratio):
        counter = WordCounter(sentence)
        self.assertAlmostEqual(expected_ratio, counter.ratio_of(word), delta=0.01)  # keep
