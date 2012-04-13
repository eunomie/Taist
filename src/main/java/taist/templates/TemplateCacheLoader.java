/**
 * 
 */
package taist.templates;


import java.io.File;
import java.util.Collection;
import java.util.regex.Pattern;

import taist.ResourceList;

import com.google.common.cache.CacheLoader;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.template.soy.SoyFileSet;
import com.google.template.soy.tofu.SoyTofu;

/**
 * A cache loader to load tofus.
 * @author CrEv
 *
 */
@Singleton
public class TemplateCacheLoader extends CacheLoader<TemplateKey, SoyTofu.Renderer> {
  private static final String FILE_PATTERN = ".*\\.soy";
  
  private SoyFileSet sfs;
  
  @Inject
  public TemplateCacheLoader(SoyFileSet.Builder builder) {
    Collection<String> templates = ResourceList.getResources(Pattern.compile(FILE_PATTERN));
    for(String name : templates) {
      builder.add(new File(name));
    }
    sfs = builder.build();
  }

  @Override
  public SoyTofu.Renderer load(TemplateKey key) throws Exception {
    SoyTofu tofu = sfs.compileToTofu().forNamespace(key.getNamespace());
    return tofu.newRenderer("." + key.getTemplate());
  }
}
