import unittest
from parameterized import parameterized

from wordcount.wordcounter import WordCounter


# Session 5b: WordCounterRatioTestCase - parameterised/table driven.
# See external library "https://github.com/wolever/parameterized"
# Install with "pip install parameterized".
class Session5b_WordCounterRatioTestCase(unittest.TestCase):

    # TODO Add the needed decorators to run this test with all examples.

    # We want to test more cases for the ratio. Here is a table of test cases.
    TestCases = [
        ("green", "green", 1.0),  #
        ("green bar green", "green", 0.66),  #
        ("green bar green bar", "green", 0.5),  #
        ("green bar green", "bar", 0.33),  #
    ]

    @parameterized.expand(TestCases)  # mark this test as parameterised
    def testRatioOfGivenWordParameterized(self, sentence, word, expectedRatio):
        counter = WordCounter(sentence)
        self.assertAlmostEqual(expectedRatio, counter.ratioOf(word), delta=0.01)  # keep
