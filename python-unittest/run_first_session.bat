@rem Run first session only.
@call python -m unittest -v test.test_session1_greeter %*

@rem Note: `unittest` looks for modules not files.
@rem Make sure to use `test.` not `test\` and no trailing `.py`.

@rem python -m unittest -v test.test_session2a_wordcount
@rem python -m unittest -v test.test_session2b_wordcount
@rem python -m unittest -v test.test_session2c_wordcount
@rem python -m unittest -v test.test_session2d_wordcount
@rem python -m unittest -v test.test_session3_wordcount_file
@rem python -m unittest -v test.test_session4_wordcount_failure
@rem python -m unittest -v test.test_session5a_wordcount_ratio
@rem python -m unittest -v test.test_session5b_wordcount_ratio
