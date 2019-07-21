package org.sylrsykssoft.java.musbands.admin.function.member.resource;

import java.time.LocalDateTime;
import java.util.Set;

import org.sylrsykssoft.coreapi.framework.api.resource.BaseAdminResource;
import org.sylrsykssoft.java.musbands.admin.function.member.configuration.FunctionMemberConstants;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;

/**
 * DTO BaseAdmin
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Setter
@Getter
@EqualsAndHashCode(callSuper = false, doNotUseGetters = true)
public class FunctionMemberResource extends BaseAdminResource {

	private @Singular Set<FunctionMemberSynonymicResource> synonyms;
	
	/**
	 * AllArgsConstructor
	 * 
	 * @param entityId
	 * @param name
	 * @param description
	 * @param createdAt
	 * @param updatedAt
	 * 
	 * @see FunctionMemberConstants.RESOURCE_BUILDER_NAME
	 */
	@Builder(builderMethodName = "functionMemberResourceBuilder")
	public FunctionMemberResource(final Integer entityId, final String name, final String description, final Set<FunctionMemberSynonymicResource> synonyms,
			final LocalDateTime createdAt, final LocalDateTime updatedAt, final LocalDateTime removedAt) {
		super(entityId, name, description, createdAt, updatedAt, removedAt);
		this.synonyms = synonyms;
	}
}
