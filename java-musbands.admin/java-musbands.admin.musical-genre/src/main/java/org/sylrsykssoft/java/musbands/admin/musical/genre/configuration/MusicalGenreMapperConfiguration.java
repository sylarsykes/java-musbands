package org.sylrsykssoft.java.musbands.admin.musical.genre.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.sylrsykssoft.coreapi.framework.library.mapper.ModelMapperFunction;
import org.sylrsykssoft.java.musbands.admin.musical.genre.domain.MusicalGenre;
import org.sylrsykssoft.java.musbands.admin.musical.genre.resource.MusicalGenreResource;

/**
 * MusicalGenreMapperConfiguration
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Configuration
public class MusicalGenreMapperConfiguration {

	/**
	 * MusicalGenre mapper function.
	 *
	 * @return the model mapper function
	 */
	@Bean(MusicalGenreConstants.MAPPER_RESOURCE_FUNCTION)
	@Scope(value = "prototype")
	@Lazy(value = true)
	public ModelMapperFunction<MusicalGenre, MusicalGenreResource> musicalGenreMapperToResourceFunction() {
		return new ModelMapperFunction<MusicalGenre, MusicalGenreResource>(MusicalGenre.class, MusicalGenreResource.class);
	}
	
	/**
	 * MusicalGenre mapper function.
	 *
	 * @return the model mapper function
	 */
	@Bean(MusicalGenreConstants.MAPPER_ENTITY_FUNCTION)
	@Scope(value = "prototype")
	@Lazy(value = true)
	public ModelMapperFunction<MusicalGenreResource, MusicalGenre> musicalGenreMapperToEntityFunction() {
		return new ModelMapperFunction<MusicalGenreResource, MusicalGenre>(MusicalGenreResource.class, MusicalGenre.class);
	}
}
