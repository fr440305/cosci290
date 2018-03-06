#!/bin/sh

javac ./*.java
# Test:
java TestZombie
java TestPlayer
#java Main
# clean:
rm ./*.class
rm ./*.swp
