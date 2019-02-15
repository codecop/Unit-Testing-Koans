using Org.Codecop.WordCount;
using Xunit;

namespace Org.Codecop.WordCount.Tests
{
	/// <summary>Session 5b: WordCounterRatioTest - parameterised/table driven tests with JUnitParams.</summary>
	/// <remarks>Session 5b: WordCounterRatioTest - parameterised/table driven tests with JUnitParams. <br /></remarks>
	/// <seealso>"https://github.com/Pragmatists/junitparams"</seealso>
	public class Session5b_WordCounterRatioTest
	{
		// Mark this test as parameterised with JUnitParams
		// TODO Add the needed annotations to run this test with all examples.
		[Fact]
		public virtual void ShouldReturnRatioOfGivenWord(string sentence, string word, double expectedRatio)
		{
			// keep
			// We want to test more cases for the ratio. Here is a table of test cases.
			// drop
			// use /*
			//
			//
			//
			//
			//
			// use */
			// drop
			WordCounter counter = new WordCounter(sentence);
			Assert.Equal(expectedRatio, counter.RatioOf(word), 0.01);
		}
		// keep
	}
}
