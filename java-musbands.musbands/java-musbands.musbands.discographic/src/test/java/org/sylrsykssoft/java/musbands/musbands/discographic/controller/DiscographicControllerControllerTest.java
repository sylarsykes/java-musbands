package org.sylrsykssoft.java.musbands.musbands.discographic.controller;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.Year;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.sylrsykssoft.java.musbands.musbands.discographic.DiscographicApplicationTests;
import org.sylrsykssoft.java.musbands.musbands.discographic.configuration.DiscographicConstants;
import org.sylrsykssoft.java.musbands.musbands.discographic.configuration.DiscographicTestsConfiguration;
import org.sylrsykssoft.java.musbands.musbands.discographic.resource.DiscographicResource;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Musical genre controller test
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { DiscographicApplicationTests.class })
@ContextConfiguration(classes = { DiscographicTestsConfiguration.class, }, loader = AnnotationConfigContextLoader.class)
public class DiscographicControllerControllerTest {

	private MockMvc mockMvc;

	@Autowired
	DiscographicControllerTest discographicControllerTest;

	DiscographicResource domain;
	
	DiscographicResource domainForUdpate;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(discographicControllerTest).build();

		String name = "Visible Noise";
		String description = "Visible Noise is a British independent record label that focuses solely on British bands.";
		Short startYear = 1998;
		String founder = "Julie Weir";
		String website = "http://www.visiblenoise.com/";
		

		domain = DiscographicResource.discographicResourceBuilder().name(name).description(description).startYear(Year.of(startYear)).founder(founder).website(website).build();
		
		domainForUdpate = DiscographicResource.discographicResourceBuilder().entityId((long) 3).name(name).description(description + " erop").build();
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
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(DiscographicConstants.CONTROLLER_REQUEST_MAPPING_TEST)
				.accept(MediaType.APPLICATION_JSON_VALUE);

		MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andDo(print()).andReturn();

		assertNotNull("Empty list", result.getResponse());
	}

	@Test
	public void testFindById() throws Exception {
		// call GET /admin/musicalGenres/{id} application/json
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(DiscographicConstants.CONTROLLER_REQUEST_MAPPING_TEST + DiscographicConstants.CONTROLLER_GET_FIND_BY_ID, 1);
		
		MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andDo(print()).andReturn();
		
		assertNotNull("Empty value", result.getResponse());
	}
	
	@Test
	public void testFindByName() throws Exception {
		// call GET /admin/musicalGenres/name/{name} application/json
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(DiscographicConstants.CONTROLLER_REQUEST_MAPPING_TEST + DiscographicConstants.CONTROLLER_GET_FIND_BY_NAME_MAPPING, "Pop punk");

		MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andDo(print()).andReturn();

		assertNotNull("Empty value", result.getResponse());
	}

	@Test
	public void testFindByExample() throws Exception {

		// call GET /admin/musicalGenres/name/{name} application/json
		MockHttpServletRequestBuilder postBuilder = MockMvcRequestBuilders.post("/admin/musicalGenres/find/example")
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(asJsonString(domain));

		MvcResult result = mockMvc.perform(postBuilder).andExpect(status().isOk()).andDo(print()).andReturn();

		assertNotNull("Empty value", result.getResponse());
	}
	
	@Test
	public void testFindAllByExample() throws Exception {

		// call GET /admin/musicalGenres/name/{name} application/json
		MockHttpServletRequestBuilder postBuilder = MockMvcRequestBuilders.post("/admin/musicalGenres/findAll/example")
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(asJsonString(domain));

		MvcResult result = mockMvc.perform(postBuilder).andExpect(status().isOk()).andDo(print()).andReturn();

		assertNotNull("Empty value", result.getResponse());
	}
	
	@Test
	public void testFindAllByExampleSortable() throws Exception {
		// call GET /admin/musicalGenres/findAll/example/sort application/json
		MockHttpServletRequestBuilder postBuilder = MockMvcRequestBuilders.post("/admin/musicalGenres/findAll/example/sort")
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(asJsonString(domain)).param("direction", "asc").param("properties", "name", "description");

		MvcResult result = mockMvc.perform(postBuilder).andExpect(status().isOk()).andDo(print()).andReturn();

		assertNotNull("Empty value", result.getResponse());
	}

	@Test
	public void testCreateDiscographic() throws Exception {
		// call POST /admin/musicalGenres/ application/json
		MockHttpServletRequestBuilder postBuilder = MockMvcRequestBuilders.post(DiscographicConstants.CONTROLLER_REQUEST_MAPPING_TEST)
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(asJsonString(domain));

        this.mockMvc.perform(postBuilder).andExpect(status().isCreated());
        
		// call GET /admin/musicalGenres/name/{name} application/json
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(DiscographicConstants.CONTROLLER_REQUEST_MAPPING_TEST + DiscographicConstants.CONTROLLER_GET_FIND_BY_NAME_MAPPING, "Punk rock");

		MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andDo(print()).andReturn();

		assertNotNull("Empty value", result.getResponse());
	}
	
	@Test
	public void testUpdateDiscographic() throws Exception {
		// call PUT /admin/musicalGenres/ application/json
		MockHttpServletRequestBuilder putBuilder = MockMvcRequestBuilders.put(DiscographicConstants.CONTROLLER_REQUEST_MAPPING_TEST + DiscographicConstants.CONTROLLER_GET_FIND_BY_ID, 3)
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(asJsonString(domainForUdpate));
		
		this.mockMvc.perform(putBuilder).andExpect(status().isOk());
		
		// call GET /admin/musicalGenres/name/{name} application/json
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(DiscographicConstants.CONTROLLER_REQUEST_MAPPING_TEST + DiscographicConstants.CONTROLLER_GET_FIND_BY_NAME_MAPPING, "Punk rock");
		
		MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andDo(print()).andReturn();
		
		assertNotNull("Empty value", result.getResponse());
	}
	
	@Test
	public void testDeleteDiscographic() throws Exception {
		// call DELETE /admin/musicalGenres/ application/json
		MockHttpServletRequestBuilder deleteBuilder = MockMvcRequestBuilders.delete(DiscographicConstants.CONTROLLER_REQUEST_MAPPING_TEST + DiscographicConstants.CONTROLLER_GET_FIND_BY_ID, 3);
		
		this.mockMvc.perform(deleteBuilder).andExpect(status().isOk());
		
		// call GET /admin/musicalGenres/name/{name} application/json
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(DiscographicConstants.CONTROLLER_REQUEST_MAPPING_TEST + DiscographicConstants.CONTROLLER_GET_FIND_BY_NAME_MAPPING, "Punk rock");
		
		MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isNotFound()).andDo(print()).andReturn();
		
		assertNotNull("Empty value", result.getResponse());
	}
}
