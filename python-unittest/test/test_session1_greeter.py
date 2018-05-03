import unittest

from wordcount.greeter import Greeter


class Session1GreeterTestCase(unittest.TestCase):
    """Session 1: GreeterTestCase - Your first tests."""

    # TODO We will add the proper self.assertions together.

    def test_hello_name(self):
        greeter = Greeter()
        # TODO Check that "Hello Peter", greeter.greet("Peter") is equal.

    def test_hello_none(self):
        greeter = Greeter()
        # TODO Check that "Hello", greeter.greet(None) is equal.

    def test_ignore_whitespace(self):
        greeter = Greeter()
        # TODO Check that "Hello Peter", greeter.greet(" Peter ") is equal.
