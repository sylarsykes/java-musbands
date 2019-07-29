package org.sylrsykssoft.java.musbands.admin.function.member.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.sylrsykssoft.coreapi.framework.library.mapper.ModelMapperFunction;
import org.sylrsykssoft.java.musbands.admin.function.member.controller.FunctionMemberController;
import org.sylrsykssoft.java.musbands.admin.function.member.domain.FunctionMember;
import org.sylrsykssoft.java.musbands.admin.function.member.resource.FunctionMemberResource;
import org.sylrsykssoft.java.musbands.admin.function.member.resource.assembler.FunctionMemberResourceAssembler;

/**
 * FunctionMemberMapperConfiguration
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Configuration
public class FunctionMemberMapperConfiguration {

	/**
	 * FunctionMember mapper function.
	 *
	 * @return the model mapper function
	 */
	@Bean(FunctionMemberConstants.MAPPER_RESOURCE_FUNCTION)
	@Lazy(value = true)
	public ModelMapperFunction<FunctionMember, FunctionMemberResource> functionMemberMapperToResourceFunction() {
		return new ModelMapperFunction<FunctionMember, FunctionMemberResource>(FunctionMember.class, FunctionMemberResource.class);
	}

	/**
	 * FunctionMember mapper function.
	 *
	 * @return the model mapper function
	 */
	@Bean(FunctionMemberConstants.MAPPER_RESOURCE_ASSEMBLER)
	@Lazy(value = true)
	public FunctionMemberResourceAssembler functionMemberResourceAssembler() {
		return new FunctionMemberResourceAssembler(FunctionMemberController.class, FunctionMember.class, FunctionMemberResource.class);
	}
	
	/**
	 * FunctionMember mapper function.
	 *
	 * @return the model mapper function
	 */
	@Bean(FunctionMemberConstants.MAPPER_ENTITY_FUNCTION)
	@Lazy(value = true)
	public ModelMapperFunction<FunctionMemberResource, FunctionMember> functionMemberMapperToEntityFunction() {
		return new ModelMapperFunction<FunctionMemberResource, FunctionMember>(FunctionMemberResource.class, FunctionMember.class);
	}
	
}
