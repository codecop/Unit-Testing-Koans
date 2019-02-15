using Org.Codecop.WordCount;
using Xunit;

namespace Org.Codecop.WordCount.Tests
{
    /// <summary>Session 3: WordCounterFileTest - Fixtures, e.g. using a test file.</summary>
    /// <seealso>"TODO"</seealso>
    public class Session3_WordCounterFileTest
    {

        [Fact]
        public virtual void ShouldReturnCountOfWords()
        {
            FilePath file = new FilePath("tmp");
            StringToFile.Write("Keep the bar green to keep the code clean.", file);
            WordCounter counter = new WordCounter(file);
            Assert.Equal(9, counter.NumberOfWords());
            // keep
            file.Delete();
        }

        private readonly FilePath testFile = new FilePath("FileWordCounterTest.tmp");

        // The problem is that `delete´ is not called in case of test failures.
        // Better use `BeforeEach/AfterEach´ hooks for test file handling.
        // TODO Add the needed annotations to the hook methods and then

        [Before]
        public virtual void CreateFreshTestFileForEachTest()
        {
            // This method should be called before each test.
            StringToFile.Write("Keep the bar green to keep the code clean.", testFile);
        }

        [After]
        public virtual void DeleteTestFile()
        {
            // This method should be called after each test.
            Assert.True(testFile.Delete()); // keep
        }

        // TODO add the proper assertions to complete the tests.

        [Fact]
        public virtual void ShouldReturnCountOfWordsBetter()
        {
            WordCounter counter = new WordCounter(testFile);
            Assert.Equal(9, counter.NumberOfWords());
        }

        [Fact]
        public virtual void ShouldVerifyContainmentOfWord()
        {
            WordCounter counter = new WordCounter(testFile);
            Assert.True(counter.ContainsWord("bar"));
        }
    }
}
