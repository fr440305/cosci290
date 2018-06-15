#!/bin/sh

javac ./*.java
# Test:
java TestZombieBoss
java TestPlayer
#java Main
# clean:
rm ./*.class
rm ./*.swp
