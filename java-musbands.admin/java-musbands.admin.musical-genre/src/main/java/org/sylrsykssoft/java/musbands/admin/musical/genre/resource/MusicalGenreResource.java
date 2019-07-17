package org.sylrsykssoft.java.musbands.admin.musical.genre.resource;

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
 * DTO BaseAdmin
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
public class MusicalGenreResource extends BaseAdminResource {
	
	/**
	 * AllArgsConstructor
	 * 
	 * @param entityId
	 * @param name
	 * @param description
	 * @param createdAt
	 * @param updatedAt
	 * 
	 * @see MusicalGenreConstants.RESOURCE_BUILDER_NAME
	 */
	@Builder(builderMethodName = "musicalGenreResourceBuilder")
	public MusicalGenreResource(final Integer entityId, final String name, final String description, final LocalDateTime createdAt, final LocalDateTime updatedAt, final LocalDateTime removedAt) {
		super(entityId, name, description, createdAt, updatedAt, removedAt);
	}
}
