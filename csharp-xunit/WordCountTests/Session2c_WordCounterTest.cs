using Org.Codecop.WordCount;
using NHamcrest;
using Xunit;

namespace Org.Codecop.WordCount.Tests
{
    /// <summary>Bonus Session 2c: WordCounterTest - Assertions with Hamcrest.</summary>
    /// <seealso>"TODO"</seealso>
    public class Session2c_WordCounterTest
    {

        // TODO Add the proper assertions to complete the tests using Hamcrest.
        // The test name explains what needs to be asserted.

        [Fact]
        public void ShouldCountNumberOfWords()
        {
            var counter = new WordCounter("Keep the bar green to keep the code clean.");
            Assert.Equal(9, counter.NumberOfWords()); // keep
            // Hamcrest improves readability:
            Assert.That(counter.NumberOfWords(), Is.EqualTo(9));
        }

        [Fact]
        public void ShouldContainUniqueWord()
        {
            var counter = new WordCounter("green bar green hat");
            Assert.Contains(counter.UniqueWords(), w => w == "bar"); // keep
            // Hamcrest improves readability:
            Assert.That(counter.UniqueWords(), IsArrayContaining.HasItemInArray("bar"));
        }

        [Fact]
        public void ShouldNotContainUniqueWord()
        {
            var counter = new WordCounter("green bar green hat");
            Assert.DoesNotContain(counter.UniqueWords(), w => w == "foo"); // keep
            // Hamcrest improves readability:
            Assert.That(counter.UniqueWords(), Is.Not(IsArrayContaining.HasItemInArray("foo")));
        }

        [Fact]
        public void ShouldFindNumberOfUniqueWords()
        {
            var counter = new WordCounter("green bar green hat");
            Assert.Equal(3, counter.UniqueWords().Length); // keep
            // Hamcrest improves readability:
            Assert.That(counter.UniqueWords(), IsArrayWithSize.ArrayWithSize(3));
        }
    }
}
