GREETING = "Hello"


class Greeter(object):
    """Greetings."""

    def greet(self, name):
        """Return a proper greeting for a person."""
        if name is None:
            return GREETING
        return GREETING + " " + name.strip()
