package edu.pdx.cs410J.minesweeper;

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
    char cell = mineFieldWithHints.getCharAt(row, column);

    if (cell == '0') {
      this.gameState.setCharAt(row, column, ' ');

    } else {
      this.gameState.setCharAt(row, column, cell);
    }

    if (cell == '*') {
      this.gameState.setGameResult(LOST);

    } else {
      this.gameState.setGameResult(WON);
    }

    return this.gameState;
  }

  interface MineGameGenerator {

    char getCharAt(int row, int column);
  }
}
