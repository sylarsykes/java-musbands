package org.sylrsykssoft.java.musbands.admin.function.member.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.sylrsykssoft.coreapi.framework.library.mapper.ModelMapperFunction;
import org.sylrsykssoft.java.musbands.admin.function.member.domain.FunctionMember;
import org.sylrsykssoft.java.musbands.admin.function.member.resource.FunctionMemberResource;

/**
 * FunctionMemberMapperConfiguration
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Configuration
public class FunctionMemberMapperConfiguration {

	/**
	 * Model mapper bean
	 * @return
	 */
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
	
	/**
	 * FunctionMember mapper function.
	 *
	 * @return the model mapper function
	 */
	@Bean(FunctionMemberConstants.MAPPER_RESOURCE_FUNCTION)
	@Scope(value = "prototype")
	@Lazy(value = true)
	public ModelMapperFunction<FunctionMember, FunctionMemberResource> FunctionMemberMapperToResourceFunction() {
		return new ModelMapperFunction<FunctionMember, FunctionMemberResource>(FunctionMember.class, FunctionMemberResource.class);
	}
	
	/**
	 * FunctionMember mapper function.
	 *
	 * @return the model mapper function
	 */
	@Bean(FunctionMemberConstants.MAPPER_ENTITY_FUNCTION)
	@Scope(value = "prototype")
	@Lazy(value = true)
	public ModelMapperFunction<FunctionMemberResource, FunctionMember> FunctionMemberMapperToEntityFunction() {
		return new ModelMapperFunction<FunctionMemberResource, FunctionMember>(FunctionMemberResource.class, FunctionMember.class);
	}
}
