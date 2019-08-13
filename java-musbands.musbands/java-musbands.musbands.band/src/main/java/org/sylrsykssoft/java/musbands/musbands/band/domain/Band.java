package org.sylrsykssoft.java.musbands.musbands.band.domain;

import java.time.Year;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.URL;
import org.springframework.lang.Nullable;
import org.sylrsykssoft.coreapi.framework.api.model.BaseEntity;
import org.sylrsykssoft.coreapi.framework.database.model.listener.BaseListener;
import org.sylrsykssoft.java.musbands.musbands.band.configuration.BandConstants;
import org.sylrsykssoft.java.musbands.musbands.discographic.domain.Discographic;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.Singular;

/**
 * Entity band
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Table(name = BandConstants.REPOSITORY_TABLE_NAME)
@Entity(name = BandConstants.REPOSITORY_ENTITY_NAME)
@Data
@Builder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Setter
@Getter
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@EntityListeners({BaseListener.class})
public class Band extends BaseEntity {
	
	public static final int MAX_LENGTH_NAME = 255;
	public static final int MAX_LENGTH_DESCRIPTION = 10000;
	
	// UTF8 requires 3 bytes per character to store the string, 
	// so in your case 20 + 500 characters = 20*3+500*3 = 1560 bytes which is more than allowed 767 bytes. 
	// The limit for UTF8 is 767/3 = 255 characters
	@Column(name = "name", nullable = false, unique = true, length = MAX_LENGTH_NAME)
	private @NonNull String name;
	
	@Column(name = "descriptiom", nullable = true, columnDefinition = "TEXT", length = MAX_LENGTH_DESCRIPTION)
	private @Nullable String description;

	@Column(name = "start_year", nullable = false, columnDefinition = "SMALLINT")
	private @NonNull Year startYear;
	
	@Column(name = "origin", nullable = true, length = MAX_LENGTH_NAME)
	private @Nullable String origin;
	
	@Column(name = "country", nullable = true, length = MAX_LENGTH_NAME)
	private @Nullable String country;

	@Column(name = "end_year", nullable = true, columnDefinition = "SMALLINT")
	private @Nullable Year endYear;
	
	@Column(name = "website", nullable = true, length = MAX_LENGTH_NAME)
	@URL
	private @Nullable String website;
	
	
	// Relationships
	@ManyToMany
	@JoinTable(name = "discographic_bands", 
		joinColumns = @JoinColumn(name = "fk_band_id", referencedColumnName = "id"), 
		inverseJoinColumns = @JoinColumn(name = "fk_discographic_id", referencedColumnName = "id"))
    private @Singular Set<Discographic> discographics;
	
    @OneToMany(mappedBy = "band")
	private @Singular Set<BandMusicalGenre> musicalGenres;
    
    public static class BandBuilder extends BaseEntityBuilder {
    	
    }
}
