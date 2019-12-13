namespace Org.Codecop.WordCount
{
    public class Greeter
    {
        private const string Greeting = "Hello";

        /// <summary>Return a proper greeting for a person.</summary>
        public string Greet(string name)
        {
            if (name == null)
            {
                return Greeting;
            }
            return Greeting + " " + name.Trim();
        }
    }
}
