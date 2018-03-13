# Four relationships between two classes

Relates to lab 8.

- `has-a` and `is-a`
- The four types of relationship are derived from has-a and is-a

## Has-a and Is-a

Basically, there are only *two* relationships, namely:

- `has` or `has-a`
- `am/is/are` or `is-a`

### Has-a relationship

Examples:

1. A person `has a` name. `person <>- name`

2. A person `has a` brain. `person <>- brain`

3. A name `has` alphabets. In this example, there are more than
two objects, because usually there are more than one character
in a name. But there are only two classes in this example:
name and character. So we can write: `name <>- char`.

Note that there are several types of `has-a` relation ship.
Example 1 and 2 are one-to-one while example 3 is one-to-more.

### Is-a relationship

Examples:

1. People are animals. `person <<- animal`

2. animals are creatures(life). `animal <<- life`

Not an example:

1. I am a person. `I` is not a type, it is an instance.

2. Love is war. This is not an is-a relationship. This is just a metaphor, because love is not really a war.

## The four types of relationship are derived from has-a and is-a:

- Association: general type
  - Aggregation: one type of `has-a`. one -one ownership.
  - Composition: one type of `has-a`. one-to-more ownership.
  - Inheritance: one type of `is-a`. Between two java classes.

For each relation above, we need to know:

- Definition.
- Examples.
- UML from.(Important)
- Difference among other types of relationship.

