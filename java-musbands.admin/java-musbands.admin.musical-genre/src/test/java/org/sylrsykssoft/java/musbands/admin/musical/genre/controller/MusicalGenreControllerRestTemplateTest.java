package org.sylrsykssoft.java.musbands.admin.musical.genre.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.sylrsykssoft.coreapi.framework.web.BaseAdminRestTemplateController;
import org.sylrsykssoft.java.musbands.admin.musical.genre.MusicalGenreApplicationTests;
import org.sylrsykssoft.java.musbands.admin.musical.genre.configuration.MusicalGenreTestsConfiguration;
import org.sylrsykssoft.java.musbands.admin.musical.genre.domain.MusicalGenre;
import org.sylrsykssoft.java.musbands.admin.musical.genre.resource.MusicalGenreResource;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Musical genre controller test
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@SpringBootTest(classes = { MusicalGenreApplicationTests.class })
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { MusicalGenreTestsConfiguration.class, }, loader = AnnotationConfigContextLoader.class)
public class MusicalGenreControllerRestTemplateTest {

	@Autowired
	BaseAdminRestTemplateController<MusicalGenreResource, MusicalGenre> baseAdminControllerRestTemplate;

//	@Value("${coreapi-framework.web.base.entity.controller.base.path}")
//	String basePath;
	
	MusicalGenreResource domain;
	
	MusicalGenreResource domainForUdpate;
	
	@BeforeEach
	public void setUp() {
		String name = "Punk rock";
		String description = "Punk rock (or \"punk\") is a rock music genre that emerged in the mid-1970s in the United States, United Kingdom, and Australia. Rooted in 1960s garage rock and other forms of what is now known as \"proto-punk\" music, punk rock bands rejected perceived excesses of mainstream 1970s rock. They typically produced short, fast-paced songs with hard-edged melodies and singing styles, stripped-down instrumentation, and often political, anti-establishment lyrics. Punk embraces a DIY ethic; many bands self-produce recordings and distribute them through independent record labels. ";

		domain = MusicalGenreResource.musicalGenreResourceBuilder().name(name).description(description).build();
		
		domainForUdpate = MusicalGenreResource.musicalGenreResourceBuilder().entityId(3).name(name).description(description + " erop").build();
	}

	public static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Test
	public void testFindById() throws Exception {
		// call GET /admin/musicalGenres/{id} application/json
//		Optional<MusicalGenreResource> result = (Optional<MusicalGenreResource>) baseAdminControllerRestTemplate.findById("http://localhost:8083/api/admin/v1", 1, Optional.class);
//		assertNotNull(result, "Empty value");
	}
	
}
