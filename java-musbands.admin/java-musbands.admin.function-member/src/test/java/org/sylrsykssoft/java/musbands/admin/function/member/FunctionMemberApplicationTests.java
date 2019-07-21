package org.sylrsykssoft.java.musbands.admin.function.member;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.sylrsykssoft.java.musbands.admin.library.configuration.MusbandsAdminLibraryConfiguration;

/**
 * MusbandsAdminFunctionMemberApplicationTests tests
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { FunctionMemberApplication.class })
@ContextConfiguration(classes = { MusbandsAdminLibraryConfiguration.class, }, loader = AnnotationConfigContextLoader.class)
public class FunctionMemberApplicationTests {

	@Test
	public void contextLoads() {
	}

}
