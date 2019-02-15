using System;
using Com.Googlecode.Catchexception;
using Org.Hamcrest.Core;
using Org.Codecop.WordCount;
using Xunit;

namespace Org.Codecop.WordCount.Tests
{
	/// <summary>Bonus Session 4b: WordCounterFailureTest - Exceptions with catchException.</summary>
	/// <remarks>Bonus Session 4b: WordCounterFailureTest - Exceptions with catchException. <br /></remarks>
	/// <seealso>"https://github.com/Codearte/catch-exception"</seealso>
	public class Session4b_WordCounterFailureTest
	{
		// TODO Add the needed code/annotations to test for an expected exception.
		[Fact]
		public virtual void ShouldThrowIllegalArgumentExceptionWithMessageOnUnknownWord()
		{
			WordCounter counter = new WordCounter("green bar green");
			CatchException.VerifyException<ArgumentException>(counter).RatioOf("missingWord");
			// Hamcrest improves readability:
			CatchException.CatchException(counter).RatioOf("missingWord");
			// keep
			Assert.AssertThat(CatchException.CaughtException(), IsInstanceOf.InstanceOf(typeof(ArgumentException)));
			Assert.Equal("missingWord not in sentence", CatchException.CaughtException().Message);
		}
	}
}
