package org.sylrsykssoft.java.musbands.admin.musical.genre.domain;

import java.beans.ConstructorProperties;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

import org.sylrsykssoft.coreapi.framework.api.model.BaseAdmin;
import org.sylrsykssoft.coreapi.framework.database.model.listener.BaseListener;
import org.sylrsykssoft.java.musbands.admin.musical.genre.configuration.MusicalGenreConstants;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity musical genre
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Table(name = MusicalGenreConstants.REPOSITORY_TABLE_NAME)
@Entity(name = MusicalGenreConstants.REPOSITORY_ENTITY_NAME)
@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Setter
@Getter
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@EntityListeners({BaseListener.class})
public class MusicalGenre extends BaseAdmin {

	/**
	 * AllArgsConstructor
	 * 
	 * @param entityId
	 * @param name
	 * @param description
	 * @param synonyms
	 * @param createdAt
	 * @param updatedAt
	 * @param removedAt
	 */
	@Builder(builderMethodName = "musicalGenreBuilder")
	@ConstructorProperties({ "entityId", "name", "description", "synonyms", "createdAt", "updatedAt", "removedAt" })
	public MusicalGenre(Integer entityId, String name, String description, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime removedAt) {
		super(entityId, name, description, createdAt, updatedAt, removedAt);
	}
}
