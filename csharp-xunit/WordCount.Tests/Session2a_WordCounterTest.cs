using Xunit;

namespace Org.Codecop.WordCount.Tests
{
    /// <summary>Session 2a: WordCounterTest - Basic assertions.</summary>
    /// <seealso>"https://xunit.github.io/docs/comparisons#assertions"</seealso>
    public class Session2a_WordCounterTest
    {

        // TODO Add the proper assertions to complete the tests.
        // The test name explains what needs to be asserted.

        [Fact]
        public void ShouldCountNumberOfWords()
        {
            var counter = new WordCounter("Keep the bar green to keep the code clean.");
            // TODO Check that 9 and counter.NumberOfWords() are equal.
        }

        [Fact]
        public void ShouldVerifyContainmentOfWord()
        {
            var counter = new WordCounter("green bar green hat");
            // TODO Check that counter.ContainsWord("bar") is true.
        }

        [Fact]
        public void ShouldVerifyNonContainmentOfWord()
        {
            var counter = new WordCounter("green hat");
            // TODO Check that counter.ContainsWord("red") is false.
        }

        [Fact]
        public void ShouldReturnNullForUnknownWordCount()
        {
            var counter = new WordCounter("green bar green hat");
            // TODO Check that counter.CountOf("else") is null.
        }

        [Fact]
        public void ShouldReturnNotNullWordCountForExistingWord()
        {
            var counter = new WordCounter("green bar green hat");
            // TODO Check that counter.CountOf("green") is not null.
        }

        [Fact]
        public void ShouldFindUniqueWords()
        {
            var counter = new WordCounter("green bar green hat");
            // TODO Check that new string[] { "bar" and "green", "hat" }, counter.UniqueWords() are equal.
        }

        [Fact]
        public void ShouldReturnRatioOfWords()
        {
            var counter = new WordCounter("green bar green");
            // TODO Check that 0.333 and counter.RatioOf("bar") are equal.
            // Note that floating point numbers need an accuracy precision, e.g. 3 digits.
        }
    }
}
