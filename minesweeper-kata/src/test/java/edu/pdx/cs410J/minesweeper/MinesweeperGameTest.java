package edu.pdx.cs410J.minesweeper;

import edu.pdx.cs410J.minesweeper.MinesweeperGame.MineGameGenerator;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MinesweeperGameTest {
  @Test
  public void probeEmpty1x1GridWinsGame() {
    MineGameGenerator generator = buildMineGameGenerator(".");
    int numberOfRows = 1;
    int numberOfColumns = 1;
    MinesweeperGame game = new MinesweeperGame(numberOfRows, numberOfColumns, generator);

    GameState result = game.probe(0, 0);
    assertThat(result.getNumberOfRows(), equalTo(numberOfRows));
    assertThat(result.getNumberOfColumns(), equalTo(numberOfColumns));
    assertThat(result.getCharAt(0, 0), equalTo(' '));
    assertThat(result.getGameResult(), equalTo(GameState.GameResult.WON));
  }

  @Test
  public void probe1x1GridWithBombLosesGame() {
    MineGameGenerator generator = buildMineGameGenerator("*");
    MinesweeperGame game = new MinesweeperGame(1, 1, generator);

    GameState result = game.probe(0, 0);
    assertThat(result.getCharAt(0, 0), equalTo('*'));
    assertThat(result.getGameResult(), equalTo(GameState.GameResult.LOST));
  }

  private MineGameGenerator buildMineGameGenerator(String... rows) {
    return (row, column) -> rows[row].charAt(column);
  }
}
