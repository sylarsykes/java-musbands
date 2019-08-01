package org.sylrsykssoft.java.musbands.musbands.discographic.domain.converter;

import java.time.Year;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class YearAttributeConverter implements AttributeConverter<Year, Short> {
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Short convertToDatabaseColumn(Year attribute) {
		if (attribute != null) {
			return (short) attribute.getValue();
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Year convertToEntityAttribute(Short dbData) {
		if (dbData != null) {
			return Year.of(dbData);
		}
		return null;
	}
}
