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
    if (cellContainsMine(mineFieldMatrix, row, column)) {
      return '*';
    }

    int numberOfAdjacentMines = 0;
    if (hasMineToWest(mineFieldMatrix, row, column)) {
      numberOfAdjacentMines++;
    }
    if (hasMineToEast(mineFieldMatrix, row, column)) {
      numberOfAdjacentMines++;
    }
    if (hasMineToNorth(mineFieldMatrix, row, column)) {
      numberOfAdjacentMines++;
    }
    if (hasMineToSouth(mineFieldMatrix, row, column)) {
      numberOfAdjacentMines++;
    }
    if (hasMineToSouthEast(mineFieldMatrix, row, column)) {
      numberOfAdjacentMines++;
    }
    if (hasMineToSouthWest(mineFieldMatrix, row, column)) {
      numberOfAdjacentMines++;
    }
    if (hasMineToNorthEast(mineFieldMatrix, row, column)) {
      numberOfAdjacentMines++;
    }
    if (hasMineToNorthWest(mineFieldMatrix, row, column)) {
      numberOfAdjacentMines++;
    }

    assert numberOfAdjacentMines < 9;
    return String.valueOf(numberOfAdjacentMines).charAt(0);
  }

  private boolean hasMineToNorthWest(char[][] mineFieldMatrix, int row, int column) {
    return cellContainsMine(mineFieldMatrix, row - 1, column - 1);
  }

  private boolean hasMineToNorthEast(char[][] mineFieldMatrix, int row, int column) {
    return cellContainsMine(mineFieldMatrix, row - 1, column + 1);
  }

  private boolean hasMineToSouthWest(char[][] mineFieldMatrix, int row, int column) {
    return cellContainsMine(mineFieldMatrix, row + 1, column - 1);
  }

  private boolean hasMineToSouthEast(char[][] mineFieldMatrix, int row, int column) {
    return cellContainsMine(mineFieldMatrix, row + 1, column + 1);
  }

  private boolean hasMineToSouth(char[][] mineFieldMatrix, int row, int column) {
    return cellContainsMine(mineFieldMatrix, row + 1, column);
  }

  private boolean hasMineToNorth(char[][] mineFieldMatrix, int row, int column) {
    return cellContainsMine(mineFieldMatrix, row - 1, column);
  }

  private boolean hasMineToEast(char[][] mineFieldMatrix, int row, int column) {
    return cellContainsMine(mineFieldMatrix, row, column + 1);
  }

  private boolean hasMineToWest(char[][] mineFieldMatrix, int row, int column) {
    return cellContainsMine(mineFieldMatrix, row, column - 1);
  }

  private boolean cellContainsMine(char[][] mineFieldMatrix, int row, int column) {
    if (row < 0 || column < 0) {
      return false;

    } else if (row >= mineFieldMatrix.length || column >= mineFieldMatrix[0].length) {
      return false;

    } else {
      return mineFieldMatrix[row][column] == '*';
    }
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
