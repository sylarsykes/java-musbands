package org.sylrsykssoft.java.musbands.admin.musical.genre.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.sylrsykssoft.java.musbands.admin.musical.genre.MusicalGenreApplicationTests;
import org.sylrsykssoft.java.musbands.admin.musical.genre.configuration.MusicalGenreTestsConfiguration;
import org.sylrsykssoft.java.musbands.admin.musical.genre.resource.MusicalGenreResource;

/**
 * Musical genre service test.
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { MusicalGenreApplicationTests.class })
@ContextConfiguration(classes = { MusicalGenreTestsConfiguration.class, }, loader = AnnotationConfigContextLoader.class)
public class MusicalGenreServiceTest {

	@Autowired
	MusicalGenreService musicalGenreService;

	MusicalGenreResource domain;
	
	Example<MusicalGenreResource> example;
	
	@Before
	public void setUp() {
		String name = "Pop punk";
		String description = "Pop punk (also known as punk-pop) is a music genre that fuses elements of pop music with punk rock. Fast tempos, loud electric guitar distortion, and power chord changes are typically played under pop-influenced melodies, vocal styles with lighthearted lyrical themes including boredom and teenage romance.";

		domain = MusicalGenreResource.musicalGenreResourceBuilder().name(name).description(description).build();
		
		example = Example.of(domain, ExampleMatcher.matchingAll());
	}

	@Test
	public void testCreateMusicalGenre() {
		String name = "Pop punk";
		final MusicalGenreResource musicalGenreSaved = musicalGenreService.save(domain);

		assertThat("Entity did not get an generated Id!", musicalGenreSaved.getEntityId(), greaterThan(-1));
        assertThat("Entity name did not match!", musicalGenreSaved.getName(), is(name));
		
	}
	
	@Test
	public void testFindAllMusicalGenres() {
		Iterable<MusicalGenreResource> musicalGenres = musicalGenreService.findAll();
		Assert.assertNotNull(musicalGenres);
	}
	
	// @see https://www.logicbig.com/tutorials/spring-framework/spring-data/query-example-matchers.html
	@Test
	public void testFindOneByExampleMusicalGenre() {
		Optional<MusicalGenreResource> optResource = musicalGenreService.findByExample(example);
		Assert.assertNotNull(optResource.get());
	}
	
	@Test
	public void testUpdateMusicalGenre() {
		String name = "Pop punk";
		Optional<MusicalGenreResource> optResource = musicalGenreService.findByName(name);
		
		MusicalGenreResource resourceGet = optResource.orElseThrow(IllegalStateException::new);
		
		assertThat("Entity name did not match!", resourceGet.getName(), is(name));
		
		MusicalGenreResource resourceUpdated = musicalGenreService.save(MusicalGenreResource.musicalGenreResourceBuilder().entityId(resourceGet.getEntityId()).name(resourceGet.getName())
				.description(resourceGet.getDescription() + " El ir.").build());
		
		assertThat("Entity id did not match!", resourceUpdated.getEntityId(), is(resourceGet.getEntityId()));
	}
	
	@Test
	public void testDeleteMusicalGenre() {
		String name = "Pop punk";
		Optional<MusicalGenreResource> optResource = musicalGenreService.findByName(name);
		
		MusicalGenreResource source = optResource.orElseThrow(IllegalStateException::new);
		
		assertThat("Entity name did not match!", source.getName(), is(name));
		
		musicalGenreService.delete(source);
	}

}
