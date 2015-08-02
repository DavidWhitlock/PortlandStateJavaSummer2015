package edu.pdx.cs410J.minesweeper;

import edu.pdx.cs410J.minesweeper.MinesweeperGame.MineGameGenerator;
import org.junit.Test;

import static edu.pdx.cs410J.minesweeper.GameState.GameResult.IN_PROGRESS;
import static edu.pdx.cs410J.minesweeper.GameState.GameResult.LOST;
import static edu.pdx.cs410J.minesweeper.GameState.GameResult.WON;
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
    assertThat(result.getGameResult(), equalTo(WON));
  }

  @Test
  public void probe1x1GridWithBombLosesGame() {
    MineGameGenerator generator = buildMineGameGenerator("*");
    MinesweeperGame game = new MinesweeperGame(1, 1, generator);

    GameState result = game.probe(0, 0);
    assertThat(result.getCharAt(0, 0), equalTo('*'));
    assertThat(result.getGameResult(), equalTo(LOST));
  }

  private MineGameGenerator buildMineGameGenerator(String... rows) {
    return (row, column) -> rows[row].charAt(column);
  }

  @Test
  public void probeFull3x3GridReveals8AndOtherCellsAreQuestionMarks() {
    MineGameGenerator generator = buildMineGameGenerator("***", "*.*", "***");
    MinesweeperGame game = new MinesweeperGame(3, 3, generator);

    GameState result = game.probe(1, 1);
    assertThat(result.getCharAt(0, 0), equalTo('?'));
    assertThat(result.getCharAt(0, 1), equalTo('?'));
    assertThat(result.getCharAt(0, 2), equalTo('?'));
    assertThat(result.getCharAt(1, 0), equalTo('?'));
    assertThat(result.getCharAt(1, 1), equalTo('8'));
    assertThat(result.getCharAt(1, 2), equalTo('?'));
    assertThat(result.getCharAt(2, 0), equalTo('?'));
    assertThat(result.getCharAt(2, 1), equalTo('?'));
    assertThat(result.getCharAt(2, 2), equalTo('?'));
  }

  @Test
  public void probe2x2GridWithMinesInCornersReveals2AndGameIsStillInProgress() {
    MineGameGenerator generator = buildMineGameGenerator("*.", ".*");
    MinesweeperGame game = new MinesweeperGame(2, 2, generator);

    GameState result = game.probe(1, 0);
    assertThat(result.getCharAt(0, 0), equalTo('?'));
    assertThat(result.getCharAt(0, 1), equalTo('?'));
    assertThat(result.getCharAt(1, 0), equalTo('2'));
    assertThat(result.getCharAt(1, 1), equalTo('?'));

    assertThat(result.getGameResult(), equalTo(IN_PROGRESS));
  }

  @Test
  public void whenOnlyUnprobedMinesRemainGameIsWon() {
    MineGameGenerator generator = buildMineGameGenerator("***", "*.*", "***");
    MinesweeperGame game = new MinesweeperGame(3, 3, generator);

    GameState result = game.probe(1, 1);
    assertThat(result.getGameResult(), equalTo(WON));
  }

}
