import os.path
import unittest

from wordcount.wordcounter import WordCounter


TEST_FILE = "FileWordCounterTest.tmp"


class Session3WordCounterFileTestCase(unittest.TestCase):
    """
    Session 3: WordCounterFileTestCase - Fixtures, e.g. using a test file.
    See "https://docs.python.org/2/library/unittest.html#test-cases"
    """

    def test_a_count_of_words(self):
        self._write("Keep the bar green to keep the code clean.", TEST_FILE)

        counter = WordCounter.load(TEST_FILE)
        self.assertEqual(9, counter.number_of_words())  # keep

        os.remove(TEST_FILE)

    # The problem is that os.remove is not called in case of test failures.
    # Better use setUp/tearDown hooks for test file handling.

    # TODO Add the needed methods and calls to create and delete test files.

    def setUp(self):  # drop
        self.create_fresh_test_file_for_each_test()  # drop

    # This method should be called before each test.
    def create_fresh_test_file_for_each_test(self):
        self._write("Keep the bar green to keep the code clean.", TEST_FILE)

    def tearDown(self):  # drop
        self.delete_test_file()  # drop

    # This method should be called after each test.
    def delete_test_file(self):
        if os.path.exists(TEST_FILE):
            os.remove(TEST_FILE)

    # TODO Add the proper assertions to complete the tests.

    def test_count_of_words_better(self):
        counter = WordCounter.load(TEST_FILE)
        self.assertEqual(9, counter.number_of_words())

    def test_containment_of_word(self):
        counter = WordCounter.load(TEST_FILE)
        self.assertTrue(counter.contains_word("bar"))

    def _write(self, sentence, text_file_name):
        """Helper function to create test data."""
        with open(text_file_name, "w") as text_file:
            text_file.write(sentence)
