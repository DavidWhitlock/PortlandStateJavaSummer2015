package edu.pdx.cs410J.whitlock;

import edu.pdx.cs410J.lang.Human;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

/**                                                                                 
 * This class is represents a <code>Student</code>.                                 
 */                                                                                 
public class Student extends Human {

  private double gpa;
  private ArrayList<String> classes;

  /**
   * Creates a new <code>Student</code>                                             
   *                                                                                
   * @param name                                                                    
   *        The student's name                                                      
   * @param classes                                                                 
   *        The names of the classes the student is taking.  A student              
   *        may take zero or more classes.                                          
   * @param gpa                                                                     
   *        The student's grade point average                                       
   * @param gender                                                                  
   *        The student's gender ("male" or "female", case insensitive)             
   */                                                                               
  public Student(String name, ArrayList classes, double gpa, String gender) {
    super(name);
    this.gpa = gpa;
    this.classes = classes;
  }

  /**                                                                               
   * All students say "This class is too much work"                                 
   */
  @Override
  public String says() {                                                            
    return "This class is too much work";
  }
                                                                                    
  /**                                                                               
   * Returns a <code>String</code> that describes this                              
   * <code>Student</code>.                                                          
   */                                                                               
  public String toString() {
    return this.name + " has a GPA of " + formatGpa() + " and is taking " + this.classes.size() + " classes:";
  }

  private String formatGpa() {
    NumberFormat format = new DecimalFormat("#.0#");
    return format.format(this.gpa);
  }

  /**
   * Main program that parses the command line, creates a
   * <code>Student</code>, and prints a description of the student to
   * standard out by invoking its <code>toString</code> method.
   */
  public static void main(String[] args) {
    String name = null;
    String gender = null;
    String gpaString = null;

    for (String arg : args) {
      if (name == null) {
        name = arg;

      } else if (gender == null) {
        gender = arg;

      } else if (gpaString == null) {
        gpaString = arg;
      }
    }

    if (name == null) {
      printErrorMessageAndExit("Missing command line arguments");

    } else if (gender == null) {
      printErrorMessageAndExit("Missing gender");

    } else if (gpaString == null) {
      printErrorMessageAndExit("Missing GPA");
    }

    double gpa;
    try {
      gpa = Double.parseDouble(gpaString);

    } catch (NumberFormatException ex) {
      printErrorMessageAndExit("Invalid GPA: " + gpaString);
    }
  }

  private static void printErrorMessageAndExit(String message) {
    System.err.println(message);
    System.exit(1);
  }
}