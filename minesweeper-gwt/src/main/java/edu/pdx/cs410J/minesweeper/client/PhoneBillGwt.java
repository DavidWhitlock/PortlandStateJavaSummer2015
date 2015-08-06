package edu.pdx.cs410J.minesweeper.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DeckPanel;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * A basic GWT class that makes sure that we can send an Phone Bill back from the server
 */
public class PhoneBillGwt implements EntryPoint {

  static final int GAME_SCREEN = 1;
  static final int START_SCREEN = 0;
  private DeckPanel gamePanels;
  private MinesweeperGameServiceAsync service;
  private GameScreen gameScreen;

  @Override
  public void onModuleLoad() {
    this.service = GWT.create(MinesweeperGameService.class);

    gamePanels = new DeckPanel();
    gamePanels.add(createStartScreen());
    gamePanels.add(createGameScreen());

    RootPanel rootPanel = RootPanel.get();
    rootPanel.add(gamePanels);
    gamePanels.showWidget(START_SCREEN);
  }

  private GameScreen createGameScreen() {
    gameScreen = new GameScreen();
    return gameScreen;
  }

  private StartScreen createStartScreen() {
    StartScreen startScreen = new StartScreen();
    startScreen.addValidGameDimensionsListener(new StartScreen.ValidGameDimensionsListener() {
      @Override
      public void validGameDimensions(int rows, int columns) {
        Window.alert("Creating a new " + rows + " x " + columns + " game");

        service.createMinesweeperGame(rows, columns, new AsyncCallback<GameState>() {
          @Override
          public void onFailure(Throwable throwable) {
            Window.alert(throwable.getMessage());
          }

          @Override
          public void onSuccess(GameState gameState) {
            gameScreen.displayGameState(gameState);
            gamePanels.showWidget(GAME_SCREEN);
          }

        });
      }
    });
    return startScreen;
  }

}
