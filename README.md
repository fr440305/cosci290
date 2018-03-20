# Cosci290 Group 4

- custom
- labo
- note
- proj
- work
- util

## Homework (work)

- 1
- 2

### 1 (Done)

See https://github.com/agenttuy/cosci290/blob/master/HW/HW1Demo.java

Create a class called "GameDriver" and
save/name the file "GameDriver.java".

The program shold start up with your
text aventure splash screen (it would 
be a good idea to use the one from Lab 1).

Next, the program should have a print out
of some storytelling that starts
the text adventure.

Then set up the game with questions
asked from the user to start the text
adventure (use same questions from Lab 2).
TIP: Use Math.random and if-else to
randomize elements in the game based on user input. 

When the game is over,
end the program with a "GAME OVER" message.

### 2 (Done. See work/2/Documentation.txt)

Get to at least 15 points in Codewars.

Write a list of objects/classes you would
use in your text adventure. 
For example, if you were writing
a Zombie-based adventure, your list
of objects could be: Zombie, Weapon,
Food, etc.

Turn this in as a text file called
Documentation and push it to your github.

## Lab (labo)

- 1
- 2
- 3
- 4
- 5
- 6
- 7
- 8
- 9
- 10 3-20

### 1 (Done)

Print a cool-style text.

### 2

Use Scanner to do something.

### 3

Use if statment to do something.

### 4

Do the questions in the codingbat.com.

### 5

Set the text adventure into an eclipse project.

Install git plugin into eclipse.

Begin to write some self-defined classes.

### 6

Test your custom class developed in
last week's lab. Test this class in
another class with main method.
Name this test class accordingly.
For example, if your custom class/object
was Zombie, then call this class TestZombie.

Think of another class/object for your
text adventure that may require the use
of inheritance. For example, your text
adventure could have different kinds of
zombies. Think of the Zombie class as a
general Zombie class that maybe ZombieCat
might extend from. ZombieCat would be a
subclass to Zombie class and inherit all
of its properties and methods.
Write a custom subclass that follows
this concept.

Please also write a test class for
this subclass.

Look at Student.java and TestStudent.java in:
https://github.com/agenttuy/cosci290/tree/master/group4

### 7 (Done. See custom/*)

Create custom classes for members in group 3.
Create a folder called "custom" and put custom
classes created for other students in this folder.

For each custom class, include in a block comment
at the beginning of the class that you are the
author and for which student/group the custom class
is created for.

### 8 (Done. See work/2/Documentation.txt or proj/README)

Relates to note/mar13.

Using UML graphical notation,
draw a chart that organizes your current
objects in your text adventure. Please
include potential objects when considering
the current design of your classes. 

Use Microsoft Word or a UML designer to produce
the graphics. Please append the graphics to
your documentation.txt file and push to GitHub.

### 9 (Done. See proj/{Obj*, Zombie*, Main})

Create a superclass that all of your objects in your
text adventure will extend to and name it accordingly
for your text adventure. The only attribute this class
should have is private int id with matching mutators
and accessors that your subclasses will inherit.

In a test class, create an ArrayList of that object
type and instantiate at least one object of every
concrete class you have in your game.

Add these subclasses to your ArrayList.
Set some properties for each class.
Then loop through the ArrayList and print out
info on each object.

### 10 (Done. See proj/\* for 1 and labo/10/\* for 2 and 3.)

1. In your text adventure,
replace all arrays with ArrayLists.

2. Also, do problem in the book
to review programming concepts: 

7.8 (Average an array) Write
two overloaded methods that return
the average of an array with
the following headers:

```
public static int average(int[] array)
public static double average(double[] array)
```
 
Write a test program that prompts the user
to enter ten double values,
invokes this method, and displays the average value.

3. Watch demo on getting arguments from the command line.
Alter the above problem to take in arguments from
the command line instead and use ArrayLists
instead of arrays.
