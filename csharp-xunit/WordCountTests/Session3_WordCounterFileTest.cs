using Org.Codecop.WordCount;
using System.IO;
using Xunit;

namespace Org.Codecop.WordCount.Tests
{
    /// <summary>Session 3: WordCounterFileTest - Fixtures, e.g. using a test file.</summary>
    /// <seealso>"TODO"</seealso>
    public class Session3_WordCounterFileTest
    {

        [Fact]
        public void ShouldReturnCountOfWords()
        {
            FileInfo file = new FileInfo("tmp");
            System.IO.File.WriteAllText(file.FullName, "Keep the bar green to keep the code clean.");
            var counter = new WordCounter(file);
            Assert.Equal(9, counter.NumberOfWords()); // keep
            file.Delete();
        }

        private readonly FileInfo testFile = new FileInfo("FileWordCounterTest.tmp");

        // The problem is that `delete´ is not called in case of test failures.
        // Better use `BeforeEach/AfterEach´ hooks for test file handling.
        // TODO Add the needed annotations to the hook methods and then

        [Before]
        public void CreateFreshTestFileForEachTest()
        {
            // This method should be called before each test.
            System.IO.File.WriteAllText(testFile.FullName, "Keep the bar green to keep the code clean.");
        }

        [After]
        public void DeleteTestFile()
        {
            // This method should be called after each test.
            testFile.Delete();
        }

        // TODO add the proper assertions to complete the tests.

        [Fact]
        public void ShouldReturnCountOfWordsBetter()
        {
            var counter = new WordCounter(testFile);
            Assert.Equal(9, counter.NumberOfWords());
        }

        [Fact]
        public void ShouldVerifyContainmentOfWord()
        {
            var counter = new WordCounter(testFile);
            Assert.True(counter.ContainsWord("bar"));
        }
    }
}
