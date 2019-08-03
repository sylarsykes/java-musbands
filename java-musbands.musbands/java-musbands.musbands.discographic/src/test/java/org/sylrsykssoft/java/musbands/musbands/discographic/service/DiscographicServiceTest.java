package org.sylrsykssoft.java.musbands.musbands.discographic.service;

//import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;

import java.time.Year;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.sylrsykssoft.java.musbands.musbands.discographic.DiscographicApplicationTests;
import org.sylrsykssoft.java.musbands.musbands.discographic.configuration.DiscographicTestsConfiguration;
import org.sylrsykssoft.java.musbands.musbands.discographic.resource.DiscographicResource;

/**
 * Musical genre service test.
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */

@SpringBootTest(classes = { DiscographicApplicationTests.class })
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { DiscographicTestsConfiguration.class, }, loader = AnnotationConfigContextLoader.class)
public class DiscographicServiceTest {

	@Autowired
	DiscographicService discographicService;

	DiscographicResource domain;

	Example<DiscographicResource> example;

	@BeforeEach
	public void setUp() {
		String name = "Visible Noise";
		String description = "Visible Noise is a British independent record label that focuses solely on British bands.";
		Short startYear = 1998;
		String founder = "Julie Weir";
		String website = "http://www.visiblenoise.com/";

		domain = DiscographicResource.discographicResourceBuilder().name(name).description(description)
				.startYear(Year.of(startYear)).founder(founder).website(website).build();

		example = Example.of(domain, ExampleMatcher.matchingAll());
	}

	@Test
	public void testCreateDiscographic() {
		String name = "Visible Noise";
		final DiscographicResource musicalGenreSaved = discographicService.save(domain);

		assertThat("Entity did not get an generated Id!", musicalGenreSaved.getEntityId(), greaterThan((long) -1));
		assertThat("Entity name did not match!", musicalGenreSaved.getName(), is(name));

	}

	@Test
	public void testFindAllDiscographics() {
		Iterable<DiscographicResource> musicalGenres = discographicService.findAll();
		assertNotNull(musicalGenres);
	}

	// @see
	// https://www.logicbig.com/tutorials/spring-framework/spring-data/query-example-matchers.html
	@Test
	public void testFindOneByExampleDiscographic() {
		Optional<DiscographicResource> optResource = discographicService.findByExample(example);
		assertNotNull(optResource.get());
	}

	@Test
	public void testUpdateDiscographic() {
		String name = "Visible Noise";
		Optional<DiscographicResource> optResource = discographicService.findById((long) 1);

		DiscographicResource resourceGet = optResource.orElseThrow(IllegalStateException::new);

		assertThat("Entity name did not match!", resourceGet.getName(), is(name));

		DiscographicResource resourceUpdated = discographicService
				.save(DiscographicResource.discographicResourceBuilder().entityId(resourceGet.getEntityId())
						.name(resourceGet.getName()).description(resourceGet.getDescription() + " El ir.").build());

		assertThat("Entity id did not match!", resourceUpdated.getEntityId(), is(resourceGet.getEntityId()));
	}

	@Test
	public void testDeleteDiscographic() {
		String name = "Visible Noise";
		Optional<DiscographicResource> optResource = discographicService.findById((long) 1);

		DiscographicResource source = optResource.orElseThrow(IllegalStateException::new);

		assertThat("Entity name did not match!", source.getName(), is(name));

		discographicService.delete(source);
	}

}
