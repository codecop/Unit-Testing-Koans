#!/bin/sh
# Run all tests of all sessions.
python -m unittest discover -v -f test $1 $2 $3 $4 $5 $6 $7 $8 $9
# Linux does not sort files by filename and discover fails to find sessions in right order.
# This is a bug fixed in 3.x
