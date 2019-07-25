package org.sylrsykssoft.java.musbands.admin.function.member.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

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
import org.sylrsykssoft.java.musbands.admin.function.member.FunctionMemberApplicationTests;
import org.sylrsykssoft.java.musbands.admin.function.member.configuration.FunctionMemberTestsConfiguration;
import org.sylrsykssoft.java.musbands.admin.function.member.resource.FunctionMemberResource;
import org.sylrsykssoft.java.musbands.admin.function.member.resource.FunctionMemberSynonymicResource;

/**
 * Function member service test.
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { FunctionMemberApplicationTests.class })
@ContextConfiguration(classes = { FunctionMemberTestsConfiguration.class, }, loader = AnnotationConfigContextLoader.class)
public class FunctionMemberServiceTest {

	@Autowired
	FunctionMemberService functionMemberService;

	FunctionMemberResource domain;
	
	Example<FunctionMemberResource> example;
	
	@Before
	public void setUp() {
		String name = "Lead vocalist";
		String description = "The lead vocalist in popular music is typically the member of a group or band whose voice is the most prominent in a performance where multiple voices may be heard. The lead singer either leads the vocal ensemble, or sets against the ensemble as the dominant sound. In vocal group performances, notably in soul and gospel music, and early rock and roll, the lead singer takes the main vocal part, with a chorus provided by other band members as backing vocalists.\r\n"
				+ "Especially in rock music, the lead singer or solo singer is often the front man or front woman, who may also play one or more instruments and is often seen as the leader or spokesman of the band by the public. As an example in rock music, Freddie Mercury was the lead singer of Queen. Similarly in soul music, Smokey Robinson was the lead singer of The Miracles. ";

		FunctionMemberSynonymicResource synonymic1 = FunctionMemberSynonymicResource.builder().name("Main vocalist").build();
		FunctionMemberSynonymicResource synonymic2 = FunctionMemberSynonymicResource.builder().name("Lead vocals").build();
		FunctionMemberSynonymicResource synonymic3 = FunctionMemberSynonymicResource.builder().name("Lead singer").build();
		
		Set<FunctionMemberSynonymicResource> synonyms = new HashSet<FunctionMemberSynonymicResource>();
		synonyms.add(synonymic1);
		synonyms.add(synonymic2);
		synonyms.add(synonymic3);
		
		domain = FunctionMemberResource.functionMemberResourceBuilder().name(name).description(description).synonyms(synonyms).build();
		
		example = Example.of(domain, ExampleMatcher.matchingAll());
	}

	@Test
	public void testCreateFunctionMember() {
		String name = "Lead vocalist";
		final FunctionMemberResource FunctionMemberSaved = functionMemberService.save(domain);

		assertThat("Entity did not get an generated Id!", FunctionMemberSaved.getEntityId(), greaterThan(-1));
        assertThat("Entity name did not match!", FunctionMemberSaved.getName(), is(name));
		
	}
	
	@Test
	public void testFindAllFunctionMembers() {
		Iterable<FunctionMemberResource> FunctionMembers = functionMemberService.findAll();
		Assert.assertNotNull(FunctionMembers);
	}
	
	// @see https://www.logicbig.com/tutorials/spring-framework/spring-data/query-example-matchers.html
	@Test
	public void testFindOneByExampleFunctionMember() {
		Optional<FunctionMemberResource> optResource = functionMemberService.findByExample(example);
		Assert.assertNotNull(optResource.get());
	}
	
	@Test
	public void testUpdateFunctionMember() {
		String name = "Lead vocalist";
		Optional<FunctionMemberResource> optResource = functionMemberService.findByName(name);
		
		FunctionMemberResource resourceGet = optResource.orElseThrow(IllegalStateException::new);
		
		assertThat("Entity name did not match!", resourceGet.getName(), is(name));
		
		FunctionMemberResource resourceUpdated = functionMemberService.save(FunctionMemberResource.functionMemberResourceBuilder().entityId(resourceGet.getEntityId()).name(resourceGet.getName())
				.description(resourceGet.getDescription() + " El ir.").build());
		
		assertThat("Entity id did not match!", resourceUpdated.getEntityId(), is(resourceGet.getEntityId()));
	}
	
	@Test
	public void testDeleteFunctionMember() {
		String name = "Lead vocalist";
		Optional<FunctionMemberResource> optResource = functionMemberService.findByName(name);
		
		FunctionMemberResource source = optResource.orElseThrow(IllegalStateException::new);
		
		assertThat("Entity name did not match!", source.getName(), is(name));
		
		functionMemberService.delete(source);
	}

}
