package org.sylrsykssoft.java.musbands.musbands.library.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Global configuration
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Configuration
@PropertySource({ "classpath:application.properties", "classpath:logging.properties", "classpath:database.properties" })
public class MusbandsLibraryConfiguration {
	
}
