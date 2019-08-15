package org.sylrsykssoft.java.musbands.musbands.band.admin.domain;

import java.beans.ConstructorProperties;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.sylrsykssoft.coreapi.framework.api.model.BaseAdmin;
import org.sylrsykssoft.coreapi.framework.database.model.listener.BaseListener;
import org.sylrsykssoft.java.musbands.musbands.band.configuration.BandMusicalGenreConstants;
import org.sylrsykssoft.java.musbands.musbands.band.domain.Band;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity band_musical_genre
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Table(name = BandMusicalGenreConstants.REPOSITORY_TABLE_NAME)
@Entity(name = BandMusicalGenreConstants.REPOSITORY_ENTITY_NAME)
@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Setter
@Getter
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@EntityListeners({BaseListener.class})
public class BandMusicalGenre extends BaseAdmin {

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_band", nullable = false, updatable = false)
	private Band band;
	
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
	@Builder(builderMethodName = "bandMusicalGenreBuilder")
	@ConstructorProperties({ "entityId", "name", "description", "synonyms", "createdAt", "updatedAt", "removedAt" })
	public BandMusicalGenre(Integer entityId, String name, String description, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime removedAt) {
		super(entityId, name, description, createdAt, updatedAt, removedAt);
	}

}
