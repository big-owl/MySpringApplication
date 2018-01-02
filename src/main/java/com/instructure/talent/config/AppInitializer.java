package com.instructure.talent.config;

import com.instructure.talent.service.RootConfig;
import com.instructure.talent.web.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

  // if you plan on having more than one servlet, the root config should hold the beans (such as services and repositories)
  // that will be common to each servlet.
  @Override
  protected Class[] getRootConfigClasses() {
    System.out.println("inside getRootConfigClasses");
    return new Class[] { RootConfig.class };
  }

  @Override
  protected Class[] getServletConfigClasses() {
    System.out.println("inside getServletConfigClasses");
    return new Class[] { WebConfig.class };
  }

  @Override
  protected String[] getServletMappings() {
    System.out.println("inside getServletMappings");
    return new String[] { "/" };
  }

}
