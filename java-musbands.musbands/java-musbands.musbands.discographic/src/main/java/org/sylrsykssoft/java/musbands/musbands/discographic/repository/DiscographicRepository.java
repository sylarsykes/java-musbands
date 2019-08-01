package org.sylrsykssoft.java.musbands.musbands.discographic.repository;

import javax.transaction.Transactional;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Component;
import org.sylrsykssoft.coreapi.framework.database.repository.BaseEntityRepository;
import org.sylrsykssoft.java.musbands.musbands.discographic.configuration.DiscographicConstants;
import org.sylrsykssoft.java.musbands.musbands.discographic.domain.Discographic;

@Component(DiscographicConstants.REPOSITORY_NAME)
@RepositoryRestResource(collectionResourceRel = DiscographicConstants.REPOSITORY_REST_COLLECTION_RESOURCE_REL, path = DiscographicConstants.REPOSITORY_REST_RESOURCE_PATH)
@Transactional
public interface DiscographicRepository extends BaseEntityRepository<Discographic> {

}
