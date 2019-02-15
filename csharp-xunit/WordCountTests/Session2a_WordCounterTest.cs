using Org.Codecop.WordCount;
using Xunit;

namespace Org.Codecop.WordCount.Tests
{
    /// <summary>Session 2a: WordCounterTest - Basic assertions.</summary>
    /// <seealso>"TODO"</seealso>
    public class Session2a_WordCounterTest
    {

        // TODO Add the proper assertions to complete the tests.
        // The test name explains what needs to be asserted.

        [Fact]
        public virtual void ShouldCountNumberOfWords()
        {
            WordCounter counter = new WordCounter("Keep the bar green to keep the code clean.");
            Assert.Equal(9, counter.NumberOfWords());
        }

        [Fact]
        public virtual void ShouldVerifyContainmentOfWord()
        {
            WordCounter counter = new WordCounter("green bar green hat");
            Assert.True(counter.ContainsWord("bar"));
        }

        [Fact]
        public virtual void ShouldVerifyNonContainmentOfWord()
        {
            WordCounter counter = new WordCounter("green hat");
            Assert.IsFalse(counter.ContainsWord("red"));
        }

        [Fact]
        public virtual void ShouldReturnNullForUnknownWordCount()
        {
            WordCounter counter = new WordCounter("green bar green hat");
            Assert.IsNull(counter.CountOf("else"));
        }

        [Fact]
        public virtual void ShouldReturnNotNullWordCountForExistingWord()
        {
            WordCounter counter = new WordCounter("green bar green hat");
            Assert.IsNotNull(counter.CountOf("green"));
        }

        [Fact]
        public virtual void ShouldCountGreenTwice()
        {
            WordCounter counter = new WordCounter("green bar green hat");
            Assert.Equal(Sharpen.Extensions.ValueOf(2), counter.CountOf("green"));
        }

        [Fact]
        public virtual void ShouldFindUniqueWords()
        {
            WordCounter counter = new WordCounter("green bar green hat");
            Assert.AssertArrayEquals(new string[] { "bar", "green", "hat" }, counter.UniqueWords());
        }

        [Fact]
        public virtual void ShouldReturnRatioOfWords()
        {
            WordCounter counter = new WordCounter("green bar green");
            Assert.Equal(0.33, counter.RatioOf("bar"), 0.01);
            // Note that floating point numbers need an accuracy delta, e.g. 0.01.
        }
    }
}
