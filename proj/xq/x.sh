#!/bin/bash

set -eu

# build:--
javac ./*.java

# run:--
java Main || true

# clean:--
rm ./*.class
