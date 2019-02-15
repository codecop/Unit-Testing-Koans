using Org.Codecop.WordCount;
using FluentAssertions;
using Xunit;

namespace Org.Codecop.WordCount.Tests
{
    /// <summary>Bonus Session 2d: WordCounterTest - Assertions with FluentAssertions.</summary>
    /// <seealso>"TODO"</seealso>
    public class Session2d_WordCounterTest
    {

        // TODO Add the proper assertions to complete the tests using AssertJ.
        // The test name explains what needs to be asserted.

        [Fact]
        public virtual void ShouldCountNumberOfWords()
        {
            WordCounter counter = new WordCounter("Keep the bar green to keep the code clean.");
            Assert.Equal(9, counter.NumberOfWords()); // keep
			// FluentAssertions is fluent:
            Assertions.AssertThat(counter.NumberOfWords()).IsEqualTo(9);
        }

        [Fact]
        public virtual void ShouldContainUniqueWord()
        {
            WordCounter counter = new WordCounter("green bar green hat");
            Assert.True(Arrays.AsList(counter.UniqueWords()).Contains("bar")); // keep
            // FluentAssertions is fluent:
            Assertions.AssertThat(counter.UniqueWords()).Contains("bar");
        }

        [Fact]
        public virtual void ShouldNotContainUniqueWord()
        {
            WordCounter counter = new WordCounter("green bar green hat");
            Assert.IsFalse(Arrays.AsList(counter.UniqueWords()).Contains("foo")); // keep
            // FluentAssertions is fluent:
            Assertions.AssertThat(counter.UniqueWords()).DoesNotContain("foo");
        }

        [Fact]
        public virtual void ShouldFindNumberOfUniqueWords()
        {
            WordCounter counter = new WordCounter("green bar green hat");
            Assert.Equal(3, counter.UniqueWords().Length); // keep
            // FluentAssertions is fluent:
            Assertions.AssertThat(counter.UniqueWords()).HasSize(3);
        }
    }
}
