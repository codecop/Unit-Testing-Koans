using Org.Codecop.WordCount;
using Xunit;

namespace Org.Codecop.WordCount.Tests
{
    /// <summary>Session 5b: WordCounterRatioTest - parameterised/table driven tests with JUnitParams.</summary>
    /// <seealso>"TODO"</seealso>
    public class Session5b_WordCounterRatioTest
    {

        // Mark this test as parameterised with JUnitParams
        // TODO Add the needed annotations to run this test with all examples.

        [Fact]
        public void ShouldReturnRatioOfGivenWord(string sentence, string word, double expectedRatio)
        {
            // keep
            // We want to test more cases for the ratio. Here is a table of test cases.
            // drop
            // use /*
            //
            //
            //
            //
            //
            // use */
            // drop
            var counter = new WordCounter(sentence);
            Assert.Equal(expectedRatio, counter.RatioOf(word), 3); // keep
        }

    }
}
