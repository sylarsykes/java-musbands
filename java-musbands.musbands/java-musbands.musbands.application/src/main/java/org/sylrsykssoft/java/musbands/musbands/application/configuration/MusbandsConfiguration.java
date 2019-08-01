package org.sylrsykssoft.java.musbands.musbands.application.configuration;

import org.springframework.context.annotation.ComponentScan;
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
@ComponentScan({ 
	"org.sylrsykssoft.java.musbands.musbands.discographic.*",
})
public class MusbandsConfiguration {

}
