using Org.Codecop.WordCount;
using Xunit;

namespace Org.Codecop.WordCount.Tests
{
    /// <summary>Session 1: GreeterTest - Your first tests.</summary>
    public class Session1_GreeterTest
    {

        // TODO We will add the proper assertions together.

        [Fact]
        public virtual void ShouldReturnHelloName()
        {
            Greeter greeter = new Greeter();
            Assert.Equal("Hello Peter", greeter.Greet("Peter"));
        }

        [Fact]
        public virtual void ShouldReturnHelloForNull()
        {
            Greeter greeter = new Greeter();
            Assert.Equal("Hello", greeter.Greet(null));
        }

        [Fact]
        public virtual void ShouldIgnoreWhitespace()
        {
            Greeter greeter = new Greeter();
            Assert.Equal("Hello Peter", greeter.Greet(" Peter "));
        }
    }
}
