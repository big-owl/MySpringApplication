package com.app.config;

import com.app.service.RootConfig;
import com.app.web.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

  // if you plan on having more than one servlet, the root config should hold the beans (such as services and repositories)
  // that will be common to each servlet.
  @Override
  protected Class[] getRootConfigClasses() {
    return new Class[] { RootConfig.class };
  }

  @Override
  protected Class[] getServletConfigClasses() {
    return new Class[] { WebConfig.class };
  }

  @Override
  protected String[] getServletMappings() {
    return new String[] { "/" };
  }

}
