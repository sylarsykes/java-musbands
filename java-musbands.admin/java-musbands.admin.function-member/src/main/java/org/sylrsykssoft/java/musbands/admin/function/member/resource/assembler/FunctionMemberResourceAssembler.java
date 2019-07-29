package org.sylrsykssoft.java.musbands.admin.function.member.resource.assembler;

import java.beans.ConstructorProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.sylrsykssoft.coreapi.framework.library.mapper.ModelMapperFunction;
import org.sylrsykssoft.coreapi.framework.web.resource.assembler.BaseAdminResourceAssembler;
import org.sylrsykssoft.java.musbands.admin.function.member.configuration.FunctionMemberConstants;
import org.sylrsykssoft.java.musbands.admin.function.member.controller.FunctionMemberController;
import org.sylrsykssoft.java.musbands.admin.function.member.domain.FunctionMember;
import org.sylrsykssoft.java.musbands.admin.function.member.resource.FunctionMemberResource;

/**
 * The Class BaseResourceAssembler.
 * 
 * @author juan.gonzalez.fernandez.jgf
 */
public class FunctionMemberResourceAssembler extends BaseAdminResourceAssembler<FunctionMemberController, FunctionMember, FunctionMemberResource> {

	
	/** The base entity resource model mapper function. */
	@Autowired
	@Qualifier(FunctionMemberConstants.MAPPER_RESOURCE_FUNCTION)
	private ModelMapperFunction<FunctionMember, FunctionMemberResource> functionMemberMapperToResource;
	
	/**
	 * Instantiates a new base resource assembler.
	 *
	 * @param controllerClass the controller class
	 * @param resourceType the resource type
	 */
	@ConstructorProperties({ "controllerClass", "entityClass", "resourceType" })
	public FunctionMemberResourceAssembler(final Class<FunctionMemberController> controllerClass, final Class<FunctionMember> entityClass, final Class<FunctionMemberResource> resourceType) {
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
	public FunctionMemberResourceAssembler(final Class<FunctionMemberController> controllerClass, final Class<FunctionMember> entityClass, final Class<FunctionMemberResource> resourceType, final Object ...parameters) {
		super(controllerClass, entityClass, resourceType, parameters);
	}

	/**
	 * {inheritDoc} 
	 */
	@Override
	public ModelMapperFunction<FunctionMember, FunctionMemberResource> getAdminMapperToResourceFunction() {
		return functionMemberMapperToResource;
	}

}
