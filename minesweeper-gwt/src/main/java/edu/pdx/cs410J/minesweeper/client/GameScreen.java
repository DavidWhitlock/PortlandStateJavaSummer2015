package edu.pdx.cs410J.minesweeper.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;

public class GameScreen extends Composite {

  private final Label message;
  private final Grid grid;

  public GameScreen() {
    DockPanel gameScreen = new DockPanel();
    gameScreen.add(new Label("Click on a cell to probe it"), DockPanel.NORTH);
    message = new Label();
    gameScreen.add(message, DockPanel.SOUTH);

    grid = new Grid(0, 0);
    gameScreen.add(grid, DockPanel.CENTER);

    initWidget(gameScreen);
  }

  public void displayGameState(GameState gameState) {
    message.setText("Game with a " + gameState.getNumberOfRows() + " x " + gameState.getNumberOfColumns() + " grid");

    for (int row = 0; row < this.grid.getRowCount(); row++) {
      for (int column = 0; column < this.grid.getColumnCount(); column++) {
        Label label = (Label) this.grid.getWidget(row, column);
        label.setText(String.valueOf(gameState.getCharAt(row, column)));
      }
    }
  }

  public void setGridSize(int numberOfRows, int numberOfColumns) {
    grid.resize(numberOfRows, numberOfColumns);

    for (int row = 0; row < numberOfRows; row++) {
      for (int column = 0; column < numberOfColumns; column++) {
        grid.setWidget(row, column, new Label());
      }
    }

  }
}
