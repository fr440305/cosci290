# Cosci290 Group 4

- labo
- work
- custom
- note
- proj
- util

## Text Adventure

/proj/proto/x.sh

## Midterm (Done. See labo/11)


## Lab (labo)

- 22
- x1 0-00 Iterate a matrix by recursion.
- 17, 18, 19, 20 Text adventure
- 16 4-30 Absent
- 15 4-24
- 14 4-19
- 13 4-17
- 12
- 11 Midterm
- 10 3-20
- 9
- 8
- 7
- 6
- 5
- 4
- 3
- 2
- 1
### 22

1. Create an abstract class called Undead that has the following instance variables:
    - health
    - experience
    - name

Be sure to include appropriate constructors and
other functions (getters/setters/toString) for the Undead class. 

The Undead class has an abstract method called attack
that simply prints out how the object attacks.

2. Create a subclass of Undead called UndeadMage that has the following instance variables:
    - spellOne
    - spellTwo
    
Be sure to include appropriate constructors and other functions (getters/setters/toString) for UneadMage class. 

3. Create a subclass Undead called UndeadWarrior that has the following instance variables:
    - rightHandWeapon
    - leftHandWeapon

Be sure to include appropriate constructors and other functions (getters/setters/toString) for UneadMage class. 

4. Create a runner/driver/tester class that randomly generates
either an UndeadMage object or an UndeadWarrior object
and then adds the new object to an array list of Undead.
Then loop through the array list of Undead and call the attack method for each object.

Work on text adventure!

### 16 (Absent)

Let's spend today making progress on our text adventures. Your text adventure should have the following specifications:

- At least an opening and a closing splash screen
- A strong storyline that is outlined in a text file and read using file I/O
- User input interaction with the story
- User input saved to a file
- Saved user info read from a file
- Using Math.random() for scenarios that require a probability/decision 
- A utility/tool class that holds support methods unrelated to objects
- (required for teams that have members in group 3 or 4):
    - Custom classes that holds data of your objects in your text adventure 
    - A multidimensional array that acts as a map 

### 15 (Done. See labo/15)

Let's play around with multi-dimensional arrays!
Refer to the textbook PDF chapter 8 for this.

Create a test program that instantiates
a 5 by 5 multi-dimensional array of integers.
Randomly assign random values to each index.
Make sure to do this with a loop and by calling
a custom method that returns a random value.
Then print out each value in the array using a loop.

### 14 (Done but not good. See proj/xq/Store.java)

Using the same techniques on Tuesday's lab,
compile and run "TestWriteFile.java",
which can be found here:
https://github.com/agenttuy/cosci290/blob/master/lab/TestWriteFile.java
(Links to an external site.)Links to an external site.

Copy the code into your Utility class.
Be sure to modify the code so that it is a reusable custom method.
Use this method in your `GameDriver.java` to write/save info asked by the user.
Think of information that you might want to save for the user of your text adventure.

### 13 (Done before the class begin. See /proj/xq)

Based on the today's demo your lab requirements are:

- Create a Utility class that has all your custom methods that are not related to an object.
- In this Utility class, have a custom method that can read a text file. This text file will hold all of your story lines.
- Refactor your GameDriver.java so that there are no longer any string literals.
- Create a custom SplashScreen class that houses all your different ASCII art or splash screens.

Plus 2 points if done by the end of class, otherwise, due by tonight at 11:59PM.

### 12 (Done)

Directions:

1. This application has bugs. Edit my code so that the program compiles and runs.
2. Comment every line of code.
3. Add code or modify the code so that the following output is achieved:

<pre>
	        *
	      * * * 
	    * * * * *
	  * * * * * * *
	* * * * * * * * *
	  * * * * * * *
	    * * * * *
	      * * *
	        *
          
  * * * * *
	  * * * * 
	    * * * 
	      * * 
	        *
</pre>

4. Fix the indentation of the code. 

Note: Clean java code has:

- proper indentation
- variable declaration at the beginning of the program
- class name starts with a capital comments that explains the logic

### 11 (Midterm)

You are responsible for knowing the topics listed for
GROUP 1, 2, and 3 above including the following topics:

Creating a custom class/object based on given
specifications/instructions
All custom classes/objects must have at least the following:

- class attributes that are private
- a zero-argument constructor that gives default values to class attributes
- getters and setters for each class attribute
- a toString method that displays each attributes

Lab:

Create a custom class called Person with the following attributes

- First Name
- Last Name
- Age
- Gender

Create a subclass of Person called Student with the following attributes

- Major
- GPA
- List of names of classes

Create a test program/class that has a list of 5 Student
objects and prints out each student information
including their name, age, and gender.

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

### 7 (Done. See custom/*)

Create custom classes for members in group 3.
Create a folder called "custom" and put custom
classes created for other students in this folder.

For each custom class, include in a block comment
at the beginning of the class that you are the
author and for which student/group the custom class
is created for.

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

### 5

Set the text adventure into an eclipse project.

Install git plugin into eclipse.

Begin to write some self-defined classes.

### 4

Do the questions in the codingbat.com.

### 3

Use if statment to do something.

### 2

Use Scanner to do something.

### 1 (Done)

Print a cool-style text.

## Homework (work)

- 1
- 2
- 3 3-22 23:59

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

### 3

Get to at least 25 points in Codewars.

In your documentation.txt file:

write a short summary of what your game is about.
Title this section "Summary".
In the section where you listed out objects
for your text adventure for HW2, title this
section "Objects Used".

No other homework until I give feedback for
your text adventure,
in which you will refactor your code.
