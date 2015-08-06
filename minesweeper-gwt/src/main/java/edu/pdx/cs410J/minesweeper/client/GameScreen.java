package edu.pdx.cs410J.minesweeper.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.Label;

public class GameScreen extends Composite {

  public GameScreen() {
    DockPanel gameScreen = new DockPanel();
    gameScreen.add(new Label("Click on a cell to probe it"), DockPanel.NORTH);
    gameScreen.add(new Label("Game Status information goes here"), DockPanel.SOUTH);

    initWidget(gameScreen);
  }
}
