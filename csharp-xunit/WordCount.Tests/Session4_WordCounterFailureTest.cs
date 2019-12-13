using System;
using System.IO;
using Xunit;

namespace Org.Codecop.WordCount.Tests
{
    /// <summary>Session 4: WordCounterFailureTest - Exceptions and ignoring tests.</summary>
    /// <seealso>"https://hadihariri.com/2008/10/17/testing-exceptions-with-xunit/"</seealso>
    public class Session4_WordCounterFailureTest
    {
        // TODO Add the needed code/attributes to test for an expected exception.

        [Fact]
        public void ShouldThrowExceptionOnMissingFile()
        {
            Action wordCountOfMissingFile = () => new WordCounter(new FileInfo("IamSureThisDoesNotExist.txt"));
            Assert.Throws<FileNotFoundException>(wordCountOfMissingFile);
        }

        [Fact]
        public void ShouldThrowArgumentExceptionForUnknownWord()
        {
            var counter = new WordCounter("green bar green");
            Action ratioOfMissingWord = () => counter.RatioOf("missingWord");
            var exception = Assert.Throws<ArgumentException>(ratioOfMissingWord);
            Assert.Equal("missingWord not in sentence", exception.Message);
        }

        // TODO The next test does not work, we need to change the code,
        // but we will do that tomorrow. For today let's ignore it.

        [Fact(Skip = "work in progress, will continue tomorrow")]
        public void ShouldCountUniqueWordsCaseInsensitive()
        {
            var counter = new WordCounter("green bar Green hat");
            Assert.Equal(new string[] { "bar", "green", "hat" }, counter.UniqueWords()); // keep
        }
    }
}
