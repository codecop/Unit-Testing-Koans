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
            // TODO Check that "Hello Peter" and greeter.Greet("Peter") are equal.
        }

        [Fact]
        public void ShouldReturnHelloForNull()
        {
            var greeter = new Greeter();
            // TODO Check that "Hello" and greeter.Greet(null) are equal.
        }

        [Fact]
        public void ShouldIgnoreWhitespace()
        {
            var greeter = new Greeter();
            // TODO Check that "Hello Peter" and greeter.Greet(" Peter ") are equal.
        }
    }
}
