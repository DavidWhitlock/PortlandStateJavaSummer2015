package edu.pdx.cs410J.whitlock.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import edu.pdx.cs410J.AbstractPhoneBill;
import edu.pdx.cs410J.whitlock.client.PhoneBill;
import edu.pdx.cs410J.whitlock.client.PhoneCall;
import edu.pdx.cs410J.whitlock.client.PingService;

/**
 * The server-side implementation of the Phone Bill service
 */
public class PingServiceImpl extends RemoteServiceServlet implements PingService
{
  @Override
  public AbstractPhoneBill ping(String customerName) {
    PhoneBill phonebill = new PhoneBill(customerName);
    phonebill.addPhoneCall(new PhoneCall());
    return phonebill;
  }

  /**
   * Log unhandled exceptions to standard error
   *
   * @param unhandled
   *        The exception that wasn't handled
   */
  @Override
  protected void doUnexpectedFailure(Throwable unhandled) {
    unhandled.printStackTrace(System.err);
    super.doUnexpectedFailure(unhandled);
  }
}
