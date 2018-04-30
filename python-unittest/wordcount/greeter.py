GREETING = "Hello"


class Greeter:

    # Return a proper greeting for a person.
    def greet(self, name):
        if name is None:
            return GREETING
        return GREETING + " " + name.strip()
