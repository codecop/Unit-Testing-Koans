using Org.Codecop.WordCount;
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
            FilePath file = new FilePath("tmp");
            StringToFile.Write("Keep the bar green to keep the code clean.", file);
            var counter = new WordCounter(file);
            Assert.Equal(9, counter.NumberOfWords());
            // keep
            file.Delete();
        }

        private readonly FilePath testFile = new FilePath("FileWordCounterTest.tmp");

        // The problem is that `delete´ is not called in case of test failures.
        // Better use `BeforeEach/AfterEach´ hooks for test file handling.
        // TODO Add the needed annotations to the hook methods and then

        [Before]
        public void CreateFreshTestFileForEachTest()
        {
            // This method should be called before each test.
            StringToFile.Write("Keep the bar green to keep the code clean.", testFile);
        }

        [After]
        public void DeleteTestFile()
        {
            // This method should be called after each test.
            Assert.True(testFile.Delete()); // keep
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
