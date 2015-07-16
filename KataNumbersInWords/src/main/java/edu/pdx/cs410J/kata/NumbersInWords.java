package edu.pdx.cs410J.kata;

import edu.pdx.cs410J.AbstractPhoneBill;

/**
 * The main class for the CS410J Phone Bill Project
 */
public class NumbersInWords {

  public boolean parse(String input)
  {
    try
    {
    double result = Double.parseDouble(input);
      if(result<0){
        return false;
      }
    }
    catch (Exception e)
    {
      return false;
    }
    return true;
  }

  public static void main(String[] args) {
    Class c = AbstractPhoneBill.class;  // Refer to one of Dave's classes so that we can be sure it is on the classpath
    System.err.println("Missing command line arguments");
    for (String arg : args) {
      System.out.println(arg);
    }
    System.exit(1);
  }

}