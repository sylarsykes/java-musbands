package org.sylrsykssoft.java.musbands.admin.function.member.resource.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.beans.ConstructorProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.sylrsykssoft.coreapi.framework.library.mapper.ModelMapperFunction;
import org.sylrsykssoft.java.musbands.admin.function.member.domain.FunctionMember;
import org.sylrsykssoft.java.musbands.admin.function.member.resource.FunctionMemberResource;


/**
 * The Class BaseResourceAssembler.
 * 
 * @author juan.gonzalez.fernandez.jgf
 */
public class FunctionMemberResourceAssembler extends ResourceAssemblerSupport<FunctionMember, FunctionMemberResource> {

	/** The entity class. */
	private Class<FunctionMember> entityClass;
	
	/** The parameters. */
	private Object[] parameters;
	
	/** The base entity resource model mapper function. */
	@Autowired
	@Qualifier("FunctionMemberMapperToResourceFunction")
	private ModelMapperFunction<FunctionMember, FunctionMemberResource> baseEntityResourceModelMapperFunction;
	
	/**
	 * Instantiates a new base resource assembler.
	 *
	 * @param controllerClass the controller class
	 * @param resourceType the resource type
	 */
	@ConstructorProperties({ "controllerClass", "resourceType" })
	public FunctionMemberResourceAssembler(Class<FunctionMember> controllerClass, Class<FunctionMemberResource> resourceType) {
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
	public FunctionMemberResourceAssembler(Class<FunctionMember> controllerClass, Class<FunctionMemberResource> resourceType, final Object ...parameters) {
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
	public FunctionMemberResource toResource(final FunctionMember entity) {
		final FunctionMemberResource instance = baseEntityResourceModelMapperFunction.apply(entity);
		instance.add(linkTo(entityClass, parameters).slash(entity.getEntityId()).withSelfRel());
		
		return instance;
	}

}
