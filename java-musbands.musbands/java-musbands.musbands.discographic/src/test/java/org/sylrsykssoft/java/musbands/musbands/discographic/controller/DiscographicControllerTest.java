package org.sylrsykssoft.java.musbands.musbands.discographic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sylrsykssoft.coreapi.framework.web.BaseEntityController;
import org.sylrsykssoft.java.musbands.musbands.discographic.configuration.DiscographicConstants;
import org.sylrsykssoft.java.musbands.musbands.discographic.domain.Discographic;
import org.sylrsykssoft.java.musbands.musbands.discographic.resource.DiscographicResource;
import org.sylrsykssoft.java.musbands.musbands.discographic.service.DiscographicService;

/**
 * Rest Controller for Musical Genre API
 * 
 * @author juan.gonzalez.fernandez.jgf
 * 
 * @see https://restfulapi.net/http-methods/
 *
 */
@RestController(DiscographicConstants.CONTROLLER_TEST_NAME)
@RequestMapping(DiscographicConstants.CONTROLLER_REQUEST_MAPPING_TEST)
public class DiscographicControllerTest extends BaseEntityController<DiscographicResource, Discographic> {

	@Autowired
	private DiscographicService discographicService;

	/**
	 * {@inheritDoc}
	 */
	public DiscographicService getEntityService() {
		return discographicService;
	}

}
