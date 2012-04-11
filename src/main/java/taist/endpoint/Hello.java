/**
 * 
 */
package taist.endpoint;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import taist.HelloPojo;


/**
 * Hello world test
 * @author CrEv
 * 
 */
@Path("/hello")
public class Hello {
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
    return "<!DOCTYPE html>\n<html><head><meta charset=\"utf-8\"><title>Plop</title></head><body><h1>Hello World!</h1></body></html>";
  }
}
