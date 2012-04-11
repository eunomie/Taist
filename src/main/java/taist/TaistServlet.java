/**
 * 
 */
package taist;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.inject.Singleton;

/**
 * @author CrEv
 *
 */
@Singleton
public class TaistServlet extends HttpServlet {
  /**
   * 
   */
  private static final long serialVersionUID = 6242962154485091492L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
      IOException {
    resp.getWriter().append("<!DOCTYPE html>\n<html><head><meta charset=\"utf-8\"><title>Plop</title></head><body><h1>Hello World!</h1></body></html>");
  }
}
