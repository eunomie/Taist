/**
 * 
 */
package taist.endpoint;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.inject.Inject;

import taist.HelloPojo;
import taist.templates.TemplateFactory;
import taist.templates.TemplateKey;


/**
 * Hello world test
 * @author CrEv
 * 
 */
@Path("/hello")
public class Hello {
  @Inject
  private TemplateFactory templates;
  
  /**
   * 
   * @return Return the HelloPojo serialized in json
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Object get() {
    return new HelloPojo();
  }
  
  /**
   * 
   * @return
   */
  @GET
  @Produces(MediaType.TEXT_HTML)
  @Path("/world")
  public String world() {
    return templates.get(TemplateKey.get("page", "blank")).render();
  }
}
