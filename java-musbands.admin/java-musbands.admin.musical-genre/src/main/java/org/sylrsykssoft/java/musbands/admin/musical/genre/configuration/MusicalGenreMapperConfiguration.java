package org.sylrsykssoft.java.musbands.admin.musical.genre.configuration;

import org.modelmapper.ModelMapper;
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
	 * Model mapper bean
	 * @return
	 */
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
	
	/**
	 * MusicalGenre mapper function.
	 *
	 * @return the model mapper function
	 */
	@Bean
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
	@Bean
	@Scope(value = "prototype")
	@Lazy(value = true)
	public ModelMapperFunction<MusicalGenreResource, MusicalGenre> musicalGenreMapperToEntityFunction() {
		return new ModelMapperFunction<MusicalGenreResource, MusicalGenre>(MusicalGenreResource.class, MusicalGenre.class);
	}
}
