package org.sylrsykssoft.java.musbands.musbands.band.repository;

import javax.transaction.Transactional;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Component;
import org.sylrsykssoft.coreapi.framework.database.repository.BaseEntityRepository;
import org.sylrsykssoft.java.musbands.musbands.band.configuration.BandConstants;
import org.sylrsykssoft.java.musbands.musbands.band.domain.Band;

@Component(BandConstants.REPOSITORY_NAME)
@RepositoryRestResource(collectionResourceRel = BandConstants.REPOSITORY_REST_COLLECTION_RESOURCE_REL, path = BandConstants.REPOSITORY_REST_RESOURCE_PATH)
@Transactional
public interface BandRepository extends BaseEntityRepository<Band> {

}
