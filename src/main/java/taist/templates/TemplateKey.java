/**
 * 
 */
package taist.templates;

/**
 * @author CrEv
 *
 */
public final class TemplateKey {
  /**
   * Static helper
   * @param namespace Namespace
   * @param template Template
   * @return Template key
   */
  public static TemplateKey get(String namespace, String template) {
    return new TemplateKey(namespace, template);
  }
  
  private final String namespace;
  private final String template;
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((namespace == null) ? 0 : namespace.hashCode());
    result = prime * result + ((template == null) ? 0 : template.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    TemplateKey other = (TemplateKey) obj;
    if (namespace == null) {
      if (other.namespace != null) return false;
    } else if (!namespace.equals(other.namespace)) return false;
    if (template == null) {
      if (other.template != null) return false;
    } else if (!template.equals(other.template)) return false;
    return true;
  }

  public TemplateKey(String namespace, String template) {
    this.namespace = namespace;
    this.template = template;
  }

  public String getNamespace() {
    return namespace;
  }

  public String getTemplate() {
    return template;
  }
}
