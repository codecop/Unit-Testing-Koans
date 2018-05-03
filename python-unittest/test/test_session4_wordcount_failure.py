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

        # TODO Expect IOError is thrown from word_count_of_missing_file.
        pass

    def test_throw_ioerror_with_file_name_on_missing_file(self):
        # TODO Expect IOError with message "DoesNotExist" is thrown from WordCounter.load, "DoesNotExist.txt".
        pass

    def test_throw_value_error_with_message_on_unknown_word(self):
        def ratio_of_missing_word():
            counter = WordCounter("green bar green")
            return counter.ratio_of("missingWord")

        # TODO Expect ValueError with message "missingWord not in sentence" is thrown from ratio_of_missing_word.
        pass

    # TODO The next test does not work, we need to change the code,
    # but we will do that tomorrow. For today let's skip it.

    # TODO Mark this test as ignored with "work in progress, will continue tomorrow".
    def test_count_unique_words_case_insensitive(self):
        counter = WordCounter("green bar Green hat")
        self.assertEqual(["bar", "green", "hat"], counter.unique_words())
