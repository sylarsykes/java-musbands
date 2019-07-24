package org.sylrsykssoft.java.musbands.admin.function.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sylrsykssoft.coreapi.framework.web.BaseAdminController;
import org.sylrsykssoft.java.musbands.admin.function.member.configuration.FunctionMemberConstants;
import org.sylrsykssoft.java.musbands.admin.function.member.domain.FunctionMember;
import org.sylrsykssoft.java.musbands.admin.function.member.resource.FunctionMemberResource;
import org.sylrsykssoft.java.musbands.admin.function.member.service.FunctionMemberService;

/**
 * Rest Controller for Function Member API
 * 
 * @author juan.gonzalez.fernandez.jgf
 * 
 * @see https://restfulapi.net/http-methods/
 *
 */
@RestController(FunctionMemberConstants.CONTROLLER_NAME)
@RequestMapping(FunctionMemberConstants.CONTROLLER_REQUEST_MAPPING)
public class FunctionMemberController extends BaseAdminController<FunctionMemberResource, FunctionMember> {

	@Autowired
	private FunctionMemberService functionMemberService;

	
	/**
	 * Getter admin service implementation
	 * 
	 * @return BaseAdminService<T, R>
	 */
	public FunctionMemberService getAdminService() {
		return functionMemberService;
	}
		
}
