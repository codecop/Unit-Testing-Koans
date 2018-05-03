import unittest

from wordcount.wordcounter import WordCounter


class Session4WordCounterFailureTestCase(unittest.TestCase):
    """
    Session 4: WordCounterFailureTestCase - Exceptions and ignoring tests.
    See "https://docs.python.org/2/library/unittest.html#test-cases" and
    "https://docs.python.org/2/library/unittest.html#skipping-tests-and-expected-failures"
    """

    # TODO Add the needed code to test for an expected exception.

    def test_throw_ioerror_on_missing_file(self):
        def word_count_of_missing_file():
            WordCounter.load("DoesNotExist.txt")

        self.assertRaises(IOError, word_count_of_missing_file)
        self.assertRaises(IOError, WordCounter.load, "DoesNotExist.txt")  # drop
        # use pass

    def test_throw_ioerror_with_file_name_on_missing_file(self):
        self.assertRaisesRegexp(IOError, "DoesNotExist", WordCounter.load, "DoesNotExist.txt")
        # use pass

    def test_throw_value_error_with_message_on_unknown_word(self):
        def ratio_of_missing_word():
            counter = WordCounter("green bar green")
            return counter.ratio_of("missingWord")

        self.assertRaisesRegexp(ValueError, "missingWord not in sentence", ratio_of_missing_word)
        # use pass

    # TODO The next test does not work, we need to change the code,
    # but we will do that tomorrow. For today let's skip it.

    @unittest.skip("work in progress, will continue tomorrow")
    def test_count_unique_words_case_insensitive(self):
        counter = WordCounter("green bar Green hat")
        self.assertEqual(["bar", "green", "hat"], counter.unique_words())  # keep
