package org.sylrsykssoft.java.musbands.musbands.band.admin.resource;

import java.time.LocalDateTime;

import org.sylrsykssoft.coreapi.framework.api.resource.BaseAdminResource;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO BandMusicalGenreResource
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Data
@Builder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Setter
@Getter
@EqualsAndHashCode(callSuper = false, doNotUseGetters = true)
public class BandMusicalGenreResource extends BaseAdminResource {
	
	/**
	 * AllArgsConstructor
	 * 
	 * @param entityId
	 * @param name
	 * @param description
	 * @param createdAt
	 * @param updatedAt
	 * 
	 * @see BandMusicalGenreConstants.RESOURCE_BUILDER_NAME
	 */
	@Builder(builderMethodName = "bandMusicalGenreResourceBuilder")
	public BandMusicalGenreResource(final Integer entityId, final String name, final String description, final LocalDateTime createdAt, final LocalDateTime updatedAt, final LocalDateTime removedAt) {
		super(entityId, name, description, createdAt, updatedAt, removedAt);
	}
}
