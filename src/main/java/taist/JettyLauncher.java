/**
 * 
 */
package taist;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;

import com.google.inject.servlet.GuiceFilter;

/**
 * Launch the application inside a Jetty server
 * 
 * @author CrEv
 * 
 */
public class JettyLauncher {
  private final int port;
  private Server server;


  /**
   * Create a new web application launcher using Jetty
   * @param port Port number to listen on
   */
  public JettyLauncher(int port) {
    this.port = port;
  }

  /**
   * Run the Jetty server with a default Guice handler
   * @throws Exception Exceptions
   */
  public void run() throws Exception {
    server = new Server(port);

    ServletContextHandler sch = getDefaultContextHandler();
    sch.addEventListener(new TaistServletConfig());

    server.setHandler(sch);

    server.start();
    server.join();
  }

  /**
   * @return a default servlet context handler using Guice.
   */
  private ServletContextHandler getDefaultContextHandler() {
    ServletContextHandler sch = new ServletContextHandler(ServletContextHandler.SESSIONS);
    sch.setContextPath("/");

    sch.addFilter(GuiceFilter.class, "/*", null);
    sch.addServlet(DefaultServlet.class, "/");

    return sch;
  }

}
