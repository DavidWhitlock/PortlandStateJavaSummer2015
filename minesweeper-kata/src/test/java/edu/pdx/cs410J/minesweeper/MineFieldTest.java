package edu.pdx.cs410J.minesweeper;

import edu.pdx.cs410J.InvokeMainTestCase;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Tests the functionality in the {@link MineField} main class.
 */
public class MineFieldTest extends InvokeMainTestCase {

  // What should we test?
  // Is there a matrix?
  // Make sure that the matrix specified by mine field matches dimensions
  // Making sure that the number of ajancent mines is correct
  // No mines
  // All mines
  // Are mines correctly identified in output?
  // Bad character (not * and not .) in input
  // Make sure input has newlines

  @Test(expected = IllegalArgumentException.class)
  public void zeroByZeroMineFieldThrowsIllegalArgumentException() {
    new MineField(0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void zeroByNonZeroThrowsIllegalArgumentException(){

    new MineField(0, 1);

  }

  @Test(expected = IllegalArgumentException.class)
  public void nonZeroByZeroThrowsIllegalArgumentException(){
    new MineField(2, 0);
  }

  @Test
  public void nonZeroByNonZeroIsOkay() {
    new MineField(1, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void moreThan100RowsThrowsIllegalArgumentException() {
    new MineField(101, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void moreThan100ColumnsThrowsIllegalArgumentException() {
    new MineField(1, 101);
  }

  @Test
  public void oneByOneMineFieldWithOneMineHasOneMine() {
    MineField field = new MineField(1, 1);
    field.addRow("*");

    MineFieldWithHints hint = field.getHints();
    assertThat(hint.getCharAt(0, 0), equalTo('*'));
  }

  @Test
  public void oneByOneMineFieldWithNoMinesHasZeroMines() {
    MineField field = new MineField(1, 1);
    field.addRow(".");

    MineFieldWithHints hint = field.getHints();
    assertThat(hint.getCharAt(0, 0), equalTo('0'));
  }

}