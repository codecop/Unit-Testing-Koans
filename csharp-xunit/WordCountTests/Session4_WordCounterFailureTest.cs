using Org.Codecop.WordCount;
using System.IO;
using Xunit;

namespace Org.Codecop.WordCount.Tests
{
    /// <summary>Session 4: WordCounterFailureTest - Exceptions and ignoring tests.</summary>
    /// <seealso>"TODO"</seealso>
    public class Session4_WordCounterFailureTest
    {
        // TODO Add the needed code/annotations to test for an expected exception.

        public void ShouldThrowIOExceptionOnMissingFile()
        {
            new WordCounter(new FileInfo("IamSureThisDoesNotExist.txt"));
        }

        public void ShouldThrowIllegalArgumentExceptionForUnknownWord()
        {
            var counter = new WordCounter("green bar green");
            counter.RatioOf("missingWord");
        }

        // TODO The next test does not work, we need to change the code,
        // but we will do that tomorrow. For today let's ignore it.

        [Fact]
        public void ShouldCountUniqueWordsCaseInsensitive()
        {
            var counter = new WordCounter("green bar Green hat");
            Assert.Equal(new string[] { "bar", "green", "hat" }, counter.UniqueWords()); // keep
        }
    }
}
