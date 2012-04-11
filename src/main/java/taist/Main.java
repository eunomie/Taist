package taist;


/**
 * Main class.
 * This class load the current web application inside Jetty.
 * @author CrEv
 * 
 */
public class Main {
  public static void main(String[] args) throws Exception {
    JettyLauncher launcher = new JettyLauncher(8080);
    launcher.run();
  }
}
