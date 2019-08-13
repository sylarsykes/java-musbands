package org.sylrsykssoft.java.musbands.admin.musical.genre.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Global configuration
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Configuration
@ConfigurationProperties
@PropertySource({ "classpath:database-test.properties" })
public class MusicalGenreTestsConfiguration {

}
