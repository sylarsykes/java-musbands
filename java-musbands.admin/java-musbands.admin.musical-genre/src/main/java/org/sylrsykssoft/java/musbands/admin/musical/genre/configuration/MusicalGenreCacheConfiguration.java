package org.sylrsykssoft.java.musbands.admin.musical.genre.configuration;

import java.util.Arrays;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration; 

/**
 * MusicalGenreCacheConfiguration
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Configuration
@EnableCaching
public class MusicalGenreCacheConfiguration {

	@Bean(MusicalGenreConstants.CACHE_MANGER_BEAN_NAME)
	public CacheManager cacheManager() {
		final SimpleCacheManager cacheManager = new SimpleCacheManager();
		cacheManager.setCaches(Arrays.asList(new ConcurrentMapCache(MusicalGenreConstants.CACHE_NAME)));
		return cacheManager;
	}

}
