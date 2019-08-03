package org.sylrsykssoft.java.musbands.musbands.discographic.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.sylrsykssoft.coreapi.framework.library.mapper.ModelMapperFunction;
import org.sylrsykssoft.java.musbands.musbands.discographic.controller.DiscographicController;
import org.sylrsykssoft.java.musbands.musbands.discographic.domain.Discographic;
import org.sylrsykssoft.java.musbands.musbands.discographic.resource.DiscographicResource;
import org.sylrsykssoft.java.musbands.musbands.discographic.resource.assembler.DiscographicResourceAssembler;

/**
 * MusicalGenreMapperConfiguration
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Configuration
public class DiscographicMapperConfiguration {

	/**
	 * MusicalGenre mapper function.
	 *
	 * @return the model mapper function
	 */
	@Bean(DiscographicConstants.MAPPER_RESOURCE_FUNCTION)
	@Scope(value = "prototype")
	@Lazy(value = true)
	public ModelMapperFunction<Discographic, DiscographicResource> discographicMapperToResourceFunction() {
		return new ModelMapperFunction<Discographic, DiscographicResource>(Discographic.class, DiscographicResource.class);
	}
	
	
	/**
	 * FunctionMember mapper function.
	 *
	 * @return the model mapper function
	 */
	@Bean(DiscographicConstants.MAPPER_RESOURCE_ASSEMBLER)
	@Scope(value = "prototype")
	@Lazy(value = true)
	public DiscographicResourceAssembler discographicResourceAssembler() {
		return new DiscographicResourceAssembler(DiscographicController.class, Discographic.class, DiscographicResource.class);
	}
	
	/**
	 * MusicalGenre mapper function.
	 *
	 * @return the model mapper function
	 */
	@Bean(DiscographicConstants.MAPPER_ENTITY_FUNCTION)
	@Scope(value = "prototype")
	@Lazy(value = true)
	public ModelMapperFunction<DiscographicResource, Discographic> discographicMapperToEntityFunction() {
		return new ModelMapperFunction<DiscographicResource, Discographic>(DiscographicResource.class, Discographic.class);
	}
}
