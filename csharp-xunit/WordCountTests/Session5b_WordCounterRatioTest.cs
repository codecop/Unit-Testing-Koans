using System.Collections;
using System.Collections.Generic;
using Org.Codecop.WordCount;
using Xunit;

namespace Org.Codecop.WordCount.Tests
{
    /// <summary>Session 5b: WordCounterRatioTest - parameterised/table driven tests with ClassData.</summary>
    /// <seealso>"http://hamidmosalla.com/2017/02/25/xunit-theory-working-with-inlinedata-memberdata-classdata/"</seealso>
    public class Session5b_WordCounterRatioTest
    {

        // TODO Add the needed attributes to run this test with all examples.
        [Theory] // Mark this test as parameterised.
        [ClassData(typeof(TestCases))] // Tell it to take arguments from "TestCases".
        public void ShouldReturnRatioOfGivenWord(string sentence, string word, double expectedRatio)
        {
            var counter = new WordCounter(sentence);
            Assert.Equal(expectedRatio, counter.RatioOf(word), 2); // keep
        }

    }

    public class TestCases : IEnumerable<object[]>
    {
        // We want to test more corner cases for the ratio. Here is a table of test cases.
        private readonly List<object[]> testCases = new List<object[]>{
            new object[] {"green", "green", 1.0},
            new object[] {"green bar green", "green", 0.67},
            new object[] {"green bar green bar", "green", 0.5},
            new object[] {"green bar green", "bar", 0.33}
        };

        public IEnumerator<object[]> GetEnumerator() => testCases.GetEnumerator();

        IEnumerator IEnumerable.GetEnumerator() => GetEnumerator();
    }
}
