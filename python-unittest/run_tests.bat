@rem Run all tests of all sessions.
@call python -m unittest discover -v -f test %*
@rem Windows sorts files by filename and discover finds sessions in right order
