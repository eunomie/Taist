/**
 * 
 */
package taist;

import taist.inject.TaistModule;
import taist.inject.TaistServletModule;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

/**
 * Configuration of servlets and REST resources using
 * Guice and Jersey.
 * @author CrEv
 * 
 */
public class TaistServletConfig extends GuiceServletContextListener {

  @Override
  protected Injector getInjector() {
    return Guice.createInjector(new TaistServletModule(), new TaistModule());
  }

}
