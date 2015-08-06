package edu.pdx.cs410J.minesweeper.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import edu.pdx.cs410J.minesweeper.client.GameState;
import edu.pdx.cs410J.minesweeper.MinesweeperGame;
import edu.pdx.cs410J.minesweeper.RandomMinesweeperGameGenerator;
import edu.pdx.cs410J.minesweeper.client.MinesweeperGameService;

/**
 * The server-side implementation of the Phone Bill service
 */
public class MinesweeperGameServiceImpl extends RemoteServiceServlet implements MinesweeperGameService
{

  private MinesweeperGame game;

  @Override
  public GameState createMinesweeperGame(int rows, int columns) {
    game = new MinesweeperGame(rows, columns, new RandomMinesweeperGameGenerator());
    return game.probe(-1, -1);
  }

  @Override
  public GameState probe(int row, int column) {
    return game.probe(row, column);
  }

  /**
   * Log unhandled exceptions to standard error
   *
   * @param unhandled
   *        The exception that wasn't handled
   */
  @Override
  protected void doUnexpectedFailure(Throwable unhandled) {
    unhandled.printStackTrace(System.err);
    super.doUnexpectedFailure(unhandled);
  }
}
