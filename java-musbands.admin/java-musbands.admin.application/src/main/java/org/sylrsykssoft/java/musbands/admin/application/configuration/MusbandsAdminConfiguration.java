package org.sylrsykssoft.java.musbands.admin.application.configuration;

import java.util.Arrays;

import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.sylrsykssoft.java.musbands.admin.function.member.configuration.FunctionMemberConstants;
import org.sylrsykssoft.java.musbands.admin.musical.genre.configuration.MusicalGenreConstants;

/**
 * Global configuration
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Configuration
@PropertySource({ "classpath:application.properties", "classpath:logging.properties", "classpath:database.properties" })
@ComponentScan({ 
	"org.sylrsykssoft.java.musbands.admin.musical.genre.*",
	"org.sylrsykssoft.java.musbands.admin.function.member.*" 
})
//@EnableJpaRepositories({ 
//	"org.sylrsykssoft.java.musbands.admin.musical.genre.repository", 
//	"org.sylrsykssoft.java.musbands.admin.function.member.repository" 
//})
@EnableCaching
public class MusbandsAdminConfiguration {

	/**
	 * CacheManager Bean
	 * 
	 * @return CacheManager
	 */
	@Bean(MusbandsAdminConstants.CACHE_MANGER_BEAN_NAME)
	@Primary
	public CacheManager cacheManager() {
		final SimpleCacheManager cacheManager = new SimpleCacheManager();
		cacheManager.setCaches(Arrays.asList(new ConcurrentMapCache(MusbandsAdminConstants.CACHE_NAME),
				new ConcurrentMapCache(MusicalGenreConstants.CACHE_NAME),
				new ConcurrentMapCache(FunctionMemberConstants.CACHE_NAME)));
		PhysicalNamingStrategyStandardImpl sdfd = null;
		return cacheManager;
	}
}
