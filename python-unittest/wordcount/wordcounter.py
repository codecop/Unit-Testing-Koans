from time import sleep


class WordCounter(object):
    """Counts words of a text and provides basic analysis of that."""

    def __init__(self, sentence):
        self._words = sentence.split()

    @classmethod
    def load(cls, text_file_name):
        """Load words from a text file."""
        with open(text_file_name, "r") as text_file:
            return WordCounter(text_file.read())

    def number_of_words(self):
        sleep(0.1)  # here some hard core calculation...
        return len(self._words)

    def unique_words(self):
        """Return unique words sorted alphabetically."""
        return sorted(set(self._words))

    def contains_word(self, word):
        return word in self._words

    def count_of(self, word):
        tmp_sum = sum([1 for w in self._words if w == word])
        if tmp_sum > 0:
            return tmp_sum
        return None

    def ratio_of(self, word):
        """Return ratio of this word's occurrence against all words."""
        count = self.count_of(word)
        if count is None:
            raise ValueError(word + " not in sentence")
        return 1.0 * count / self.number_of_words()

    def first_unique_word(self):
        return self.unique_words()[0]
