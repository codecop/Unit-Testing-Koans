using NHamcrest;
using NHamcrest.XUnit;

namespace Org.Codecop.WordCount.Tests
{
    /// <summary>Bonus Session 2c: WordCounterTest - Assertions with Hamcrest.</summary>
    /// <seealso>"https://github.com/nhamcrest/NHamcrest"</seealso>
    public class Session2c_WordCounterTest
    {

        // TODO Add the proper assertions to complete the tests using Hamcrest.
        // The test name explains what needs to be asserted.

        [Xunit.Fact]
        public void ShouldCountNumberOfWords()
        {
            var counter = new WordCounter("Keep the bar green to keep the code clean.");
            Xunit.Assert.Equal(9, counter.NumberOfWords());
            // Hamcrest improves readability:
            // TODO Check that counter.NumberOfWords(), EqualTo 9.
        }

        [Xunit.Fact]
        public void ShouldContainUniqueWord()
        {
            var counter = new WordCounter("green bar green hat");
            Xunit.Assert.Contains(counter.UniqueWords(), w => w == "bar");
            // Hamcrest improves readability:
            // TODO Check that counter.UniqueWords(), Has.Item EqualTo "bar".
        }

        [Xunit.Fact]
        public void ShouldNotContainUniqueWord()
        {
            var counter = new WordCounter("green bar green hat");
            Xunit.Assert.DoesNotContain(counter.UniqueWords(), w => w == "foo");
            // Hamcrest improves readability:
            // TODO Check that counter.UniqueWords(), Not Has.Item EqualTo "foo".
        }

        [Xunit.Fact]
        public void ShouldFindNumberOfUniqueWords()
        {
            var counter = new WordCounter("green bar green hat");
            Xunit.Assert.Equal(3, counter.UniqueWords().Length);
            // Hamcrest improves readability:
            // TODO Check that counter.UniqueWords(), OfLength 3.
        }
    }
}
