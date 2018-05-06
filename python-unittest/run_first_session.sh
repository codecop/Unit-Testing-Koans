#!/bin/sh
# Run first session only.
python -m unittest -v test.test_session1_greeter $1 $2 $3 $4 $5 $6 $7 $8 $9
# Note: `unittest` looks for modules not files.
# Make sure to use `test.` not `test/` and no trailing `.py`.
