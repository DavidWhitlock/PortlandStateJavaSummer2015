package edu.pdx.cs410J.minesweeper;

import edu.pdx.cs410J.AbstractPhoneBill;

/**
 * The main class for the CS410J Phone Bill Project
 */
public class MineField {

  public MineField(int rows, int columns) {
    throw new IllegalArgumentException();

  }

  public static void main(String[] args) {
    Class c = AbstractPhoneBill.class;  // Refer to one of Dave's classes so that we can be sure it is on the classpath
    System.err.println("Missing command line arguments");
    for (String arg : args) {
      System.out.println(arg);
    }
    System.exit(1);
  }

  public void addLine(String line) {


  }

  public HintField getHintField() {
    throw new UnsupportedOperationException("Not implemented yet");
  }
}