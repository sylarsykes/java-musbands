package org.sylrsykssoft.java.musbands.musbands.discographic.domain;

import java.time.Year;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

import org.hibernate.validator.constraints.URL;
import org.springframework.lang.Nullable;
import org.sylrsykssoft.coreapi.framework.api.model.BaseEntity;
import org.sylrsykssoft.coreapi.framework.database.model.listener.BaseListener;
import org.sylrsykssoft.java.musbands.musbands.discographic.configuration.DiscographicConstants;
import org.sylrsykssoft.java.musbands.musbands.discographic.domain.converter.YearAttributeConverter;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;


/**
 * Entity discographic
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Table(name = DiscographicConstants.REPOSITORY_TABLE_NAME)
@Entity(name = DiscographicConstants.REPOSITORY_ENTITY_NAME)
@Data
@Builder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Setter
@Getter
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@EntityListeners({BaseListener.class})
public class Discographic extends BaseEntity {
	
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
	@Convert(converter = YearAttributeConverter.class, attributeName = "startYear")
	private @NonNull Year startYear;
	
	@Column(name = "founder", nullable = true, length = MAX_LENGTH_NAME)
	private @Nullable String founder;
	
	@Column(name = "country", nullable = true, length = MAX_LENGTH_NAME)
	private @Nullable String country;

	@Column(name = "end_year", nullable = true, columnDefinition = "SMALLINT")
    @Convert(converter = YearAttributeConverter.class, attributeName = "endYear")
	private @Nullable Year endYear;
	
	@Column(name = "website", nullable = true, length = MAX_LENGTH_NAME)
	@URL
	private @Nullable String website;
	
	@SuppressWarnings("rawtypes")
	public static class DiscographicBuilder extends BaseEntityBuilder {
		
		public DiscographicBuilder startYear(final Short startYear) {
			return startYear(Year.of(startYear));
		}
		
		public DiscographicBuilder startYear(final Year startYear) {
			this.startYear = startYear;
			return this;
		}
		
		public DiscographicBuilder endYear(final Short endYear) {
			return endYear(Year.of(endYear));
		}
		
		public DiscographicBuilder endYear(final Year endYear) {
			this.endYear = endYear;
			return this;
		}

		@Override
		protected DiscographicBuilder self() {
			return this;
		}
	}
	
}
