#!/bin/bash

set -eu

javac ./*.java

java TestStudent $@ || true

rm ./*.class
