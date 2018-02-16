# Commit and update automatically
This tutorial is about how to push your code to GitHub within one command.

This tutorial is an extension of this course.  It will teach you some tricks about how to manage your git repo more effictive, such as writing bash script to push the codes to remote repo.

So, let us start.

```sh
cd ~
mkdir ./bin
cd ./bin
echo "" > ./cs290update
chmod 755 ./cs290update
```

The commands above will create a new file `cs290update` in ~/bin directory. This directory is one of
the `PATH` directory.

Then, edit this file by using any command-line text editor you want. Here we will use `vim`.

```sh
vim ./cs290update
```

And add the following scripts into this file.

```sh
git --git-dir=$HOME/workspace/.git --work-tree=$HOME/workspace add --all
git --git-dir=$HOME/workspace/.git --work-tree=$HOME/workspace commit -m "auto commit"
git --git-dir=$HOME/workspace/.git --work-tree=$HOME/workspace push origin master
```

Here we make many assumptions of your configureations:
- your git repo is embedded in ~/workspace
- the reference of your remote repo in your local repo is called `origin`
- the `$HOME` environment variable is setting corrent.
and so on. If any of these assumption for you is false then this tutorial will not work for you.
But you can surely ask the instructor for help.

So far so good. Now you only need to type `cs290update`, then all the codes will be automatically
commited and pushed.
