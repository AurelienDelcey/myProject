# Tic Tac Toe – JavaFX

A simple Tic Tac Toe game developed in Java using JavaFX.  
This project was created as a learning exercise to practice JavaFX, application architecture, and state management.

---

## 🎮 Features

- Two-player Tic Tac Toe (O vs X)
- Graphical interface using JavaFX
- Game state detection:
  - Win (rows, columns, diagonals)
  - Draw
- Reset button to start a new game
- Reactive UI using observable properties

---

## 🧠 Architecture Overview

The project follows a clear separation of concerns:

### UI Layer
- **UserInterface**  
  Handles JavaFX components and user interactions.

### Game Logic
- **TicTacToeLogic**  
  Contains all game rules and win/draw detection.

### State Management
- **GameStateHolder**
- **TurnStateHolder**  
  Uses JavaFX observable properties to notify the UI of state changes.

### Data Model
- **Grid**
- **ButtonState**
- **GameState**
- **Turn**

This structure ensures that the game logic is fully independent from the UI.

---

## ▶️ How to Run

1. Make sure you have **Java 17+** installed
2. Make sure **JavaFX** is properly configured
3. Run the main class:

---

## 🧰 Technologies Used

- Java
- JavaFX
- Java Streams
- JavaFX Properties (Observable Pattern)

---

## 🎯 Learning Objectives

This project focuses on:

- JavaFX event-driven programming
- Separation of UI and business logic
- State-driven application design
- Clean and maintainable code structure

---

## 📌 Future Improvements

- Add unit tests for game logic
- Add single-player mode (AI)

---

## 👤 Author

Aurélien
