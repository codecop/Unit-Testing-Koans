using Org.Codecop.WordCount;
using System.Collections.Generic;
using Xunit;

namespace Org.Codecop.WordCount.Tests
{
    /// <summary>Session 5: WordCounterRatioTest - parameterised/table driven tests.</summary>
    /// <seealso>"TODO"</seealso>
    public class Session5_WordCounterRatioTest
    {
        private static readonly IList<object[]> TestCases = Arrays.AsList(
            new object[] { "green", "green", 1.0 },
            new object[] { "green bar green", "green", 0.66 },
            new object[] { "green bar green bar", "green", 0.5 },
            new object[] { "green bar green", "bar", 0.33 });

        // Mark this test as parameterised
        // TODO Add the needed annotations to run this test with all examples.
        // We want to test more corner cases for the ratio. Here is a table of test cases.
        //
        //
        //
        //
        //
        public static IList<object[]> GetTestCases()
        {
            // This method returns the parameters
            return TestCases;
        }

        private readonly string sentence;

        private readonly string word;

        private readonly double expectedRatio;

        public Session5_WordCounterRatioTest(string sentence, string word, double expectedRratio)
        {
            this.sentence = sentence;
            this.word = word;
            this.expectedRatio = expectedRratio;
        }

        [Fact]
        public virtual void ShouldReturnRatioOfGivenWord()
        {
            WordCounter counter = new WordCounter(sentence);
            Assert.Equal(expectedRatio, counter.RatioOf(word), 0.01); // keep
        }
    }
}
