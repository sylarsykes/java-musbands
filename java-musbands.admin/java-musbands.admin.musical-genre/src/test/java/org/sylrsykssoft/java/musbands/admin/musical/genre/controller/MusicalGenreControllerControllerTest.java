package org.sylrsykssoft.java.musbands.admin.musical.genre.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.sylrsykssoft.java.musbands.admin.musical.genre.MusicalGenreApplicationTests;
import org.sylrsykssoft.java.musbands.admin.musical.genre.configuration.MusicalGenreConstants;
import org.sylrsykssoft.java.musbands.admin.musical.genre.configuration.MusicalGenreTestsConfiguration;
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
public class MusicalGenreControllerControllerTest {

	private MockMvc mockMvc;

	@Autowired
	MusicalGenreControllerTest musicalGenreController;

	MusicalGenreResource domain;
	
	MusicalGenreResource domainForUdpate;
	
	@BeforeEach
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(musicalGenreController).build();

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
	public void testFindAll() throws Exception {

//		when(musicalGenreService.findAll()).thenReturn(Arrays.asList(new MusicalGenreResource()));

		// call GET /admin/musicalGenres application/json
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(MusicalGenreConstants.CONTROLLER_REQUEST_MAPPING_TEST)
				.accept(MediaType.APPLICATION_JSON_VALUE);

		MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andDo(print()).andReturn();

		assertNotNull(result.getResponse(), "Empty value");
	}

	@Test
	public void testFindById() throws Exception {
		// call GET /admin/musicalGenres/{id} application/json
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(MusicalGenreConstants.CONTROLLER_REQUEST_MAPPING_TEST + MusicalGenreConstants.CONTROLLER_GET_FIND_BY_ID, 1);
		
		MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andDo(print()).andReturn();
		
		assertNotNull(result.getResponse(), "Empty value");
	}
	
	@Test
	public void testFindByName() throws Exception {
		// call GET /admin/musicalGenres/name/{name} application/json
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(MusicalGenreConstants.CONTROLLER_REQUEST_MAPPING_TEST + MusicalGenreConstants.CONTROLLER_GET_FIND_BY_NAME_MAPPING, "Pop punk");

		MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andDo(print()).andReturn();

		assertNotNull(result.getResponse(), "Empty value");
	}

	@Test
	public void testFindByExample() throws Exception {

		// call GET /admin/musicalGenres/name/{name} application/json
		MockHttpServletRequestBuilder postBuilder = MockMvcRequestBuilders.post("/admin/musicalGenres/find/example")
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(asJsonString(domain));

		MvcResult result = mockMvc.perform(postBuilder).andExpect(status().isOk()).andDo(print()).andReturn();

		assertNotNull(result.getResponse(), "Empty value");
	}
	
	@Test
	public void testFindAllByExample() throws Exception {

		// call GET /admin/musicalGenres/name/{name} application/json
		MockHttpServletRequestBuilder postBuilder = MockMvcRequestBuilders.post("/admin/musicalGenres/findAll/example")
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(asJsonString(domain));

		MvcResult result = mockMvc.perform(postBuilder).andExpect(status().isOk()).andDo(print()).andReturn();

		assertNotNull(result.getResponse(), "Empty value");
	}
	
	@Test
	public void testFindAllByExampleSortable() throws Exception {
		// call GET /admin/musicalGenres/findAll/example/sort application/json
		MockHttpServletRequestBuilder postBuilder = MockMvcRequestBuilders.post("/admin/musicalGenres/findAll/example/sort")
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(asJsonString(domain)).param("direction", "asc").param("properties", "name", "description");

		MvcResult result = mockMvc.perform(postBuilder).andExpect(status().isOk()).andDo(print()).andReturn();

		assertNotNull(result.getResponse(), "Empty value");
	}

	@Test
	public void testCreateMusicalGenre() throws Exception {
		// call POST /admin/musicalGenres/ application/json
		MockHttpServletRequestBuilder postBuilder = MockMvcRequestBuilders.post(MusicalGenreConstants.CONTROLLER_REQUEST_MAPPING_TEST)
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(asJsonString(domain));

        this.mockMvc.perform(postBuilder).andExpect(status().isCreated());
        
		// call GET /admin/musicalGenres/name/{name} application/json
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(MusicalGenreConstants.CONTROLLER_REQUEST_MAPPING_TEST + MusicalGenreConstants.CONTROLLER_GET_FIND_BY_NAME_MAPPING, "Punk rock");

		MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andDo(print()).andReturn();

		assertNotNull(result.getResponse(), "Empty value");
	}
	
	@Test
	public void testUpdateMusicalGenre() throws Exception {
		// call PUT /admin/musicalGenres/ application/json
		MockHttpServletRequestBuilder putBuilder = MockMvcRequestBuilders.put(MusicalGenreConstants.CONTROLLER_REQUEST_MAPPING_TEST + MusicalGenreConstants.CONTROLLER_GET_FIND_BY_ID, 3)
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(asJsonString(domainForUdpate));
		
		this.mockMvc.perform(putBuilder).andExpect(status().isOk());
		
		// call GET /admin/musicalGenres/name/{name} application/json
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(MusicalGenreConstants.CONTROLLER_REQUEST_MAPPING_TEST + MusicalGenreConstants.CONTROLLER_GET_FIND_BY_NAME_MAPPING, "Punk rock");
		
		MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andDo(print()).andReturn();
		
		assertNotNull(result.getResponse(), "Empty value");
	}
	
	@Test
	public void testDeleteMusicalGenre() throws Exception {
		// call DELETE /admin/musicalGenres/ application/json
		MockHttpServletRequestBuilder deleteBuilder = MockMvcRequestBuilders.delete(MusicalGenreConstants.CONTROLLER_REQUEST_MAPPING_TEST + MusicalGenreConstants.CONTROLLER_GET_FIND_BY_ID, 3);
		
		this.mockMvc.perform(deleteBuilder).andExpect(status().isOk());
		
		// call GET /admin/musicalGenres/name/{name} application/json
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(MusicalGenreConstants.CONTROLLER_REQUEST_MAPPING_TEST + MusicalGenreConstants.CONTROLLER_GET_FIND_BY_NAME_MAPPING, "Punk rock");
		
		MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isNotFound()).andDo(print()).andReturn();
		
		assertNotNull(result.getResponse(), "Empty value");
	}
}
