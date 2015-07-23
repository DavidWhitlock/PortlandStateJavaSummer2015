package edu.pdx.cs410J.minesweeper;

import edu.pdx.cs410J.InvokeMainTestCase;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Tests the functionality in the {@link MineField} main class.
 */
public class MineFieldTest extends InvokeMainTestCase {

  // What should we test?
  // Is there a matrix?
  // Zero by zero matrix
  // Zero by non-zero matrix
  // Negative matrix size
  // Non-zero by non-zero matrix
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
  public void zeroByNonZeroThrowsIllegalArgumentExcepion(){

    new MineField(0, 1);

  }

  @Ignore
  @Test(expected = IllegalArgumentException.class)
  public void nonZeroByZeroThrowsIllegalArgumentExcepion(){



  }

  @Test
  public void oneByOneMineFieldWithOneMineHasOneMine() {
    MineField field = new MineField(1, 1);
    field.addLine("*");

    HintField hint = field.getHintField();
    assertThat(hint.getLine(0), equalTo("*"));
  }
}