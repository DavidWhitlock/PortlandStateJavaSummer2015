package edu.pdx.cs410J.whitlock.client;

public class InvalidCustomerNameException extends RuntimeException {
  public InvalidCustomerNameException(String message) {
    super(message);
  }

  public InvalidCustomerNameException() {
  }
}
