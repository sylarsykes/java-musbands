package org.sylrsykssoft.java.musbands.admin.musical.genre.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Service;
import org.sylrsykssoft.coreapi.framework.database.exception.NotFoundEntityException;
import org.sylrsykssoft.coreapi.framework.database.repository.BaseAdminRepository;
import org.sylrsykssoft.coreapi.framework.library.mapper.ModelMapperFunction;
import org.sylrsykssoft.coreapi.framework.service.BaseAdminService;
import org.sylrsykssoft.java.musbands.admin.musical.genre.configuration.MusicalGenreConstants;
import org.sylrsykssoft.java.musbands.admin.musical.genre.domain.MusicalGenre;
import org.sylrsykssoft.java.musbands.admin.musical.genre.repository.MusicalGenreRepository;
import org.sylrsykssoft.java.musbands.admin.musical.genre.resource.MusicalGenreResource;
import org.sylrsykssoft.java.musbands.admin.musical.genre.resource.assembler.MusicalGenreResourceAssembler;

/**
 * MusicalGenreService service.
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 * @param <T> Type class.
 */
@Service(MusicalGenreConstants.SERVICE_NAME)
@CacheConfig(cacheNames = MusicalGenreConstants.CACHE_NAME, cacheManager = MusicalGenreConstants.CACHE_MANGER_BEAN_NAME)
public class MusicalGenreService extends BaseAdminService<MusicalGenre, MusicalGenreResource> {

	@Autowired
	private MusicalGenreRepository musicalGenreRepository;
	
	/** Mapper resource bean */
	@Autowired
	@Qualifier(MusicalGenreConstants.MAPPER_RESOURCE_ASSEMBLER)
	private MusicalGenreResourceAssembler musicalGenreMapperToResource;
	
	/** Mapper entity bean */
	@Autowired
	@Qualifier(MusicalGenreConstants.MAPPER_ENTITY_FUNCTION)
	private ModelMapperFunction<MusicalGenreResource, MusicalGenre> musicalGenreMapperToEntity;
	
	/**
	 * {@inheritDoc}
	 */
	public BaseAdminRepository<MusicalGenre> getAdminRepository() {
		return musicalGenreRepository;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	@Cacheable(value = MusicalGenreConstants.CACHE_NAME, key = "#root.method", unless = "#result == null")
	public Optional<MusicalGenreResource> findByName(final String name) throws NotFoundEntityException {
		return super.findByName(name);
	}
	
	/**
	 * Find all musical genres
	 * 
	 * Refresh all the entries in the cache to load new ones
	 */
	@Override
	@Cacheable(value = MusicalGenreConstants.CACHE_NAME, key = "#root.method", unless = "#result == null")
	public List<MusicalGenreResource> findAll() {
		return super.findAll();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResourceAssemblerSupport<MusicalGenre, MusicalGenreResource> mapperToResource() {
		return musicalGenreMapperToResource;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public ModelMapperFunction<MusicalGenreResource, MusicalGenre> mapperToEntity() {
		return musicalGenreMapperToEntity;
	}
	
}