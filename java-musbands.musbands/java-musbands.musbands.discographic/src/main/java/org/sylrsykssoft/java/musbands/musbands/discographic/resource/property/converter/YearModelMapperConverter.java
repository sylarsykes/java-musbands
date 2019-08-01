package org.sylrsykssoft.java.musbands.musbands.discographic.resource.property.converter;

import java.time.Year;

import org.modelmapper.Converters.Converter;

/**
 * @author Juan
 *
 */
public class YearModelMapperConverter implements Converter<Short, Year> {

	@Override
	public Year convert(Short source) {
		if (source != null) {
			return Year.of(source);
		}
		return null;
	}

}
