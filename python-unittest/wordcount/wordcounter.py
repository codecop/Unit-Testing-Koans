from time import sleep


# Counts words of a text and provides basic analysis of that.
class WordCounter:

    def __init__(self, sentence):
        self._words = sentence.split()

    # Load words from a text file.
    @classmethod
    def load(cls, textFile):
        with open(textFile, "r") as text_file:
            return WordCounter(text_file.read())

    def numberOfWords(self):
        # here some hard core calculation...
        sleep(0.1)
        return len(self._words)

    # Return unique words sorted alphabetically.
    def uniqueWords(self):
        return sorted(set(self._words))

    def containsWord(self, word):
        return word in self._words

    def countOf(self, word):
        s = sum([1 for w in self._words if w == word])
        if s > 0:
            return s
        else:
            return None

    # Return ratio of this word's occurrence against all words.
    def ratioOf(self, word):
        count = self.countOf(word)
        if count is None:
            raise word + " not in sentence"
        return 1.0 * count / self.numberOfWords()

#     def Summary summaryOf(String word):
#         return new Summary(word, countOf(word))
#
#
#     def static class Summary: {
#         def final String word
#         def final int count
#
#         def Summary(String word, int count):
#             this.word = word
#             this.count = count
