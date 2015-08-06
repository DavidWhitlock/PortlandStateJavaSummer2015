package edu.pdx.cs410J.minesweeper.client;

import java.io.Serializable;

import static edu.pdx.cs410J.minesweeper.client.GameState.GameResult.IN_PROGRESS;

public class GameState implements Serializable {
  private int numberOfRows;
  private int numberOfColumns;
  private char[][] grid;
  private GameResult gameResult;

  public GameState() {

  }

  public GameState(int numberOfRows, int numberOfColumns) {
    this.numberOfRows = numberOfRows;
    this.numberOfColumns = numberOfColumns;
    this.gameResult = IN_PROGRESS;
    this.grid = createMatrixWithQuestionMarks(numberOfRows, numberOfColumns);
  }

  private char[][] createMatrixWithQuestionMarks(int numberOfRows, int numberOfColumns) {
    char[][] matrix = new char[numberOfRows][numberOfColumns];
    for (int i = 0; i < numberOfRows; i++) {
      for (int j = 0; j < numberOfColumns; j++) {
        matrix[i][j] = '?';
      }
    }

    return matrix;
  }

  public char getCharAt(int row, int column) {
    return this.grid[row][column];
  }

  public GameResult getGameResult() {
    return gameResult;
  }

  public int getNumberOfRows() {
    return numberOfRows;
  }

  public int getNumberOfColumns() {
    return numberOfColumns;
  }

  public void setCharAt(int row, int column, char cell) {
    this.grid[row][column] = cell;
  }

  public void setGameResult(GameResult gameResult) {
    this.gameResult = gameResult;
  }

  public enum GameResult {
    LOST, IN_PROGRESS, WON

  }
}
