#!/bin/sh
# Run first session only.
python -m unittest -v test.test_session1_greeter $1 $2 $3 $4 $5 $6 $7 $8 $9

# Note: `unittest` looks for modules not files.
# Make sure to use `test.` not `test/` and no trailing `.py`.

# python -m unittest -v test.test_session2a_wordcount
# python -m unittest -v test.test_session2b_wordcount
# python -m unittest -v test.test_session2c_wordcount
# python -m unittest -v test.test_session2d_wordcount
# python -m unittest -v test.test_session3_wordcount_file
# python -m unittest -v test.test_session4_wordcount_failure
# python -m unittest -v test.test_session5a_wordcount_ratio
# python -m unittest -v test.test_session5b_wordcount_ratio
