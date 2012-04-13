/**
 * 
 */
package taist.templates;

import com.google.template.soy.tofu.SoyTofu;


/**
 * @author CrEv
 *
 */
public interface TemplateFactory {
  /**
   * Get a template
   * @param key Key
   * @return Template renderer
   */
  SoyTofu.Renderer get(TemplateKey key);
}
