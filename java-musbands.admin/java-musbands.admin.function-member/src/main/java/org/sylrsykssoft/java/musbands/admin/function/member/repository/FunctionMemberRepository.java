package org.sylrsykssoft.java.musbands.admin.function.member.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Component;
import org.sylrsykssoft.coreapi.framework.database.repository.BaseAdminRepository;
import org.sylrsykssoft.java.musbands.admin.function.member.configuration.FunctionMemberConstants;
import org.sylrsykssoft.java.musbands.admin.function.member.domain.FunctionMember;

@Component(FunctionMemberConstants.REPOSITORY_NAME)
@RepositoryRestResource(collectionResourceRel = FunctionMemberConstants.REPOSITORY_REST_COLLECTION_RESOURCE_REL, path = FunctionMemberConstants.REPOSITORY_REST_RESOURCE_PATH)
@Transactional
public interface FunctionMemberRepository extends BaseAdminRepository<FunctionMember> {

	/**
	 * Find by name.
	 * 
	 * @param name Value of the attribute name
	 * 
	 * @return T entity.
	 */
	@Query("select e from #{#entityName} e where e.name = :name and e.removedAt IS NULL")
	Optional<FunctionMember> findByName(final String name);
}
