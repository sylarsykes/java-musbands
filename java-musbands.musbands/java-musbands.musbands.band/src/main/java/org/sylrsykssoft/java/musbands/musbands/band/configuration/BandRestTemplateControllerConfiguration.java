package org.sylrsykssoft.java.musbands.musbands.band.configuration;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sylrsykssoft.coreapi.framework.web.BaseAdminRestTemplateController;
import org.sylrsykssoft.java.musbands.musbands.band.admin.resource.BandMusicalGenreResource;
import org.sylrsykssoft.java.musbands.musbands.band.domain.BandMusicalGenre;

@Configuration
public class BandRestTemplateControllerConfiguration {

	@Value("${spring.data.rest.base-path}")
	private String basePath;
	
	@Bean
	public BaseAdminRestTemplateController<BandMusicalGenreResource, BandMusicalGenre> baseAdminControllerRestTemplate() {
		return new BaseAdminRestTemplateController<BandMusicalGenreResource, BandMusicalGenre>(basePath, BandMusicalGenreConstants.CONTROLLER_REQUEST_NAME_BACKUP, BandMusicalGenreResource.class);
	}
}
