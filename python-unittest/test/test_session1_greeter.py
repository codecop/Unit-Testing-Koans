import unittest

from wordcount.greeter import Greeter


class Session1GreeterTestCase(unittest.TestCase):
    """Session 1: GreeterTestCase - Your first tests."""

    # TODO We will add the proper self.assertions together.

    def test_hello_name(self):
        greeter = Greeter()
        self.assertEqual("Hello Peter", greeter.greet("Peter"))

    def test_hello_none(self):
        greeter = Greeter()
        self.assertEqual("Hello", greeter.greet(None))

    def test_ignore_whitespace(self):
        greeter = Greeter()
        self.assertEqual("Hello Peter", greeter.greet(" Peter "))
