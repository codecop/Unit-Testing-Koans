using Org.Codecop.WordCount;
using Xunit;

namespace Org.Codecop.WordCount.Tests
{
    /// <summary>Session 1: GreeterTest - Your first tests.</summary>
    public class Session1_GreeterTest
    {

        // TODO We will add the proper assertions together.

        [Fact]
        public void ShouldReturnHelloName()
        {
            var greeter = new Greeter();
            Assert.Equal("Hello Peter", greeter.Greet("Peter"));
        }

        [Fact]
        public void ShouldReturnHelloForNull()
        {
            var greeter = new Greeter();
            Assert.Equal("Hello", greeter.Greet(null));
        }

        [Fact]
        public void ShouldIgnoreWhitespace()
        {
            var greeter = new Greeter();
            Assert.Equal("Hello Peter", greeter.Greet(" Peter "));
        }
    }
}
