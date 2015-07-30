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

    int numberOfAdjacentMines = 0;
    if (hasMineToTheLeft(mineFieldMatrix, row, column)) {
      numberOfAdjacentMines++;
    }
    if (hasMineToTheRight(mineFieldMatrix, row, column)) {
      numberOfAdjacentMines++;
    }
    if (hasMineAbove(mineFieldMatrix, row, column)) {
      numberOfAdjacentMines++;
    }
    if (hasMineBelow(mineFieldMatrix, row, column)) {
      numberOfAdjacentMines++;
    }

    assert numberOfAdjacentMines < 9;
    return String.valueOf(numberOfAdjacentMines).charAt(0);
  }

  private boolean hasMineBelow(char[][] mineFieldMatrix, int row, int column) {
    int rowBelow = row + 1;
    if (rowBelow >= mineFieldMatrix.length) {
      return false;

    } else {
      return cellContainsMine(mineFieldMatrix, rowBelow, column);
    }
  }

  private boolean hasMineAbove(char[][] mineFieldMatrix, int row, int column) {
    int rowAbove = row - 1;
    if (rowAbove < 0) {
      return false;

    } else {
      return cellContainsMine(mineFieldMatrix, rowAbove, column);
    }
  }

  private boolean hasMineToTheRight(char[][] mineFieldMatrix, int row, int column) {
    int columnToTheRight = column + 1;
    if (columnToTheRight >= mineFieldMatrix[0].length) {
      return false;

    } else {
      return cellContainsMine(mineFieldMatrix, row, columnToTheRight);
    }
  }

  private boolean hasMineToTheLeft(char[][] mineFieldMatrix, int row, int column) {
    int columnToTheLeft = column - 1;
    if (columnToTheLeft < 0) {
      return false;

    } else {
      return cellContainsMine(mineFieldMatrix, row, columnToTheLeft);
    }
  }

  private boolean cellContainsMine(char[][] mineFieldMatrix, int row, int column) {
    return mineFieldMatrix[row][column] == '*';
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
