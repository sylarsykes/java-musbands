package org.sylrsykssoft.java.musbands.admin.musical.genre.resource.assembler;

import java.beans.ConstructorProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.sylrsykssoft.coreapi.framework.library.mapper.ModelMapperFunction;
import org.sylrsykssoft.coreapi.framework.web.resource.assembler.BaseAdminResourceAssembler;
import org.sylrsykssoft.java.musbands.admin.musical.genre.configuration.MusicalGenreConstants;
import org.sylrsykssoft.java.musbands.admin.musical.genre.controller.MusicalGenreController;
import org.sylrsykssoft.java.musbands.admin.musical.genre.domain.MusicalGenre;
import org.sylrsykssoft.java.musbands.admin.musical.genre.resource.MusicalGenreResource;


/**
 * The Class BaseResourceAssembler.
 * 
 * @author juan.gonzalez.fernandez.jgf
 */
public class MusicalGenreResourceAssembler extends BaseAdminResourceAssembler<MusicalGenreController, MusicalGenre, MusicalGenreResource> {

	/** The base entity resource model mapper function. */
	@Autowired
	@Qualifier(MusicalGenreConstants.MAPPER_RESOURCE_FUNCTION)
	private ModelMapperFunction<MusicalGenre, MusicalGenreResource> musicalGenreMapperToResourceFunction;
	
	/**
	 * Instantiates a new base resource assembler.
	 *
	 * @param controllerClass the controller class
	 * @param resourceType the resource type
	 */
	@ConstructorProperties({ "controllerClass", "entityClass", "resourceType" })
	public MusicalGenreResourceAssembler(final Class<MusicalGenreController> controllerClass, final Class<MusicalGenre> entityClass, final Class<MusicalGenreResource> resourceType) {
		super(controllerClass, entityClass, resourceType);
	}
	
	/**
	 * Instantiates a new base resource assembler.
	 *
	 * @param controllerClass the controller class
	 * @param resourceType the resource type
	 * @param parameters the parameters
	 */
	@ConstructorProperties({ "controllerClass", "entityClass", "resourceType", "parameters" })
	public MusicalGenreResourceAssembler(final Class<MusicalGenreController> controllerClass, final Class<MusicalGenre> entityClass, final Class<MusicalGenreResource> resourceType, final Object ...parameters) {
		super(controllerClass, entityClass, resourceType, parameters);
	}
	
	/**
	 * {inheritDoc} 
	 */
	@Override
	public ModelMapperFunction<MusicalGenre, MusicalGenreResource> getAdminMapperToResourceFunction() {
		return musicalGenreMapperToResourceFunction;
	}

}
