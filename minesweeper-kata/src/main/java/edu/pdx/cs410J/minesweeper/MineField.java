package edu.pdx.cs410J.minesweeper;

import edu.pdx.cs410J.AbstractPhoneBill;

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

  public static void main(String[] args) {
    Class c = AbstractPhoneBill.class;  // Refer to one of Dave's classes so that we can be sure it is on the classpath
    System.err.println("Missing command line arguments");
    for (String arg : args) {
      System.out.println(arg);
    }
    System.exit(1);
  }

  public void addRow(String line) {
    this.rows.add(line);
  }

  public HintField getHintField() {
    return new HintField(this.rows);
  }
}