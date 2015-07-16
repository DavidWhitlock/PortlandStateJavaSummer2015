package edu.pdx.cs410J.kata;

import edu.pdx.cs410J.InvokeMainTestCase;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests the functionality in the {@link NumbersInWords} main class.
 */
public class NumbersInWordsTest extends InvokeMainTestCase {

    /**
     * Invokes the main method of {@link NumbersInWords} with the given arguments.
     */
    private MainMethodResult invokeMain(String... args) {
        return invokeMain( NumbersInWords.class, args );
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
  @Test
   public void StringArguments() {
    String input = "abc";
    NumbersInWords niw = new NumbersInWords();
    assertFalse(niw.parse(input));
   }


}