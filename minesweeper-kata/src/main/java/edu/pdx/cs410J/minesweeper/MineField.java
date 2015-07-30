package edu.pdx.cs410J.minesweeper;

import java.util.ArrayList;
import java.util.List;

/**
 * The main class for the CS410J Phone Bill Project
 */
public class MineField {

  private List<String> rows = new ArrayList<>();

  public MineField(int rows, int columns) {
    if (checkBounds(rows) || columns <= 0 || columns > 100) {
      throw new IllegalArgumentException("%dx%d is not a valid dimension for a mine field");
    }

  }

  private boolean checkBounds(int dimension) {
    return dimension <= 0 || dimension > 100;
  }

  public void addRow(String line) {
    this.rows.add(line);
  }

  public MineFieldWithHints getHints() {
    return new MineFieldWithHints(this.rows);
  }
}