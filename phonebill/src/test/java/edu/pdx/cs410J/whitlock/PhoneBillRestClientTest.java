package edu.pdx.cs410J.whitlock;

import edu.pdx.cs410J.web.HttpRequestHelper;
import org.junit.Test;

import java.io.IOException;
import java.net.HttpURLConnection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class PhoneBillRestClientTest {
  private static final String HOSTNAME = "localhost";
  private static final int PORT = Integer.getInteger("http.port", 8080);

  @Test
  public void missingRequiredParameterReturnsPreconditionFailed() throws IOException {
    PhoneBillRestClient client = new PhoneBillRestClient(HOSTNAME, PORT);
    HttpRequestHelper.Response response = client.postToMyURL();
    assertThat(response.getContent(), containsString(Messages.missingRequiredParameter("key")));
    assertThat(response.getCode(), equalTo(HttpURLConnection.HTTP_PRECON_FAILED));
  }
}
