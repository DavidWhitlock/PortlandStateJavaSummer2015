package edu.pdx.cs410J.minesweeper.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.*;

public class StartScreen extends Composite {

  private ValidGameDimensionsListener listener;

  public StartScreen() {
    VerticalPanel startScreen = new VerticalPanel();
    startScreen.add(new Label("Enter game board size"));

    startScreen.add(createRowsPanel());
    startScreen.add(createColumnsPanel());
    Button createGame = new Button("Create Game");
    createGame.addClickHandler(new ClickHandler() {
      @Override
      public void onClick(ClickEvent clickEvent) {
        listener.validGameDimensions();
      }
    });
    startScreen.add(createGame);

    initWidget(startScreen);
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

  public void addValidGameDimensionsListener(ValidGameDimensionsListener listener) {
    this.listener = listener;

  }

  interface ValidGameDimensionsListener {
    void validGameDimensions();
  }
}
