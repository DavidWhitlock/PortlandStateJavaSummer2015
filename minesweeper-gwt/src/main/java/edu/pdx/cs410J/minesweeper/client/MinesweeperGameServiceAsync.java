package edu.pdx.cs410J.minesweeper.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import edu.pdx.cs410J.minesweeper.GameState;

/**
 * The client-side interface to the createMinesweeperGame service
 */
public interface MinesweeperGameServiceAsync {

  void createMinesweeperGame(int rows, int columns, AsyncCallback<GameState> async);
}
