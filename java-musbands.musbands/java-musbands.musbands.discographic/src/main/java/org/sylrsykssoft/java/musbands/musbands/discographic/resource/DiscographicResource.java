package org.sylrsykssoft.java.musbands.musbands.discographic.resource;

import java.time.LocalDateTime;
import java.time.Year;

import org.springframework.lang.Nullable;
import org.sylrsykssoft.coreapi.framework.api.resource.BaseEntityResource;

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
@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Setter
@Getter
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
public class DiscographicResource extends BaseEntityResource {

	private @NonNull String name;
	private @Nullable String description;
	private @NonNull Year startYear;
	private @Nullable String founder;
	private @Nullable String country;
	private @Nullable Year endYear;
	private @Nullable String website;

	@Builder(builderMethodName = "discographicResourceBuilder")
	public DiscographicResource(final Long entityId, String name, String description, Year startYear, String founder,
			String country, Year endYear, String website, final LocalDateTime createdAt,
			final LocalDateTime updatedAt) {
		super(entityId, createdAt, updatedAt);
		this.name = name;
		this.description = description;
		this.startYear = startYear;
		this.founder = founder;
		this.endYear = endYear;
		this.website = website;
	}
}
