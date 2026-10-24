# Minesweeper

A terminal-based Minesweeper game written in **Java**.

This is one of my first Java projects, built mainly to practice **object-oriented programming, arrays, recursion, classes, and basic project structure**.

## About

The game is played directly in the terminal.

The player can:

- Reveal cells
- Place and remove flags
- Avoid mines
- Reveal safe areas recursively
- Win by correctly identifying all mines

The board is displayed using ASCII characters, with row and column numbers for navigation.

## Features

- Customizable board size
- Randomly generated mines
- First-click mine protection
- Flagging system
- Recursive cell revealing
- Mine counter
- Win condition detection
- Terminal-based interface
- Simple menu system

## How to Play

When the game starts, choose:

```text
1. Play
2. Exit
```

During the game, enter:

```text
row column action
```

Where the action is:

```text
R = Reveal
F = Flag / Unflag
```

For example:

```text
3 5 R
```

reveals the cell at row `3`, column `5`.

And:

```text
3 5 F
```

places or removes a flag.

## Technologies

- **Java**
- Java Collections / standard library
- Object-Oriented Programming
- Recursion
- 2D Arrays
- Random number generation

## Project Structure

```text
Minesweeper/
├── src/
│   ├── Main.java
│   ├── Board.java
│   └── Cell.java
├── lib/
└── README.md
```

## Running the Game

Make sure Java is installed on your machine.

Compile the source files:

```bash
javac src/*.java
```

Then run the program:

```bash
java -cp src Main
```

## Why I Made This

I built this project while learning Java and object-oriented programming.

Rather than following a complete Minesweeper tutorial, I wanted to figure out the game logic myself and use the project to understand how different classes and methods interact.

It started as a simple idea and gradually grew into a working terminal game.

## Status

**Playable**

This project is primarily a learning project, so the code and design may evolve as I improve my Java skills.

---

Made with Java while learning and experimenting.