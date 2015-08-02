package edu.pdx.cs410J.minesweeper;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MinesweeperGameTest {
  @Test
  public void testProbeOneByOneGridWinsGame() {
    MinesweeperGame.MineGameGenerator generator = new MinesweeperGame.MineGameGenerator() {
      @Override
      public char getCharAt(int row, int column) {
        return '.';
      }
    };
    MinesweeperGame game = new MinesweeperGame(1, 1, generator);
    GameState result = game.probe(0, 0);
    assertThat(result.getCharAt(0, 0), equalTo(' '));
    assertThat(result.isGameWon(), equalTo(true));
  }
}
