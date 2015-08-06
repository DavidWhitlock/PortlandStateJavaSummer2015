package edu.pdx.cs410J.minesweeper;

import java.util.Random;

public class RandomMinesweeperGameGenerator implements MinesweeperGame.MineGameGenerator {

  private final Random random = new Random();

  @Override
  public char getCharAt(int row, int column) {
    return random.nextInt(8) == 0 ? '*' : '.';
  }
}
