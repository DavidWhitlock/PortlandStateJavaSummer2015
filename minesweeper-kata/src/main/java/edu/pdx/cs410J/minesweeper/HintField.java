package edu.pdx.cs410J.minesweeper;

import java.util.List;

public class HintField {
  private char charAtZeroZero;

  public HintField(List<String> rows) {
    char c = rows.get(0).charAt(0);
    if (c == '*') {
      charAtZeroZero = '*';

    } else {
      charAtZeroZero = '0';
    }
  }

  public char getCharAt(int row, int column) {
    return charAtZeroZero;
  }
}
