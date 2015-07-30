package edu.pdx.cs410J.minesweeper;

import com.google.common.annotations.VisibleForTesting;

import java.util.List;

public class MineFieldWithHints {
  private char[][] grid;

  public MineFieldWithHints(List<String> rows) {
    this.grid = new char[rows.size()][rows.get(0).length()];

    char[][] mineFieldMatrix = convertToCharMatrix(rows);

    for (int row = 0; row < mineFieldMatrix.length; row++) {
      for (int column = 0; column < mineFieldMatrix[0].length; column++) {
        this.grid[row][column] = getGridCellValue(mineFieldMatrix, row, column);
      }
    }

  }

  private char getGridCellValue(char[][] mineFieldMatrix, int row, int column) {
    char cell = mineFieldMatrix[row][column];
    if (cell == '*') {
      return '*';
    }

    return '1';
  }

  @VisibleForTesting
  static char[][] convertToCharMatrix(List<String> rows) {
    char[][] matrix = new char[rows.size()][rows.get(0).length()];

    for (int rowIndex = 0; rowIndex < rows.size(); rowIndex++) {
      String row = rows.get(rowIndex);
      matrix[rowIndex] = row.toCharArray();
    }

    return matrix;
  }

  public char getCharAt(int row, int column) {
    return this.grid[row][column];
  }
}
