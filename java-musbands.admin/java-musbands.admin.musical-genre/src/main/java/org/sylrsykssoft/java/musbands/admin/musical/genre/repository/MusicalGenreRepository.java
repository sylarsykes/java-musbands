package org.sylrsykssoft.java.musbands.admin.musical.genre.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Component;
import org.sylrsykssoft.coreapi.framework.database.repository.BaseAdminRepository;
import org.sylrsykssoft.java.musbands.admin.musical.genre.configuration.MusicalGenreConstants;
import org.sylrsykssoft.java.musbands.admin.musical.genre.domain.MusicalGenre;

@Component("musicalGenreRepository")
@RepositoryRestResource(collectionResourceRel = MusicalGenreConstants.REPOSITORY_REST_COLLECTION_RESOURCE_REL, path = MusicalGenreConstants.REPOSITORY_REST_RESOURCE_PATH)
@Transactional
public interface MusicalGenreRepository extends BaseAdminRepository<MusicalGenre> {

	/**
	 * Find by name.
	 * 
	 * @param name Value of the attribute name
	 * 
	 * @return T entity.
	 */
	@Query("select e from #{#entityName} e where e.name = :name and e.removedAt IS NULL")
	Optional<MusicalGenre> findByName(final String name);
}
