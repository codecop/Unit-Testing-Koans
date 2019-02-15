using Org.Codecop.WordCount;
using NHamcrest.Collection;
using NHamcrest.Core;
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
        public virtual void ShouldCountNumberOfWords()
        {
            WordCounter counter = new WordCounter("Keep the bar green to keep the code clean.");
            Assert.Equal(9, counter.NumberOfWords()); // keep
            // Hamcrest improves readability:
            Assert.AssertThat(counter.NumberOfWords(), IsEqual.EqualTo(9));
        }

        [Fact]
        public virtual void ShouldContainUniqueWord()
        {
            WordCounter counter = new WordCounter("green bar green hat");
            Assert.True(Arrays.AsList(counter.UniqueWords()).Contains("bar")); // keep
            // Hamcrest improves readability:
            Assert.AssertThat(counter.UniqueWords(), IsArrayContaining.HasItemInArray("bar"));
        }

        [Fact]
        public virtual void ShouldNotContainUniqueWord()
        {
            WordCounter counter = new WordCounter("green bar green hat");
            Assert.IsFalse(Arrays.AsList(counter.UniqueWords()).Contains("foo")); // keep
            // Hamcrest improves readability:
            Assert.AssertThat(counter.UniqueWords(), IsNot.Not(IsArrayContaining.HasItemInArray("foo")));
        }

        [Fact]
        public virtual void ShouldFindNumberOfUniqueWords()
        {
            WordCounter counter = new WordCounter("green bar green hat");
            Assert.Equal(3, counter.UniqueWords().Length); // keep
            // Hamcrest improves readability:
            Assert.AssertThat(counter.UniqueWords(), IsArrayWithSize.ArrayWithSize(3));
        }
    }
}
