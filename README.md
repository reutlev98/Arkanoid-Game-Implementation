
# Arkanoid-Game

Welcome to the **Arkanoid-Game**, a classic arcade experience recreated in Java! This project was developed as part of an **Object-Oriented Programming** course at **Bar-Ilan University**. Dive into the excitement of breaking blocks and advancing through challenging levels while exploring key programming concepts.

## Overview

This game is a Java-based implementation of **Arkanoid**, focusing on object-oriented principles like inheritance, encapsulation, and design patterns. Players navigate through multiple levels with the goal of clearing all the bricks on the screen using a paddle and a bouncing ball.

## How to Run

1. **Compile** all Java source files:
    ```bash
    javac *.java
    ```
2. **Run** the game with default levels:
    ```bash
    java Arkanoid
    ```
3. **Custom Level Order**: To specify the sequence of levels, include them as arguments:
    ```bash
    java Arkanoid 2 4 1 3
    ```
   The game will follow the order: 2, 4, 1, 3.

## Controls

- **Left Arrow**: Move the paddle left.
- **Right Arrow**: Move the paddle right.
- **P**: Pause or resume gameplay.
- **Q**: Quit the game.

Your goal is to keep the ball from falling below the paddle while clearing all blocks to proceed. Watch out, losing all lives means game over!

## Project Structure

- **code/**: Main directory containing the source and compiled files.
  - **src/**: Contains Java source code for game logic and classes.
  - **bin/**: Directory for compiled Java bytecode files.
- **biuoop/**: Contains files related to the **biuoop** library, which is used for handling user input and graphics.
- **build/**: Includes build files and scripts for compiling the project.

## Design Principles

The game is built around key object-oriented programming concepts:

- **Encapsulation**: Ensures that game state, like scores and player lives, is managed through specific methods.
- **Polymorphism**: Enables flexible collision handling between the ball, paddle, and different types of blocks.
- **Design Patterns**:
  - **Factory Pattern**: Generates levels dynamically based on user input.
  - **Observer Pattern**: Manages updates to game elements like score and remaining blocks.

## Challenges & Solutions

- **Collision Management**: Fine-tuned the collision detection system for smooth interaction between objects.
- **User-defined Levels**: Implemented a system to load levels in user-defined order using command-line arguments.
- **Game Performance**: Optimized rendering and event handling for responsive gameplay.

## Game Demo

![רעות לב's Video - Sep 4, 2024](https://github.com/user-attachments/assets/24e3f6cd-ee0d-458a-9e9a-b074eee8c855)

## Acknowledgments

This game is inspired by the original **Arkanoid** arcade game. This project was developed as part of an Object-Oriented Programming course at Bar-Ilan University


