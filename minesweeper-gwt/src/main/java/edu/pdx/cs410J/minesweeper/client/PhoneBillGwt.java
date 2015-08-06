package edu.pdx.cs410J.minesweeper.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;

/**
 * A basic GWT class that makes sure that we can send an Phone Bill back from the server
 */
public class PhoneBillGwt implements EntryPoint {
  public void onModuleLoad() {

    VerticalPanel startScreen = new VerticalPanel();
    startScreen.add(new Label("Enter game board size"));

    startScreen.add(createRowsPanel());
    startScreen.add(createColumnsPanel());
    startScreen.add(new Button("Create Game"));

    RootPanel rootPanel = RootPanel.get();
    rootPanel.add(startScreen);
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
