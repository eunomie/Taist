package taist.inject;

import taist.templates.TemplateCacheFactory;
import taist.templates.TemplateCacheLoader;
import taist.templates.TemplateFactory;

import com.google.inject.AbstractModule;
import com.google.template.soy.SoyModule;
import com.google.template.soy.xliffmsgplugin.XliffMsgPluginModule;

/**
 * Guice module
 * @author CrEv
 * 
 */
public class TaistModule extends AbstractModule {
  @Override
  protected void configure() {
    install(new SoyModule());
    install(new XliffMsgPluginModule());
    
    bind(TemplateCacheLoader.class);
    bind(TemplateFactory.class).to(TemplateCacheFactory.class);
  }
}
