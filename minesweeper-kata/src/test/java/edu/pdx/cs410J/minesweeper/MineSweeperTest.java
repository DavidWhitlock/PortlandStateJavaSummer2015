package edu.pdx.cs410J.minesweeper;

import edu.pdx.cs410J.InvokeMainTestCase;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests the functionality in the {@link Minesweeper} main class.
 */
public class MineSweeperTest extends InvokeMainTestCase {

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

    /**
     * Invokes the main method of {@link Minesweeper} with the given arguments.
     */
    private MainMethodResult invokeMain(String... args) {
        return invokeMain( Minesweeper.class, args );
    }

  /**
   * Tests that invoking the main method with no arguments issues an error
   */
  @Test
  public void testNoCommandLineArguments() {
    MainMethodResult result = invokeMain();
    assertEquals(new Integer(1), result.getExitCode());
    assertTrue(result.getErr().contains( "Missing command line arguments" ));
  }

}