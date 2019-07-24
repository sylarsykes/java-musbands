package org.sylrsykssoft.java.musbands.admin.function.member.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.sylrsykssoft.coreapi.framework.database.exception.NotFoundEntityException;
import org.sylrsykssoft.coreapi.framework.database.repository.BaseAdminRepository;
import org.sylrsykssoft.coreapi.framework.library.mapper.ModelMapperFunction;
import org.sylrsykssoft.coreapi.framework.service.BaseAdminService;
import org.sylrsykssoft.java.musbands.admin.function.member.configuration.FunctionMemberConstants;
import org.sylrsykssoft.java.musbands.admin.function.member.domain.FunctionMember;
import org.sylrsykssoft.java.musbands.admin.function.member.repository.FunctionMemberRepository;
import org.sylrsykssoft.java.musbands.admin.function.member.resource.FunctionMemberResource;

/**
 * FunctionMemberService service.
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 * @param <T> Type class.
 */
@Service(FunctionMemberConstants.SERVICE_NAME)
@CacheConfig(cacheNames = FunctionMemberConstants.CACHE_NAME, cacheManager = FunctionMemberConstants.CACHE_MANGER_BEAN_NAME)
public class FunctionMemberService extends BaseAdminService<FunctionMember, FunctionMemberResource> {

	@Autowired
	private FunctionMemberRepository functionMemberRepository;
	
	/** Mapper resource bean */
	@Autowired
	@Qualifier(FunctionMemberConstants.MAPPER_RESOURCE_FUNCTION)
	private ModelMapperFunction<FunctionMember, FunctionMemberResource> functionMemberMapperToResource;
	
	/** Mapper entity bean */
	@Autowired
	@Qualifier(FunctionMemberConstants.MAPPER_ENTITY_FUNCTION)
	private ModelMapperFunction<FunctionMemberResource, FunctionMember> functionMemberMapperToEntity;

	/**
	 * {@inheritDoc}
	 */
	public BaseAdminRepository<FunctionMember> getAdminRepository() {
		return functionMemberRepository;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	@Cacheable(value = FunctionMemberConstants.CACHE_NAME, key = "#root.method", unless = "#result == null")
	public Optional<FunctionMemberResource> findByName(final String name) throws NotFoundEntityException {
		return super.findByName(name);
	}
	
	/**
	 * Find all function members
	 * 
	 * Refresh all the entries in the cache to load new ones
	 */
	@Override
	@Cacheable(value = FunctionMemberConstants.CACHE_NAME, key = "#root.method", unless = "#result == null")
	public List<FunctionMemberResource> findAll() {
		return super.findAll();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ModelMapperFunction<FunctionMember, FunctionMemberResource> mapperToResource() {
		return functionMemberMapperToResource;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public ModelMapperFunction<FunctionMemberResource, FunctionMember> mapperToEntity() {
		return functionMemberMapperToEntity;
	}
	
}