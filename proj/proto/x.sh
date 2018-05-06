#!/bin/bash

set -eu

javac ./*.java

java Main

rm ./*.class
