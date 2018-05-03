# Python-Unittest-Koans #

Python [Testing Koans](http://blog.code-cop.org/2015/12/testing-koans.html) to understand how to write unit tests with [unittest](https://docs.python.org/2/library/unittest.html).

## Dependencies ##

This is a Python project. It is compatible with both Python 2 and 3. 
Required dependencies are listed in [`requirements.txt`](requirements.txt).

Additional exercises cover [parameterized](https://github.com/wolever/parameterized) and 
[PyHamcrest](https://github.com/hamcrest/PyHamcrest). Run `pip install -r requirements.txt`
to install the required packages. Alternatively the dependencies are available in the `wheels` folder.

## Assignment ##

* Run script `run_tests` (or `python -m unittest discover test`).
* You should see some test failures and errors (but there are no assertions).
* Go through the test code starting from Session 1:
    * All assertions are commented and incomplete.
    * Uncomment the assertions and complete them making the tests pass.
    * You can run individual sessions using `python -m unittest test.test_session1_greeter` (Note: Unittest looks for modules not files. Make sure to use `test.` not `test/` and no trailing `.py`.)

### License ###
[New BSD License](http://opensource.org/licenses/bsd-license.php), see `license.txt` in repository.
