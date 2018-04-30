import unittest
import sys

from wordcount.wordcounter import WordCounter


# Session 5: WordCounterRatioTestCase - parameterised/table driven. See
# "https://docs.python.org/3/library/unittest.html#distinguishing-test-iterations-using-subtests"
@unittest.skipIf(sys.version_info[0] < 3, "not supported in Python 2")  # keep
class Session5_WordCounterRatioTestCase(unittest.TestCase):

    # We want to test more cases for the ratio. Here is a table of test cases.
    def tableOfTestCases(self):
        return [
            ("green", "green", 1.0),  #
            ("green bar green", "green", 0.66),  #
            ("green bar green bar", "green", 0.5),  #
            ("green bar green", "bar", 0.33),  #
        ]

    def testRatioOfGivenWordAllCases(self):
        # TODO Add the needed code to run this test with all examples.
        for tc in self.tableOfTestCases():
            sentence, word, expectedRatio = tc
            with self.subTest("testRatioOfGivenWord_" + sentence + "_" + word):
                counter = WordCounter(sentence)
                self.assertAlmostEqual(expectedRatio, counter.ratioOf(word), delta=0.01)  # keep
