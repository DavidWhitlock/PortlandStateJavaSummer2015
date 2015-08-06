package edu.pdx.cs410J.minesweeper.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;

import java.text.ParseException;

public class StartScreen extends Composite {

  private ValidGameDimensionsListener listener;
  private IntegerBox rowsField;
  private IntegerBox columnsField;

  public StartScreen() {
    VerticalPanel startScreen = new VerticalPanel();
    startScreen.add(new Label("Enter game board size"));

    startScreen.add(createRowsPanel());
    startScreen.add(createColumnsPanel());
    Button createGame = new Button("Create Game");
    createGame.addClickHandler(new ClickHandler() {
      @Override
      public void onClick(ClickEvent clickEvent) {
        int rows = 0;
        try {
          rows = getNumberOfRows();
        } catch (ParseException e) {
          Window.alert("Invalid number of rows");
          return;
        }
        int columns = 0;
        try {
          columns = getNumberOfColumns();
        } catch (ParseException e) {
          Window.alert("Invalid number of columns");
          return;
        }
        listener.validGameDimensions(rows, columns);
      }
    });
    startScreen.add(createGame);

    initWidget(startScreen);
  }

  private int getNumberOfColumns() throws ParseException {
    Integer valueOrThrow = this.columnsField.getValueOrThrow();
    if (valueOrThrow == null) {
      throw new ParseException("Null??", 0);
    }
    return valueOrThrow;
  }

  private int getNumberOfRows() throws ParseException {
    Integer valueOrThrow = this.rowsField.getValueOrThrow();
    if (valueOrThrow == null) {
      throw new ParseException("Null??", 0);
    }
    return valueOrThrow;
  }

  private HorizontalPanel createRowsPanel() {
    HorizontalPanel rowsPanel = new HorizontalPanel();
    rowsPanel.add(new Label("Rows"));
    rowsField = new IntegerBox();
    rowsPanel.add(rowsField);
    return rowsPanel;
  }

  private HorizontalPanel createColumnsPanel() {
    HorizontalPanel rowsPanel = new HorizontalPanel();
    rowsPanel.add(new Label("Columns"));
    columnsField = new IntegerBox();
    rowsPanel.add(columnsField);
    return rowsPanel;
  }

  public void addValidGameDimensionsListener(ValidGameDimensionsListener listener) {
    this.listener = listener;

  }

  interface ValidGameDimensionsListener {
    void validGameDimensions(int rows, int columns);
  }
}
