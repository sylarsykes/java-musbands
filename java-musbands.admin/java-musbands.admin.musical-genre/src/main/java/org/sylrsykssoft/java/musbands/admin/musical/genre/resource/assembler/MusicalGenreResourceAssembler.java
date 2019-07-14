package org.sylrsykssoft.java.musbands.admin.musical.genre.resource.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.beans.ConstructorProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.sylrsykssoft.coreapi.framework.library.mapper.ModelMapperFunction;
import org.sylrsykssoft.java.musbands.admin.musical.genre.domain.MusicalGenre;
import org.sylrsykssoft.java.musbands.admin.musical.genre.resource.MusicalGenreResource;


/**
 * The Class BaseResourceAssembler.
 * 
 * @author juan.gonzalez.fernandez.jgf
 */
public class MusicalGenreResourceAssembler extends ResourceAssemblerSupport<MusicalGenre, MusicalGenreResource> {

	/** The entity class. */
	private Class<MusicalGenre> entityClass;
	
	/** The parameters. */
	private Object[] parameters;
	
	/** The base entity resource model mapper function. */
	@Autowired
	@Qualifier("musicalGenreMapperToResourceFunction")
	private ModelMapperFunction<MusicalGenre, MusicalGenreResource> baseEntityResourceModelMapperFunction;
	
	/**
	 * Instantiates a new base resource assembler.
	 *
	 * @param controllerClass the controller class
	 * @param resourceType the resource type
	 */
	@ConstructorProperties({ "controllerClass", "resourceType" })
	public MusicalGenreResourceAssembler(Class<MusicalGenre> controllerClass, Class<MusicalGenreResource> resourceType) {
		super(controllerClass, resourceType);
		entityClass = controllerClass;
		parameters = new Object[0];
	}
	
	/**
	 * Instantiates a new base resource assembler.
	 *
	 * @param controllerClass the controller class
	 * @param resourceType the resource type
	 * @param parameters the parameters
	 */
	@ConstructorProperties({ "controllerClass", "resourceType", "parameters" })
	public MusicalGenreResourceAssembler(Class<MusicalGenre> controllerClass, Class<MusicalGenreResource> resourceType, final Object ...parameters) {
		super(controllerClass, resourceType);
		entityClass = controllerClass;
		this.parameters = parameters;
	}
	
	/**
	 * To resource.
	 *
	 * @param entity the entity
	 * @return the base resource
	 */
	@Override
	public MusicalGenreResource toResource(final MusicalGenre entity) {
		final MusicalGenreResource instance = baseEntityResourceModelMapperFunction.apply(entity);
		instance.add(linkTo(entityClass, parameters).slash(entity.getEntityId()).withSelfRel());
		
		return instance;
	}

}
