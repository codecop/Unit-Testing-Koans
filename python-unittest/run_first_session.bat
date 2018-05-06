@rem Run first session only.
@call python -m unittest -v test.test_session1_greeter %*
@rem Note: `unittest` looks for modules not files.
@rem Make sure to use `test.` not `test\` and no trailing `.py`.
