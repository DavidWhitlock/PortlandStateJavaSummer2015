package edu.pdx.cs410J.minesweeper.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.Label;

public class GameScreen extends Composite {

  private final Label message;

  public GameScreen() {
    DockPanel gameScreen = new DockPanel();
    gameScreen.add(new Label("Click on a cell to probe it"), DockPanel.NORTH);
    message = new Label();
    gameScreen.add(message, DockPanel.SOUTH);

    initWidget(gameScreen);
  }

  public void displayGameState(GameState gameState) {
    message.setText("Game with a " + gameState.getNumberOfRows() + " x " + gameState.getNumberOfColumns() + "grid");
  }
}
