package org.sylrsykssoft.java.musbands.admin.function.member.controller;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import org.sylrsykssoft.java.musbands.admin.function.member.FunctionMemberApplicationTests;
import org.sylrsykssoft.java.musbands.admin.function.member.configuration.FunctionMemberConstants;
import org.sylrsykssoft.java.musbands.admin.function.member.resource.FunctionMemberResource;
import org.sylrsykssoft.java.musbands.admin.library.configuration.MusbandsAdminLibraryConfiguration;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Function member controller test
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { FunctionMemberApplicationTests.class })
@ContextConfiguration(classes = {
		MusbandsAdminLibraryConfiguration.class, }, loader = AnnotationConfigContextLoader.class)
public class FunctionMemberControllerTest {

	private MockMvc mockMvc;

	@Autowired
	FunctionMemberController FunctionMemberController;

	FunctionMemberResource domain;
	FunctionMemberResource domainForUdpate;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(FunctionMemberController).build();

		String name = "Lead guitar";
		String description = "Lead guitar is a musical part for a guitar in which the guitarist plays melody lines, instrumental fill passages, guitar solos, and occasionally, some riffs within a song structure. The lead is the featured guitar, which usually plays single-note-based lines or double-stops.[1] In rock, heavy metal, blues, jazz, punk, fusion, some pop, and other music styles, lead guitar lines are usually supported by a second guitarist who plays rhythm guitar, which consists of accompaniment chords and riffs.";

		domain = FunctionMemberResource.functionMemberResourceBuilder().name(name).description(description).build();
		
		domainForUdpate = FunctionMemberResource.functionMemberResourceBuilder().entityId(3).name(name).description(description + " erop").build();
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

//		when(FunctionMemberService.findAll()).thenReturn(Arrays.asList(new FunctionMemberResource()));

		// call GET /admin/functionMembers application/json
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(FunctionMemberConstants.CONTROLLER_REQUEST_MAPPING)
				.accept(MediaType.APPLICATION_JSON_VALUE);

		MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andDo(print()).andReturn();

		assertNotNull("Empty list", result.getResponse());
	}

	@Test
	public void testFindById() throws Exception {
		// call GET /admin/functionMembers/{id} application/json
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(FunctionMemberConstants.CONTROLLER_REQUEST_MAPPING + FunctionMemberConstants.CONTROLLER_GET_FIND_BY_ID, 1);
		
		MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andDo(print()).andReturn();
		
		assertNotNull("Empty value", result.getResponse());
	}
	
	@Test
	public void testFindByName() throws Exception {
		// call GET /admin/FunctionMembers/name/{name} application/json
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(FunctionMemberConstants.CONTROLLER_REQUEST_MAPPING + FunctionMemberConstants.CONTROLLER_GET_FIND_BY_NAME_MAPPING, "Lead guitar");

		MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andDo(print()).andReturn();

		assertNotNull("Empty value", result.getResponse());
	}

	@Test
	public void testFindByExample() throws Exception {

		// call GET /admin/functionMembers/name/{name} application/json
		MockHttpServletRequestBuilder postBuilder = MockMvcRequestBuilders.post(FunctionMemberConstants.CONTROLLER_REQUEST_MAPPING + FunctionMemberConstants.CONTROLLER_GET_FIND_BY_EXAMPLE)
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(asJsonString(domain));

		MvcResult result = mockMvc.perform(postBuilder).andExpect(status().isOk()).andDo(print()).andReturn();

		assertNotNull("Empty value", result.getResponse());
	}
	
	@Test
	public void testFindAllByExample() throws Exception {

		// call GET /admin/functionMembers/name/{name} application/json
		MockHttpServletRequestBuilder postBuilder = MockMvcRequestBuilders.post(FunctionMemberConstants.CONTROLLER_REQUEST_MAPPING + FunctionMemberConstants.CONTROLLER_GET_FIND_ALL_BY_EXAMPLE)
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(asJsonString(domain));

		MvcResult result = mockMvc.perform(postBuilder).andExpect(status().isOk()).andDo(print()).andReturn();

		assertNotNull("Empty value", result.getResponse());
	}
	
	@Test
	public void testFindAllByExampleSortable() throws Exception {
		// call GET /admin/functionMembers/findAll/example/sort application/json
		MockHttpServletRequestBuilder postBuilder = MockMvcRequestBuilders.post(FunctionMemberConstants.CONTROLLER_REQUEST_MAPPING + FunctionMemberConstants.CONTROLLER_GET_FIND_ALL_BY_EXAMPLE_SORTABLE)
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(asJsonString(domain)).param("direction", "asc").param("properties", "name", "description");

		MvcResult result = mockMvc.perform(postBuilder).andExpect(status().isOk()).andDo(print()).andReturn();

		assertNotNull("Empty value", result.getResponse());
	}

	@Test
	public void testCreateFunctionMember() throws Exception {
		// call POST /admin/functionMembers/ application/json
		MockHttpServletRequestBuilder postBuilder = MockMvcRequestBuilders.post(FunctionMemberConstants.CONTROLLER_REQUEST_MAPPING)
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(asJsonString(domain));

        this.mockMvc.perform(postBuilder).andExpect(status().isCreated());
        
		// call GET /admin/functionMembers/name/{name} application/json
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(FunctionMemberConstants.CONTROLLER_REQUEST_MAPPING + FunctionMemberConstants.CONTROLLER_GET_FIND_BY_NAME_MAPPING, "Lead guitar");

		MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andDo(print()).andReturn();

		assertNotNull("Empty value", result.getResponse());
	}
	
	@Test
	public void testUpdateFunctionMember() throws Exception {
		// call PUT /admin/functionMembers/ application/json
		MockHttpServletRequestBuilder putBuilder = MockMvcRequestBuilders.put(FunctionMemberConstants.CONTROLLER_REQUEST_MAPPING + FunctionMemberConstants.CONTROLLER_GET_FIND_BY_ID, 2)
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(asJsonString(domainForUdpate));
		
		this.mockMvc.perform(putBuilder).andExpect(status().isOk());
		
		// call GET /admin/functionMembers/name/{name} application/json
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(FunctionMemberConstants.CONTROLLER_REQUEST_MAPPING + FunctionMemberConstants.CONTROLLER_GET_FIND_BY_NAME_MAPPING, "Lead guitar");
		
		MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andDo(print()).andReturn();
		
		assertNotNull("Empty value", result.getResponse());
	}
	
	@Test
	public void testDeleteFunctionMember() throws Exception {
		// call DELETE /admin/functionMembers/ application/json
		MockHttpServletRequestBuilder deleteBuilder = MockMvcRequestBuilders.delete(FunctionMemberConstants.CONTROLLER_REQUEST_MAPPING + FunctionMemberConstants.CONTROLLER_GET_FIND_BY_ID, 2);
		
		this.mockMvc.perform(deleteBuilder).andExpect(status().isOk());
		
		// call GET /admin/functionMembers/name/{name} application/json
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(FunctionMemberConstants.CONTROLLER_REQUEST_MAPPING + FunctionMemberConstants.CONTROLLER_GET_FIND_BY_NAME_MAPPING, "Lead guitar");
		
		MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isNotFound()).andDo(print()).andReturn();
		
		assertNotNull("Empty value", result.getResponse());
	}
}
