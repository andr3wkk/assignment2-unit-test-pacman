# Assignment 2: 3-Level Pac-Man Game

This project is a logic-based Pac-Man game implemented in Java for Assignment 2.

## Levels
- **Level 1:** Pac-Man collects coins. No monsters are present.
- **Level 2:** Monsters are added, so the player must avoid them while collecting coins.
- **Level 3:** More monsters are added, and a health pack can restore lives.

## Technologies
- Java 17
- Gradle
- JUnit 5
- JaCoCo

## Project Structure
- `src/main/java/com/example/pacman` - game logic
- `src/test/java/com/example/pacman` - unit tests
- `docs` - AI usage note and test analysis
- `screenshots` - Gradle and JaCoCo screenshots

## Running Tests
```bash
./gradlew test