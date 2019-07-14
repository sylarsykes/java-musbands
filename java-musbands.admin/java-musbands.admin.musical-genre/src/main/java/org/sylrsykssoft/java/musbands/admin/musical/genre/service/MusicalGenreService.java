package org.sylrsykssoft.java.musbands.admin.musical.genre.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.sylrsykssoft.coreapi.framework.database.exception.NotFoundEntityException;
import org.sylrsykssoft.coreapi.framework.library.mapper.ModelMapperFunction;
import org.sylrsykssoft.coreapi.framework.service.BaseAdminService;
import org.sylrsykssoft.java.musbands.admin.musical.genre.domain.MusicalGenre;
import org.sylrsykssoft.java.musbands.admin.musical.genre.resource.MusicalGenreResource;

/**
 * MusicalGenreService service.
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 * @param <T> Type class.
 */
@Service("musicalGenreService")
public class MusicalGenreService extends BaseAdminService<MusicalGenre, MusicalGenreResource> {

	@Autowired
	@Qualifier("musicalGenreMapperToResourceFunction")
	private ModelMapperFunction<MusicalGenre, MusicalGenreResource> musicalGenreMapperToResource;
	
	@Autowired
	@Qualifier("musicalGenreMapperToEntityFunction")
	private ModelMapperFunction<MusicalGenreResource, MusicalGenre> musicalGenreMapperToEntity;
	
	/**
	 * Find musical genre by name
	 * 
	 * Refresh all the entries in the cache to load new ones
	 */
	@Override()
	public Optional<MusicalGenreResource> findByName(final String name) throws NotFoundEntityException {
		return super.findByName(name);
	}


	/**
	 * Find all musical genres
	 * 
	 * Refresh all the entries in the cache to load new ones
	 */
	@Override
	public List<MusicalGenreResource> findAll() {
		return super.findAll();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ModelMapperFunction<MusicalGenre, MusicalGenreResource> mapperToResource() {
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