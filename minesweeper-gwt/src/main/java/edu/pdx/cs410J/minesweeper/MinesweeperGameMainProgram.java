package edu.pdx.cs410J.minesweeper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class MinesweeperGameMainProgram {

  private final MinesweeperGame game;
  private final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  public MinesweeperGameMainProgram(int numberOfRows, int numberOfColumns, MinesweeperGame.MineGameGenerator generator) {
    this.game = new MinesweeperGame(numberOfRows, numberOfColumns, generator);
  }

  public static void main(String[] args) {
    String numberOfRowsString = null;
    String numberOfColumnsString = null;
    List<String> rows = new ArrayList<>();

    for (String arg : args) {
      if (numberOfRowsString == null) {
        numberOfRowsString = arg;

      } else if (numberOfColumnsString == null) {
        numberOfColumnsString = arg;

      } else {
        rows.add(arg);
      }
    }

    if (numberOfRowsString == null) {
      usage("Missing number of rows");
      return;
    }

    if (numberOfColumnsString == null) {
      usage("Missing number of columns");
      return;
    }

    int numberOfRows;
    try {
      numberOfRows = Integer.parseInt(numberOfRowsString);

    } catch (NumberFormatException ex) {
      usage("Invalid number of rows: " + numberOfRowsString);
      return;
    }

    int numberOfColumns;
    try {
      numberOfColumns = Integer.parseInt(numberOfColumnsString);

    } catch (NumberFormatException ex) {
      usage("Invalid number of rows: " + numberOfColumnsString);
      return;
    }

    MinesweeperGame.MineGameGenerator generator;
    if (rows.isEmpty()) {
      generator = new RandomMinesweeperGameGenerator();

    } else {
      generator = (row, column) -> rows.get(row).charAt(column);
    }

    MinesweeperGameMainProgram main = new MinesweeperGameMainProgram(numberOfRows, numberOfColumns, generator);
    main.playGame();
  }

  private void playGame() {
    GameState state = this.game.probe(-1, -1);
    while(this.game.getGameResult() == GameState.GameResult.IN_PROGRESS) {
      printGameState(state);

      RowAndColumn rowAndColumn;
      try {
        rowAndColumn = askUserForRowAndColumn();

      } catch (InvalidRowAndColumnException ex) {
        System.out.println("Invalid input: " + ex.getLineFromInput());
        System.out.println("  " + ex.getMessage());
        System.out.println();
        continue;
      }

      state = this.game.probe(rowAndColumn.getRow(), rowAndColumn.getColumn());
    }

    printGameState(state);

    GameState.GameResult result = this.game.getGameResult();
    if (result == GameState.GameResult.WON) {
      System.out.println("Congratulations!  You won the game!");

    } else if (result == GameState.GameResult.LOST) {
      System.out.println("Bummer.  You found a mine and lost the game.");

    } else {
      System.err.println("Wait!  How did we end up in the " + result + " state?");
    }

  }

  private void printGameState(GameState state) {
    PrintStream out = System.out;

    out.println();

    out.print("  ");
    IntStream.range(0, state.getNumberOfColumns()).forEach(out::print);
    out.println();

    out.print(" +");
    IntStream.range(0, state.getNumberOfColumns()).forEach(i -> out.print("-"));
    out.println("+");

    for (int row = 0; row < state.getNumberOfRows(); row++) {
      out.print(row + "|");
      for (int column = 0; column < state.getNumberOfColumns(); column++) {
        out.print(state.getCharAt(row, column));
      }
      out.println("|");
    }

    out.print(" +");
    IntStream.range(0, state.getNumberOfColumns()).forEach(i -> out.print("-"));
    out.println("+");
  }

  private RowAndColumn askUserForRowAndColumn() throws InvalidRowAndColumnException {
    System.out.print("Enter the row and column you want to probe: ");
    System.out.flush();
    String line = readLineFromStandardInput();
    return new RowAndColumn(line);
  }

  private String readLineFromStandardInput() {
    try {
      return in.readLine();

    } catch (IOException e) {
      e.printStackTrace();
      System.exit(1);
      return null;
    }
  }

  private static void usage(String message) {
    PrintStream err = System.err;
    err.println("** " + message);
    err.println();
    err.println("Main program for playing minesweeper");
    err.println();
    err.println("java MinesweeperGameMainProgram numberOfRows numberOfColumns");
    err.println();

    System.exit(1);
  }

  private class RowAndColumn {
    private final int row;
    private final int column;

    public RowAndColumn(String line) throws InvalidRowAndColumnException {
      String[] array = line.split(" ");
      if (array.length != 2) {
        throw new InvalidRowAndColumnException("Missing row or column", line);
      }

      int row;
      try {
        row = Integer.parseInt(array[0]);

      } catch (NumberFormatException ex) {
        throw new InvalidRowAndColumnException("Row is not an integer", line);
      }

      int column;
      try {
        column = Integer.parseInt(array[1]);

      } catch (NumberFormatException ex) {
        throw new InvalidRowAndColumnException("Column is not an integer", line);
      }

      this.row = row;
      this.column = column;

    }

    public int getRow() {
      return row;
    }

    public int getColumn() {
      return column;
    }
  }

  private class InvalidRowAndColumnException extends Throwable {
    private final String line;

    public InvalidRowAndColumnException(String message, String line) {
      super(message);
      this.line = line;
    }

    public String getLineFromInput() {
      return line;
    }
  }
}
