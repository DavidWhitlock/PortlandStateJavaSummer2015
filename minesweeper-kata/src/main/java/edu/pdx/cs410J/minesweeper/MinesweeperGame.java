package edu.pdx.cs410J.minesweeper;

import static edu.pdx.cs410J.minesweeper.GameState.GameResult.IN_PROGRESS;
import static edu.pdx.cs410J.minesweeper.GameState.GameResult.LOST;
import static edu.pdx.cs410J.minesweeper.GameState.GameResult.WON;

public class MinesweeperGame {

  private final GameState gameState;
  private final MineFieldWithHints mineFieldWithHints;

  public MinesweeperGame(int rows, int columns, MineGameGenerator mineGameGenerator) {
    this.gameState = new GameState(rows, columns);
    this.mineFieldWithHints = createMineFieldWithHints(rows, columns, mineGameGenerator);
  }

  private MineFieldWithHints createMineFieldWithHints(int rows, int columns, MineGameGenerator generator) {
    MineField field = new MineField(rows, columns);
    for (int row = 0 ; row < rows; row++) {
      StringBuilder line = new StringBuilder();
      for (int column = 0; column < columns; column++) {
        line.append(generator.getCharAt(row, column));
      }
      field.addRow(line.toString());
    }
    return field.getHints();
  }

  public GameState probe(int row, int column) {
    if (rowAndColumnAreInBounds(row, column)) {
      char cell = mineFieldWithHints.getCharAt(row, column);

      if (cell == '0') {
        if (this.gameState.getCharAt(row, column) != ' ') {
          this.gameState.setCharAt(row, column, ' ');
          probeAllAround(row, column);
        }

      } else {
        this.gameState.setCharAt(row, column, cell);
      }

      if (cell == '*') {
        this.gameState.setGameResult(LOST);


      } else if (onlyMinesRemainUnprobed()) {
        this.gameState.setGameResult(WON);

      } else {
        this.gameState.setGameResult(IN_PROGRESS);
      }
    }

    return this.gameState;
  }

  private void probeAllAround(int row, int column) {
    for (int r = row - 1; r <= row + 1; r++) {
      for (int c = column - 1; c <= column + 1; c++) {
        if (!(r == row && c == column)) {
          probe(r, c);
        }
      }
    }

  }

  private boolean rowAndColumnAreInBounds(int row, int column) {
    return row >= 0 && column >= 0 && row < gameState.getNumberOfRows() && column < gameState.getNumberOfColumns();
  }

  private boolean onlyMinesRemainUnprobed() {
    for (int row = 0; row < gameState.getNumberOfRows(); row++) {
      for (int column = 0; column < gameState.getNumberOfColumns(); column++) {
        char gameCell = gameState.getCharAt(row, column);
        char hintCell = mineFieldWithHints.getCharAt(row, column);
        if (gameCell == '?' && hintCell != '*') {
          return false;
        }
      }
    }

    return true;
  }

  public GameState.GameResult getGameResult() {
    return this.gameState.getGameResult();
  }

  interface MineGameGenerator {

    char getCharAt(int row, int column);
  }
}
