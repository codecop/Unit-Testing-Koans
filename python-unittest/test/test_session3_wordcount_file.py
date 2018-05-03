import os.path
import unittest

from wordcount.wordcounter import WordCounter


TEST_FILE = "FileWordCounterTest.tmp"


# Session 3: WordCounterFileTestCase - Fixtures, e.g. using a test file.
# See "https://docs.python.org/2/library/unittest.html#test-cases"
class Session3_WordCounterFileTestCase(unittest.TestCase):

    def testCountOfWords(self):
        self._write("Keep the bar green to keep the code clean.", TEST_FILE)

        counter = WordCounter.load(TEST_FILE)
        self.assertEqual(9, counter.number_of_words())  # keep

        os.remove(TEST_FILE)

    # The problem is that os.remove is not called in case of test failures.
    # Better use setUp/tearDown hooks for test file handling.

    # TODO Add the needed methods and calls to create and delete test files.

    def setUp(self):  # drop
        self.createFreshTestFileForEachTest()  # drop

    # This method should be called before each test.
    def createFreshTestFileForEachTest(self):
        self._write("Keep the bar green to keep the code clean.", TEST_FILE)

    def tearDown(self):  # drop
        self.deleteTestFile()  # drop

    # This method should be called after each test.
    def deleteTestFile(self):
        if os.path.exists(TEST_FILE):
            os.remove(TEST_FILE)

    # TODO Add the proper assertions to complete the tests.

    def testCountOfWordsBetter(self):
        counter = WordCounter.load(TEST_FILE)
        self.assertEqual(9, counter.number_of_words())

    def testContainmentOfWord(self):
        counter = WordCounter.load(TEST_FILE)
        self.assertTrue(counter.contains_word("bar"))

    # Helper function to create test data.
    def _write(self, sentence, fileName):
        with open(fileName, "w") as text_file:
            text_file.write(sentence)
