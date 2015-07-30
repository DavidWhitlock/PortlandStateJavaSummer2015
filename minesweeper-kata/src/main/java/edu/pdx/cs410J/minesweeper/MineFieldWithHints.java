package edu.pdx.cs410J.minesweeper;

import java.util.List;

public class MineFieldWithHints {
  private char charAtZeroZero;

  public MineFieldWithHints(List<String> rows) {
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
