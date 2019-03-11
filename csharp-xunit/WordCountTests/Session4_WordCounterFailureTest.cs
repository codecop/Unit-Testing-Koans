using Org.Codecop.WordCount;
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
            // TODO Check FileNotFoundException thrown from wordCountOfMissingFile.
        }

        [Fact]
        public void ShouldThrowArgumentExceptionForUnknownWord()
        {
            var counter = new WordCounter("green bar green");
            Action ratioOfMissingWord = () => counter.RatioOf("missingWord");
            // TODO Check ArgumentException thrown from ratioOfMissingWord.
            // TODO Check that "missingWord not in sentence" and exception.Message are equal.
        }

        // TODO The next test does not work, we need to change the code,
        // but we will do that tomorrow. For today let's ignore it.

        [Fact] // TODO Mark this test as ignored with "work in progress, will continue tomorrow".
        public void ShouldCountUniqueWordsCaseInsensitive()
        {
            var counter = new WordCounter("green bar Green hat");
            Assert.Equal(new string[] { "bar", "green", "hat" }, counter.UniqueWords()); 
        }
    }
}
