import unittest

from wordcount.greeter import Greeter


# Session 1: GreeterTestCase - Your first tests.
class Session1_GreeterTestCase(unittest.TestCase):

    # TODO We will add the proper self.assertions together.

    def testHelloName(self):
        greeter = Greeter()
        self.assertEqual("Hello Peter", greeter.greet("Peter"))

    def testHelloNone(self):
        greeter = Greeter()
        self.assertEqual("Hello", greeter.greet(None))

    def testIgnoreWhitespace(self):
        greeter = Greeter()
        self.assertEqual("Hello Peter", greeter.greet(" Peter "))
