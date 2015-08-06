package edu.pdx.cs410J.minesweeper.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * A GWT remote service that returns a dummy Phone Bill
 */
@RemoteServiceRelativePath("ping")
public interface MinesweeperGameService extends RemoteService {

  GameState createMinesweeperGame(int rows, int columns);

}
