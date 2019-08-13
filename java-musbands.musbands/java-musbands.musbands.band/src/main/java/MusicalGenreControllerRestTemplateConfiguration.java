

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sylrsykssoft.coreapi.framework.web.BaseAdminRestTemplateController;
import org.sylrsykssoft.java.musbands.admin.musical.genre.domain.MusicalGenre;
import org.sylrsykssoft.java.musbands.admin.musical.genre.resource.MusicalGenreResource;

@Configuration
public class MusicalGenreControllerRestTemplateConfiguration {

	@Value("${spring.data.rest.base-path}")
	private String basePath;
	
	@Bean
	public BaseAdminRestTemplateController<MusicalGenreResource, MusicalGenre> baseAdminControllerRestTemplate() {
		return new BaseAdminRestTemplateController<MusicalGenreResource, MusicalGenre>(basePath, MusicalGenreConstants.CONTROLLER_REQUEST_NAME, MusicalGenreResource.class);
	}
}
