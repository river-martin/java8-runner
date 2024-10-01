# java8-runner

Runs the Java 8 regex matcher and prints the match information in TOML format.

## Install dependencies

```Bash
sudo apt install openjdk-8-jdk-headless
```

Create a symbolic links to `java` and `javac`, named `java8` and `javac8`. The commands below should show you where they are.

```Bash
update-alternatives --list java
update-alternatives --list javac
```

Now that you know where they are, create the symbolic links, as shown below.

```Bash
sudo ln -s path/to/java /usr/local/bin/java8
sudo ln -s path/to/javac /usr/local/bin/javac8
```

## Build

```bash
make
```

## Run

```bash
java8 Java8Runner "(a|b)*" "abaaba"
```
