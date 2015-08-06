package edu.pdx.cs410J.minesweeper.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The client-side interface to the createMinesweeperGame service
 */
public interface MinesweeperGameServiceAsync {

  void createMinesweeperGame(int rows, int columns, AsyncCallback<GameState> async);

  void probe(int row, int column, AsyncCallback<GameState> callback);
}
