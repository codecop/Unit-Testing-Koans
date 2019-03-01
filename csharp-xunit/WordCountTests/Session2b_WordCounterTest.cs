using Org.Codecop.WordCount;
using Xunit;

namespace Org.Codecop.WordCount.Tests
{
    /// <summary>Session 2b: WordCounterTest - More assertions.</summary>
    /// <seealso>"TODO"</seealso>
    public class Session2b_WordCounterTest
    {

        // TODO Add the proper assertions to complete the tests.
        // The test name explains what needs to be asserted.

        [Fact]
        public void ShouldCountGreenTwice()
        {
            var counter = new WordCounter("green bar green hat");
            Assert.Equal(2, counter.CountOf("green"));
        }

        [Fact]
        public void ShouldNotCountCapitalizedWord()
        {
            var counter = new WordCounter("green bar green hat");
            Assert.NotEqual(1, counter.CountOf("HAT"));
        }

        [Fact]
        public void ShouldFindUniqueWordInUniqueWordSequence()
        {
            var counter = new WordCounter("green green");
            Assert.Contains("green", counter.UniqueWordsAsSequence());
        }

        [Fact]
        public void ShouldReturnRatioOfWordsAccuracyInRange()
        {
            var counter = new WordCounter("green bar green red green");
            Assert.InRange(counter.RatioOf("bar"), 0.55, 0.65);
        }

        [Fact]
        public void ShouldReportSummaryOfWord()
        {
            var counter = new WordCounter("green green");
            var summary = counter.SummaryOf("green");
            Assert.Equal("green", summary.word);
            Assert.Equal(2, summary.count);
        }
    }
}
