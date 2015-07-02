package edu.pdx.cs410J.whitlock;

import edu.pdx.cs410J.InvokeMainTestCase;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.StringContains.containsString;

/**
 * JUnit tests for the Student class.  These tests extend <code>InvokeMainTestCase</code>
 * which allows them to easily invoke the <code>main</code> method of <code>Student</code>.
 * They also make use of the <a href="http://hamcrest.org/JavaHamcrest/">hamcrest</a>matchers
 * for more readable assertion statements.
 */
public class StudentTest extends InvokeMainTestCase
{

  @Test
  public void allStudentsSayThisClassIsTooMuchWork() {
    Student student = new Student("name", new ArrayList(), 1.23, "male");
    assertThat(student.says(), equalTo("This class is too much work"));
  }

  @Ignore
  @Test
  public void studentToStringOfDavemale3_64AlgorithmsOperatingSystemsJava() {
    Student dave = createStudent("Dave");

    assertThat(dave.toString(), equalTo("Dave has a GPA of 3.64 and is taking 3 classes: Algorithms, Operating Systems, and Java. He says \"This class is too much work\"."));
  }

  @Test
  public void studentNamedDaveHasNameOfDave() {
    Student dave = createStudent("Dave");

    assertThat(dave.toString(), startsWith("Dave"));
  }

  @Test
  public void studentNamedFrankHasNameOfFrank() {
    Student frank = createStudent("Frank");

    assertThat(frank.toString(), startsWith("Frank"));
  }

  @Test
  public void studentWithGPAof314(){
    double gpa = 3.14;
    String expectedGpaStringValue = String.valueOf(gpa);

    assertGpaIsAsExpected(gpa, expectedGpaStringValue);
  }

  private void assertGpaIsAsExpected(double gpa, String expectedGpaStringValue) {
    Student aStudent = createStudent("student", gpa);
    assertThat(aStudent.toString(), containsString(" has a GPA of " + expectedGpaStringValue));
  }

  @Test
  public void wholeNumberGPAPrintsWithTwoDecimalPlace() {
    double gpa = 4;
    String expectedGpaStringValue = "4.0";

    assertGpaIsAsExpected(gpa, expectedGpaStringValue);
  }

  @Test
  public void gpaOf3point999DisplaysAs4point00() {
    assertGpaIsAsExpected(3.999, "4.0");
  }

  /**
   * Creates a new <code>Student</code> with the given name.
   * @param name The name of the student
   * @return The new student
   */
  private Student createStudent(String name) {
    return createStudent(name, 3.64);
  }

  /**
   * Creates a new <code>Student</code> with the given name.
   * @param name The name of the student
   * @param gpa
   * @return The new student
   */
  private Student createStudent(String name, double gpa) {
    return createStudent(name, gpa, 3);
  }

  /**
   * Creates a new <code>Student</code> with the given name.
   * @param name The name of the student
   * @param gpa
   * @param numClasses
   * @return The new student
   */
  private Student createStudent(String name, double gpa, int numClasses) {
    ArrayList classes = new ArrayList();

    for (int i = 0; i < numClasses; i++) {
      classes.add("Class " + i);
    }

    return new Student(name, classes, gpa, "male");
  }

  @Test
  public void studentWhoTakesThreeClassesSpecifiesTheyTake3Classes(){
    Student aStudent = createStudent("student", 3.14, 3);
    assertThat(aStudent.toString(), containsString(" and is taking 3 classes:"));

  }

  @Test
  public void invokingMainWithNoArgumentsHasExitCodeOf1() {
    MainMethodResult result = invokeMain(Student.class);
    assertThat(result.getExitCode(), equalTo(1));
  }

  @Ignore
  @Test
  public void invokingMainWithNoArgumentsPrintsMissingArgumentsToStandardError() {
    MainMethodResult result = invokeMain(Student.class);
    assertThat(result.getErr(), containsString("Missing command line arguments"));
  }

  @Ignore
  @Test
  public void unparsableGPAResultsInErrorMessage()
  {

  }

}
