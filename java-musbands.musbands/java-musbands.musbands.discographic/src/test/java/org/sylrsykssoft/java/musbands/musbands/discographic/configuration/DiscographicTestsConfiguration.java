package org.sylrsykssoft.java.musbands.musbands.discographic.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Global configuration
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Configuration
@PropertySource({ "classpath:database-test.properties" })
public class DiscographicTestsConfiguration {

}
