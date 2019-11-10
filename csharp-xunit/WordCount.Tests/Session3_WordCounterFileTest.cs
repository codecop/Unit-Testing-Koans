using System;
using System.IO;
using Xunit;

namespace Org.Codecop.WordCount.Tests
{
    /// <summary>Session 3: WordCounterFileTest - Fixtures, e.g. using a test file.</summary>
    /// <seealso>"https://xunit.github.io/docs/shared-context"</seealso>
    public class Session3_WordCounterFileTest : IDisposable
    {

        public Session3_WordCounterFileTest()
        {
        }

        public void Dispose()
        {
        }

        [Fact]
        public void ShouldReturnCountOfWords()
        {
            FileInfo file = new FileInfo("tmp");
            File.WriteAllText(file.FullName, "Keep the bar green to keep the code clean.");

            var counter = new WordCounter(file);
            Assert.Equal(9, counter.NumberOfWords());

            file.Delete();
        }

        private readonly FileInfo testFile = new FileInfo("FileWordCounterTest.tmp");

        // The problem is that `delete´ is not called in case of test failures.
        // Better use `Shared Context´ hooks for test file handling.
        // TODO Add the needed method calls to the create and delete methods

        // This method should be called before each test.
        private void CreateFreshTestFileForEachTest()
        {
            File.WriteAllText(testFile.FullName, "Keep the bar green to keep the code clean.");
        }

        // This method should be called after each test.
        private void DeleteTestFile()
        {
            testFile.Delete();
        }

        // TODO add the proper assertions to complete the tests.

        [Fact]
        public void ShouldReturnCountOfWordsBetter()
        {
            var counter = new WordCounter(testFile);
            // TODO Check that 9 and counter.NumberOfWords() are equal.
        }

        [Fact]
        public void ShouldVerifyContainmentOfWord()
        {
            var counter = new WordCounter(testFile);
            // TODO Check that counter.ContainsWord("bar") is true.
        }

    }
}
