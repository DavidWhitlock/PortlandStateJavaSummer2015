package edu.pdx.cs410J.minesweeper.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
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

  private IsWidget createGameScreen() {
    DockPanel gameScreen = new DockPanel();
    gameScreen.add(new Label("Click on a cell to probe it"), DockPanel.NORTH);
    return gameScreen;
  }

  private VerticalPanel createStartScreen() {
    VerticalPanel startScreen = new VerticalPanel();
    startScreen.add(new Label("Enter game board size"));

    startScreen.add(createRowsPanel());
    startScreen.add(createColumnsPanel());
    Button createGame = new Button("Create Game");
    createGame.addClickHandler(new ClickHandler() {
      @Override
      public void onClick(ClickEvent clickEvent) {
        gamePanels.showWidget(GAME_SCREEN);
      }
    });
    startScreen.add(createGame);
    return startScreen;
  }

  private HorizontalPanel createRowsPanel() {
    HorizontalPanel rowsPanel = new HorizontalPanel();
    rowsPanel.add(new Label("Rows"));
    rowsPanel.add(new TextBox());
    return rowsPanel;
  }

  private HorizontalPanel createColumnsPanel() {
    HorizontalPanel rowsPanel = new HorizontalPanel();
    rowsPanel.add(new Label("Columns"));
    rowsPanel.add(new TextBox());
    return rowsPanel;
  }
}
