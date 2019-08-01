package org.sylrsykssoft.java.musbands.musbands.discographic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Service;
import org.sylrsykssoft.coreapi.framework.database.repository.BaseEntityRepository;
import org.sylrsykssoft.coreapi.framework.library.mapper.ModelMapperFunction;
import org.sylrsykssoft.coreapi.framework.service.BaseEntityService;
import org.sylrsykssoft.java.musbands.musbands.discographic.configuration.DiscographicConstants;
import org.sylrsykssoft.java.musbands.musbands.discographic.domain.Discographic;
import org.sylrsykssoft.java.musbands.musbands.discographic.repository.DiscographicRepository;
import org.sylrsykssoft.java.musbands.musbands.discographic.resource.DiscographicResource;
import org.sylrsykssoft.java.musbands.musbands.discographic.resource.assembler.DiscographicResourceAssembler;

/**
 * MusicalGenreService service.
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 * @param <T> Type class.
 */
@Service(DiscographicConstants.SERVICE_NAME)
public class DiscographicService extends BaseEntityService<Discographic, DiscographicResource> {

	@Autowired
	private DiscographicRepository musicalGenreRepository;
	
	/** Mapper resource bean */
	@Autowired
	@Qualifier(DiscographicConstants.MAPPER_RESOURCE_ASSEMBLER)
	private DiscographicResourceAssembler discographicMapperToResource;
	
	/** Mapper entity bean */
	@Autowired
	@Qualifier(DiscographicConstants.MAPPER_ENTITY_FUNCTION)
	private ModelMapperFunction<DiscographicResource, Discographic> discographicMapperToEntity;
	
	/**
	 * {@inheritDoc}
	 */
	public BaseEntityRepository<Discographic> getEntityRepository() {
		return musicalGenreRepository;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResourceAssemblerSupport<Discographic, DiscographicResource> mapperToResource() {
		return discographicMapperToResource;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public ModelMapperFunction<DiscographicResource, Discographic> mapperToEntity() {
		return discographicMapperToEntity;
	}
}