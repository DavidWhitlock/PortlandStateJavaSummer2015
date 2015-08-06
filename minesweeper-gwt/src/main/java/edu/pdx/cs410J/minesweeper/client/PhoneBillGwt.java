package edu.pdx.cs410J.minesweeper.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;

/**
 * A basic GWT class that makes sure that we can send an Phone Bill back from the server
 */
public class PhoneBillGwt implements EntryPoint {

  static final int GAME_SCREEN = 1;
  static final int START_SCREEN = 0;
  private DeckPanel gamePanels;

  @Override
  public void onModuleLoad() {
    gamePanels = new DeckPanel();
    gamePanels.add(createStartScreen());
    gamePanels.add(createGameScreen());

    RootPanel rootPanel = RootPanel.get();
    rootPanel.add(gamePanels);
    gamePanels.showWidget(START_SCREEN);
  }

  private GameScreen createGameScreen() {
    return new GameScreen();
  }

  private StartScreen createStartScreen() {
    StartScreen startScreen = new StartScreen();
    startScreen.addValidGameDimensionsListener(new StartScreen.ValidGameDimensionsListener() {
      @Override
      public void validGameDimensions(int rows, int columns) {
        Window.alert("Creating a new " + rows + " x " + columns + " game");
        gamePanels.showWidget(GAME_SCREEN);
      }
    });
    return startScreen;
  }

}
