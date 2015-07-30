package edu.pdx.cs410J.whitlock;

import org.junit.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.security.Principal;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PhoneBillServletTest {

  @Test
  public void postKeyValuePairStoresInMap() throws ServletException, IOException {
    PhoneBillServlet servlet = new PhoneBillServlet();
    String key = "KEY";
    String value = "VALUE";

    HttpServletRequest request = new MockHttpServletRequest();
    HttpServletResponse response = new MockHttpServletResponse();
    servlet.doPost(request, response);

    assertThat(servlet.getValue(key), equalTo(value));
  }

  private class MockHttpServletRequest implements HttpServletRequest {
    @Override
    public String getAuthType() {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public Cookie[] getCookies() {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public long getDateHeader(String s) {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public String getHeader(String s) {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public Enumeration getHeaders(String s) {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public Enumeration getHeaderNames() {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public int getIntHeader(String s) {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public String getMethod() {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public String getPathInfo() {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public String getPathTranslated() {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public String getContextPath() {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public String getQueryString() {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public String getRemoteUser() {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public boolean isUserInRole(String s) {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public Principal getUserPrincipal() {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public String getRequestedSessionId() {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public String getRequestURI() {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public StringBuffer getRequestURL() {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public String getServletPath() {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public HttpSession getSession(boolean b) {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public HttpSession getSession() {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public boolean isRequestedSessionIdValid() {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public boolean isRequestedSessionIdFromCookie() {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public boolean isRequestedSessionIdFromURL() {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public boolean isRequestedSessionIdFromUrl() {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public Object getAttribute(String s) {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public Enumeration getAttributeNames() {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public String getCharacterEncoding() {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public void setCharacterEncoding(String s) throws UnsupportedEncodingException {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public int getContentLength() {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public String getContentType() {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public String getParameter(String paramName) {
      if(paramName.equals("key")) {
        return "KEY";

      } else if (paramName.equals("value")) {
        return "VALUE";
      } else {
        throw new UnsupportedOperationException("Don't know how to handle parameter: " + paramName);
      }
    }

    @Override
    public Enumeration getParameterNames() {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public String[] getParameterValues(String s) {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public Map getParameterMap() {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public String getProtocol() {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public String getScheme() {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public String getServerName() {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public int getServerPort() {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public BufferedReader getReader() throws IOException {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public String getRemoteAddr() {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public String getRemoteHost() {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public void setAttribute(String s, Object o) {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public void removeAttribute(String s) {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public Locale getLocale() {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public Enumeration getLocales() {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public boolean isSecure() {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public RequestDispatcher getRequestDispatcher(String s) {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public String getRealPath(String s) {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public int getRemotePort() {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public String getLocalName() {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public String getLocalAddr() {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public int getLocalPort() {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }
  }

  private class MockHttpServletResponse implements HttpServletResponse {
    @Override
    public void addCookie(Cookie cookie) {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public boolean containsHeader(String s) {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public String encodeURL(String s) {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public String encodeRedirectURL(String s) {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public String encodeUrl(String s) {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public String encodeRedirectUrl(String s) {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public void sendError(int i, String s) throws IOException {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public void sendError(int i) throws IOException {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public void sendRedirect(String s) throws IOException {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public void setDateHeader(String s, long l) {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public void addDateHeader(String s, long l) {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public void setHeader(String s, String s1) {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public void addHeader(String s, String s1) {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public void setIntHeader(String s, int i) {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public void addIntHeader(String s, int i) {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public void setStatus(int i) {

    }

    @Override
    public void setStatus(int i, String s) {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public String getCharacterEncoding() {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public String getContentType() {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public PrintWriter getWriter() throws IOException {
      return new PrintWriter(new StringWriter());
    }

    @Override
    public void setCharacterEncoding(String s) {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public void setContentLength(int i) {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public void setContentType(String s) {
    }

    @Override
    public void setBufferSize(int i) {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public int getBufferSize() {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public void flushBuffer() throws IOException {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public void resetBuffer() {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public boolean isCommitted() {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public void reset() {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public void setLocale(Locale locale) {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public Locale getLocale() {
      throw new UnsupportedOperationException("This method is not implemented yet");
    }
  }
}
