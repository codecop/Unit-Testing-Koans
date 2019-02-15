using Org.Codecop.WordCount;
using Xunit;

namespace Org.Codecop.WordCount.Tests
{
    /// <summary>Session 4: WordCounterFailureTest - Exceptions and ignoring tests.</summary>
    /// <seealso>"TODO"</seealso>
    public class Session4_WordCounterFailureTest
    {
        // TODO Add the needed code/annotations to test for an expected exception.

        public virtual void ShouldThrowIOExceptionOnMissingFile()
        {
            new WordCounter(new FilePath("IamSureThisDoesNotExist.txt"));
        }

        public virtual void ShouldThrowIllegalArgumentExceptionForUnknownWord()
        {
            WordCounter counter = new WordCounter("green bar green");
            counter.RatioOf("missingWord");
        }

        // TODO The next test does not work, we need to change the code,
        // but we will do that tomorrow. For today let's ignore it.

        [Fact]
        public virtual void ShouldCountUniqueWordsCaseInsensitive()
        {
            WordCounter counter = new WordCounter("green bar Green hat");
            Assert.AssertArrayEquals(new string[] { "bar", "green", "hat" }, counter.UniqueWords()); // keep
        }
    }
}
