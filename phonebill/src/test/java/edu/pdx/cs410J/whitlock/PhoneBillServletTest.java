package edu.pdx.cs410J.whitlock;

import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.*;

public class PhoneBillServletTest {

  @Test
  public void postKeyValuePairStoresInMap() throws ServletException, IOException {
    PhoneBillServlet servlet = new PhoneBillServlet();
    String key = "KEY";
    String value = "VALUE";

    HttpServletRequest request = mock(HttpServletRequest.class);
    when(request.getParameter("key")).thenReturn("KEY");
    when(request.getParameter("value")).thenReturn("VALUE");

    HttpServletResponse response = mock(HttpServletResponse.class);

    PrintWriter writer = mock(PrintWriter.class);
    when(response.getWriter()).thenReturn(writer);
    servlet.doPost(request, response);

    assertThat(servlet.getValue(key), equalTo(value));
    verify(writer).println(Messages.mappedKeyValue(key, value));
  }

}
