package edu.pdx.cs410J.minesweeper;

public class MinesweeperGame {

  public MinesweeperGame(int rows, int columns, MineGameGenerator mineGameGenerator) {


  }

  public GameState probe(int row, int column) {
    return new GameState();
  }

  interface MineGameGenerator {

    char getCharAt(int row, int column);
  }
}
