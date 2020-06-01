package com.ram.projects.expmgr.conf;

import org.ehcache.CacheManager;
import org.ehcache.core.EhcacheManager;
import org.ehcache.xml.XmlConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URL;

@Configuration
@EnableCaching
public class CacheConfig {
  @Bean
  public CacheManager ehCacheManager() {
    return new EhcacheManager(configuration());
  }

  @Bean
  public org.ehcache.config.Configuration configuration() {
    URL myUrl = CacheConfig.class.getResource("/ehcache.xml");
    org.ehcache.config.Configuration xmlConfig = new XmlConfiguration(myUrl);
    /*CacheManager cacheManager = newCacheManager(xmlConfig);
    cacheManager.init();*/
    return xmlConfig;
  }
}
