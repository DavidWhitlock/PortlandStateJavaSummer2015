package edu.pdx.cs410J.whitlock.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import edu.pdx.cs410J.AbstractPhoneBill;
import edu.pdx.cs410J.AbstractPhoneCall;

import java.util.Collection;

/**
 * A basic GWT class that makes sure that we can send an Phone Bill back from the server
 */
public class PhoneBillGwt implements EntryPoint {

  private TextBox customerNameField;

  public void onModuleLoad() {
    customerNameField = new TextBox();
    customerNameField.setMaxLength(10);


    Button button = new Button("Ping Server");
    button.addClickHandler(createNewPhoneBillOnServer());

    RootPanel rootPanel = RootPanel.get();
    rootPanel.add(button);
    rootPanel.add(customerNameField);
  }

  private ClickHandler createNewPhoneBillOnServer() {
    return new ClickHandler() {
      @Override
      public void onClick(ClickEvent clickEvent) {
        String customerName = customerNameField.getText();

        PingServiceAsync async = GWT.create(PingService.class);
        async.ping(customerName, displayPhoneBill());
      }

      private AsyncCallback<AbstractPhoneBill> displayPhoneBill() {
        return new AsyncCallback<AbstractPhoneBill>() {

          @Override
          public void onFailure(Throwable ex) {
            if (ex instanceof InvalidCustomerNameException) {
              Window.alert("Please enter a valid customer name");

            } else {
              Window.alert("onFailure: " + ex.toString());
            }
          }

          @Override
          public void onSuccess(AbstractPhoneBill phonebill) {
            StringBuilder sb = new StringBuilder(phonebill.toString());
            Collection<AbstractPhoneCall> calls = phonebill.getPhoneCalls();
            for (AbstractPhoneCall call : calls) {
              sb.append(call);
              sb.append("\n");
            }
            Window.alert(sb.toString());
          }
        };
      }
    };
  }
}
