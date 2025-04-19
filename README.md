# Red-Black Tree Dictionary (Java)

This is a simple Java console application that implements a dictionary using a Red-Black Tree (self-balancing binary search tree). It allows users to load a list of words from a file, search for words, insert new words, and view tree metrics such as black height, total size, and height.

---

## Features

- Load dictionary words from `Dictionary.txt`
- Insert new words (avoids duplicates)
- Search for words
- Print tree statistics:
  - Black Height
  - Total Size
  - Tree Height
- Uses a Red-Black Tree for efficient insert/search operations

---

## File Structure

- `Main.java` - Main class for user interaction and menu handling
- `RBTree.java` - Contains the Red-Black Tree implementation
- `Node.java` - Represents nodes in the Red-Black Tree
- `Dictionary.txt` - External file used to load and update dictionary data

---

## How to Run

1. Make sure `Dictionary.txt` is in the same directory as your `.java` files.
2. Compile the Java files:
   ```bash
   javac Main.java RBTree.java Node.java
