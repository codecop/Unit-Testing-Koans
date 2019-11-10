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
            Assert.Equal(9, counter.NumberOfWords());
            // FluentAssertions is fluent:
            // TODO Check that counter.NumberOfWords() and 9 are equal.
        }

        [Fact]
        public void ShouldContainUniqueWord()
        {
            var counter = new WordCounter("green bar green hat");
            Assert.Contains(counter.UniqueWords(), w => w == "bar");
            // FluentAssertions is fluent:
            // TODO Check that counter.UniqueWords() does contain "bar".
        }

        [Fact]
        public void ShouldNotContainUniqueWord()
        {
            var counter = new WordCounter("green bar green hat");
            Assert.DoesNotContain(counter.UniqueWords(), w => w == "foo");
            // FluentAssertions is fluent:
            // TODO Check that counter.UniqueWords() does not contain "foo".
        }

        [Fact]
        public void ShouldFindNumberOfUniqueWords()
        {
            var counter = new WordCounter("green bar green hat");
            Assert.Equal(3, counter.UniqueWords().Length);
            // FluentAssertions is fluent:
            // TODO Check that counter.UniqueWords() does have count of 3.
        }
    }
}
