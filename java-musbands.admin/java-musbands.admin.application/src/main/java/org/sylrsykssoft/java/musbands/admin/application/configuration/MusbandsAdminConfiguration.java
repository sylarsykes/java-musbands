package org.sylrsykssoft.java.musbands.admin.application.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Global configuration
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Configuration
@PropertySource({ "classpath:application.properties", "classpath:logging.properties", "classpath:database.properties" })
//@ComponentScan({ "org.sylrsykssoft.java.musbands.admin.musical.genre.*", "org.sylrsykssoft.java.musbands.admin.function.member.*" })
//@EnableJpaRepositories({ "org.sylrsykssoft.java.musbands.admin.musical.genre.repository", "org.sylrsykssoft.java.musbands.admin.function.member.repository" })
public class MusbandsAdminConfiguration {
	
}
