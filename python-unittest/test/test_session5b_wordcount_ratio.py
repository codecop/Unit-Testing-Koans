import unittest
from parameterized import parameterized

from wordcount.wordcounter import WordCounter


class Session5bWordCounterRatioTestCase(unittest.TestCase):
    """
    Session 5b: WordCounterRatioTestCase - parameterised/table driven.
    See external library "https://github.com/wolever/parameterized"
    Install with `pip install parameterized`.
    """

    # TODO Add the needed decorators to run this test with all examples.

    # We want to test more cases for the ratio. Here is a table of test cases.
    TableData = [
        ("green", "green", 1.0),  #
        ("green bar green", "green", 0.66),  #
        ("green bar green bar", "green", 0.5),  #
        ("green bar green", "bar", 0.33),  #
    ]

    # TODO Mark this test as parameterized with TableData.
    def test_ratio_parameterized(self, sentence, word, expected_ratio):
        counter = WordCounter(sentence)
        self.assertAlmostEqual(expected_ratio, counter.ratio_of(word), delta=0.01)
