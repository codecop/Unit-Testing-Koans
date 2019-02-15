using System;
using System.Collections.Generic;
using System.Linq;
using System.IO;
using System.Text.RegularExpressions;
using System.Threading;

namespace Org.Codecop.WordCount
{
    /// <summary>Counts words of a text and provides basic analysis of that.</summary>
    public class WordCounter
    {
        private readonly IList<string> words;

        public WordCounter(string sentence)
        {
            words = sentence.Split("\\s+");
        }

        /// <summary>Load words from a text file.</summary>
        public WordCounter(FileInfo wordFile)
            : this(File.ReadAllText(wordFile.FullName))
        {
        }

        public int NumberOfWords()
        {
            // here some hard core calculation...
            Thread.Sleep(100);
            return words.Count;
        }

        /// <returns>unique words sorted alphabetically.</returns>
        public string[] UniqueWords()
        {
            IEnumerable<string> uniqueWords = words.Distinct();
            return uniqueWords.OrderBy(w => w).ToArray();
        }

        public bool ContainsWord(string word)
        {
            return words.Contains(word);
        }

        public int? CountOf(string word)
        {
            int sum = 0;
            foreach (string w in words)
            {
                if (word.Equals(w))
                {
                    sum++;
                }
            }
            if (sum > 0)
            {
                return sum;
            }
            return null;
        }

        /// <returns>ratio of this word's occurrence against all words.</returns>
        public double RatioOf(string word)
        {
            int? count = CountOf(word);
            if (count == null)
            {
                throw new ArgumentException(word + " not in sentence");
            }
            return 1.0 * count.Value / NumberOfWords();
        }
    }
}
