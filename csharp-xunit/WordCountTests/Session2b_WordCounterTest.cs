using Org.Codecop.WordCount;
using Xunit;

namespace Org.Codecop.WordCount.Tests
{
    /// <summary>Session 2b: WordCounterTest - More assertions.</summary>
    /// <seealso>"https://xunit.github.io/docs/comparisons#assertions"</seealso>
    public class Session2b_WordCounterTest
    {

        // TODO Add the proper assertions to complete the tests.
        // The test name explains what needs to be asserted.

        [Fact]
        public void ShouldCountGreenTwice()
        {
            var counter = new WordCounter("green bar green hat");
            // TODO Check that 2 and counter.CountOf("green") are equal.
        }

        [Fact]
        public void ShouldNotCountCapitalizedWord()
        {
            var counter = new WordCounter("green bar green hat");
            // TODO Check that 1 and counter.CountOf("HAT") are not equal.
        }

        [Fact]
        public void ShouldFindUniqueWordInUniqueWordSequence()
        {
            var counter = new WordCounter("green green");
            // TODO Check that "green" is contained in counter.UniqueWordsAsSequence().
        }

        [Fact]
        public void ShouldReturnRatioOfWordsAccuracyInRange()
        {
            var counter = new WordCounter("green bar green red green");
            // TODO Check that counter.RatioOf("bar") is in range 0.19, 0.21.
        }

        [Fact]
        public void ShouldReportSummaryOfWord()
        {
            var counter = new WordCounter("green green");
            var summary = counter.SummaryOf("green");
            // TODO Check that "green" and summary.word are equal.
            // TODO Check that 2 and summary.count are equal.
        }
    }
}
