using Org.Codecop.WordCount;
using System;
using Xunit;

namespace Org.Codecop.WordCount.Tests
{
	/// <summary>Bonus Session 4b: WordCounterFailureTest - Exceptions with catchException.</summary>
	/// <seealso>"https://github.com/Codearte/catch-exception"</seealso>
	public class Session4b_WordCounterFailureTest
	{
		// TODO Add the needed code/annotations to test for an expected exception.
		[Fact]
		public void ShouldThrowIllegalArgumentExceptionWithMessageOnUnknownWord()
		{
			var counter = new WordCounter("green bar green");
			CatchException.VerifyException<ArgumentException>(counter).RatioOf("missingWord");
			// Hamcrest improves readability:
			CatchException.CatchException(counter).RatioOf("missingWord");
			// keep
			Assert.That(CatchException.CaughtException(), IsInstanceOf.InstanceOf(typeof(ArgumentException)));
			Assert.Equal("missingWord not in sentence", CatchException.CaughtException().Message);
		}
	}
}
