using Org.Codecop.WordCount;
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
            Assert.Equal(9, counter.NumberOfWords());
        }

        [Fact]
        public void ShouldVerifyContainmentOfWord()
        {
            var counter = new WordCounter("green bar green hat");
            Assert.True(counter.ContainsWord("bar"));
        }

        [Fact]
        public void ShouldVerifyNonContainmentOfWord()
        {
            var counter = new WordCounter("green hat");
            Assert.False(counter.ContainsWord("red"));
        }

        [Fact]
        public void ShouldReturnNullForUnknownWordCount()
        {
            var counter = new WordCounter("green bar green hat");
            Assert.Null(counter.CountOf("else"));
        }

        [Fact]
        public void ShouldReturnNotNullWordCountForExistingWord()
        {
            var counter = new WordCounter("green bar green hat");
            Assert.NotNull(counter.CountOf("green"));
        }

        [Fact]
        public void ShouldFindUniqueWords()
        {
            var counter = new WordCounter("green bar green hat");
            Assert.Equal(new string[] { "bar", "green", "hat" }, counter.UniqueWords());
        }

        [Fact]
        public void ShouldReturnRatioOfWords()
        {
            var counter = new WordCounter("green bar green");
            Assert.Equal(0.333, counter.RatioOf("bar"), 3);
            // Note that floating point numbers need an accuracy precision, e.g. 3 digits.
        }
    }
}
