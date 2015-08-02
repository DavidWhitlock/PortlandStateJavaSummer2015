package edu.pdx.cs410J.minesweeper;

import edu.pdx.cs410J.minesweeper.MinesweeperGame.MineGameGenerator;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MinesweeperGameTest {
  @Test
  public void testProbeOneByOneGridWinsGame() {
    MineGameGenerator generator = buildMineGameGenerator(".");
    MinesweeperGame game = new MinesweeperGame(1, 1, generator);

    GameState result = game.probe(0, 0);
    assertThat(result.getCharAt(0, 0), equalTo(' '));
    assertThat(result.isGameWon(), equalTo(true));
  }

  private MineGameGenerator buildMineGameGenerator(String... rows) {
    return (row, column) -> rows[row].charAt(column);
  }
}
