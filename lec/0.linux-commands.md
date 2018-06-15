# Linux cammands for this course

- Git related.
  - initialized
  - remote settings
  - pre-push
  - push
- compiled and run java files.
  - compile
  - run

## Git related

### Init

```sh
git init
git config --local user.name your_name
git config --local user.email your_email@whatever.com
```

### Remote

Check the name of the GitHub repo inside this local repo:

```sh
git remote -v
```

`-v` for verbose.  The result is usually be `origin`, but if your result
is not, do not panic.

### Pre-push

One of the most fast way:
```sh
git add --all
git commit -m "shit"
```

But please try your best not to do this, especially for that commit message.
If you do not know the better way to doing this, or you do not know what is not
good for the way shown above, please ask teacher since this is just my personal notes.

### Push

There are two ways to doing this.

#### 1

First you need to **pull** the codes fromm github to avoid confilcts.

```sh
git pull origin master
```

Then push it.
```sh
git push origin master
```

#### 2

```sh
git push -f origin master
```

Warning: use `-f` option is super dangerous.

## On java

### Single file

Suppose that you wanna compile `A.java`.

```sh
javac A.java

# fix error if any

java A # no dot-java extension
```

### Multifiles

Suppose that `A.java`, `B.java`, `C.java`, and the `main` method is inside `A.java`.

```sh
javac ./A.java ./B.java ./C.java
java A # since main method is inside class A
```







