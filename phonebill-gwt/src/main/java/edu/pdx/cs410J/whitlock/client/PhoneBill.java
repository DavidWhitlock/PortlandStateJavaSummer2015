package edu.pdx.cs410J.whitlock.client;

import edu.pdx.cs410J.AbstractPhoneCall;
import edu.pdx.cs410J.AbstractPhoneBill;

import java.lang.Override;
import java.util.ArrayList;
import java.util.Collection;

public class PhoneBill extends AbstractPhoneBill
{
  private String customerName;
  private Collection<AbstractPhoneCall> calls = new ArrayList<AbstractPhoneCall>();

  public PhoneBill(String customerName) {
    this.customerName = customerName;

  }

  public PhoneBill() {
  }

  @Override
  public String getCustomer() {
    return this.customerName;
  }

  @Override
  public void addPhoneCall(AbstractPhoneCall call) {
    this.calls.add(call);
  }

  @Override
  public Collection getPhoneCalls() {
    return this.calls;
  }
}
