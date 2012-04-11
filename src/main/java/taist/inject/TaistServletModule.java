/**
 * 
 */
package taist.inject;

import taist.GsonBodyWriter;
import taist.TaistServlet;
import taist.endpoint.Hello;

import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

/**
 * @author CrEv
 * 
 */
public class TaistServletModule extends JerseyServletModule {
  @Override
  protected void configureServlets() {
    serve("/index.html").with(TaistServlet.class);
    
    
    bind(GsonBodyWriter.class);

    bind(Hello.class);

    // Allow REST resources
    serve("/*").with(GuiceContainer.class);
  }
}
