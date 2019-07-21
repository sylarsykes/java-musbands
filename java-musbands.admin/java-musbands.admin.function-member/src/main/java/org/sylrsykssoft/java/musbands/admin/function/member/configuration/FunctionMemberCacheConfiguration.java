package org.sylrsykssoft.java.musbands.admin.function.member.configuration;

import java.util.Arrays;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration; 

/**
 * FunctionMemberCacheConfiguration
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Configuration
@EnableCaching
public class FunctionMemberCacheConfiguration {

	/**
	 * CacheManager Bean
	 * 
	 * @return CacheManager
	 */
	@Bean(FunctionMemberConstants.CACHE_MANGER_BEAN_NAME)
	public CacheManager cacheManager() {
		final SimpleCacheManager cacheManager = new SimpleCacheManager();
		cacheManager.setCaches(Arrays.asList(new ConcurrentMapCache(FunctionMemberConstants.CACHE_NAME)));
		return cacheManager;
	}

}
