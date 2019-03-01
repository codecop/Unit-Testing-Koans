using Org.Codecop.WordCount;
using FluentAssertions;
using Xunit;

namespace Org.Codecop.WordCount.Tests
{
    /// <summary>Bonus Session 2d: WordCounterTest - Assertions with FluentAssertions.</summary>
    /// <seealso>"https://fluentassertions.com/documentation/"</seealso>
    public class Session2d_WordCounterTest
    {

        // TODO Add the proper assertions to complete the tests using AssertJ.
        // The test name explains what needs to be asserted.

        [Fact]
        public void ShouldCountNumberOfWords()
        {
            var counter = new WordCounter("Keep the bar green to keep the code clean.");
            Assert.Equal(9, counter.NumberOfWords()); // keep
            // FluentAssertions is fluent:
            counter.NumberOfWords().Should().Equals(9);
        }

        [Fact]
        public void ShouldContainUniqueWord()
        {
            var counter = new WordCounter("green bar green hat");
            Assert.Contains(counter.UniqueWords(), w => w == "bar"); // keep
            // FluentAssertions is fluent:
            counter.UniqueWords().Should().Contain("bar");
        }

        [Fact]
        public void ShouldNotContainUniqueWord()
        {
            var counter = new WordCounter("green bar green hat");
            Assert.DoesNotContain(counter.UniqueWords(), w => w == "foo"); // keep
            // FluentAssertions is fluent:
            counter.UniqueWords().Should().NotContain("foo");
        }

        [Fact]
        public void ShouldFindNumberOfUniqueWords()
        {
            var counter = new WordCounter("green bar green hat");
            Assert.Equal(3, counter.UniqueWords().Length); // keep
            // FluentAssertions is fluent:
            counter.UniqueWords().Should().HaveCount(3);
        }
    }
}
