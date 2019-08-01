package org.sylrsykssoft.java.musbands.musbands.discographic.resource.assembler;

import java.beans.ConstructorProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.sylrsykssoft.coreapi.framework.library.mapper.ModelMapperFunction;
import org.sylrsykssoft.coreapi.framework.web.resource.assembler.BaseEntityResourceAssembler;
import org.sylrsykssoft.java.musbands.musbands.discographic.configuration.DiscographicConstants;
import org.sylrsykssoft.java.musbands.musbands.discographic.controller.DiscographicController;
import org.sylrsykssoft.java.musbands.musbands.discographic.domain.Discographic;
import org.sylrsykssoft.java.musbands.musbands.discographic.resource.DiscographicResource;


/**
 * The Class BaseResourceAssembler.
 * 
 * @author juan.gonzalez.fernandez.jgf
 */
public class DiscographicResourceAssembler extends BaseEntityResourceAssembler<DiscographicController, Discographic, DiscographicResource> {

	/** The base entity resource model mapper function. */
	@Autowired
	@Qualifier(DiscographicConstants.MAPPER_RESOURCE_FUNCTION)
	private ModelMapperFunction<Discographic, DiscographicResource> discographicMapperToResourceFunction;
	
	/**
	 * Instantiates a new base resource assembler.
	 *
	 * @param controllerClass the controller class
	 * @param resourceType the resource type
	 */
	@ConstructorProperties({ "controllerClass", "entityClass", "resourceType" })
	public DiscographicResourceAssembler(final Class<DiscographicController> controllerClass, final Class<Discographic> entityClass, final Class<DiscographicResource> resourceType) {
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
	public DiscographicResourceAssembler(final Class<DiscographicController> controllerClass, final Class<Discographic> entityClass, final Class<DiscographicResource> resourceType, final Object ...parameters) {
		super(controllerClass, entityClass, resourceType, parameters);
	}
	
	/**
	 * {inheritDoc} 
	 */
	@Override
	public ModelMapperFunction<Discographic, DiscographicResource> getEntityMapperToResourceFunction() {
		return discographicMapperToResourceFunction;
	}

}
