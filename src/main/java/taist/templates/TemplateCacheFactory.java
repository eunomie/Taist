/**
 * 
 */
package taist.templates;

import java.util.concurrent.ExecutionException;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.template.soy.tofu.SoyTofu;

/**
 * @author CrEv
 * 
 */
@Singleton
public class TemplateCacheFactory implements TemplateFactory {
  private LoadingCache<TemplateKey, SoyTofu.Renderer> loadingCache;

  @Inject
  public TemplateCacheFactory(TemplateCacheLoader loader) {
    loadingCache = CacheBuilder.newBuilder().maximumSize(50).build(loader);
  }

  @Override
  public SoyTofu.Renderer get(TemplateKey key) {
    SoyTofu.Renderer renderer = null;
    try {
      renderer = loadingCache.get(key);
    } catch (ExecutionException e) {
      e.printStackTrace();
    }
    return renderer;
  }

}
