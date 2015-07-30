package edu.pdx.cs410J.whitlock.client;

public class InvalidCustomerNameException extends Throwable {
  public InvalidCustomerNameException(String message) {
    super(message);
  }

  public InvalidCustomerNameException() {
  }
}
