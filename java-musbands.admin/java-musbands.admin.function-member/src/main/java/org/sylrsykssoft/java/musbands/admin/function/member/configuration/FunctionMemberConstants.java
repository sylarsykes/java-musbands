package org.sylrsykssoft.java.musbands.admin.function.member.configuration;

/**
 * FunctionMemberConstants
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
public final class FunctionMemberConstants {
	// CACHE //
	public static final String CACHE_NAME = "functionMember";
	public static final String CACHE_MANGER_BEAN_NAME = "musbandsAdminCacheManager";

	// CONTROLLER //
	public static final String CONTROLLER_NAME = "functionMemberController";
	public static final String CONTROLLER_TEST_NAME = "functionMemberControllerTest";
	public static final String CONTROLLER_REQUEST_MAPPING_BASE_PATH = "${spring.data.rest.base-path}";
	public static final String CONTROLLER_REQUEST_MAPPING = CONTROLLER_REQUEST_MAPPING_BASE_PATH + "/admin/functionMembers";
	public static final String CONTROLLER_REQUEST_MAPPING_BASE_PATH_TEST = "";
	public static final String CONTROLLER_REQUEST_MAPPING_TEST = CONTROLLER_REQUEST_MAPPING_BASE_PATH_TEST + "/admin/functionMembers";
	public static final String CONTROLLER_GET_FIND_BY_ID = "/findOne/id/{id}";
	public static final String CONTROLLER_GET_FIND_BY_NAME_MAPPING = "/findOne/name/{name}";
	public static final String CONTROLLER_GET_FIND_BY_EXAMPLE = "/findOne/example";
	public static final String CONTROLLER_GET_FIND_ALL_BY_EXAMPLE = "/findAll/example";
	public static final String CONTROLLER_GET_FIND_ALL_BY_EXAMPLE_SORTABLE = "/findAll/example/sort";
	public static final String CONTROLLER_PUT_UPDATE = "/{id}";
	public static final String CONTROLLER_DELETE_DELETE = "/{id}";

	// MAPPER //
	public static final String MAPPER_RESOURCE_FUNCTION = "functionMemberMapperToResourceFunction";
	public static final String MAPPER_RESOURCE_ASSEMBLER = "functionMemberResourceAssembler";
	public static final String MAPPER_ENTITY_FUNCTION = "functionMemberMapperToEntityFunction";
	
	// REPOSITORY //
	public static final String REPOSITORY_REST_COLLECTION_RESOURCE_REL = "function_member";
	public static final String REPOSITORY_REST_RESOURCE_PATH = "function_member";
	public static final String REPOSITORY_NAME = "functionMemberRepository";
	public static final String REPOSITORY_TABLE_NAME = "function_member";
	public static final String REPOSITORY_ENTITY_NAME = "function_member";
	
	// RESOURCE //
	public static final String RESOURCE_BUILDER_NAME = "functionMemberResourceBuilder";
	public static final String RESOURCE_ASSEMBLER_NAME = "functionMemberResourceAssembler";
	
	
	// SERVICE //
	public static final String SERVICE_NAME = "functionMemberService";
	
	
	// PRIVATE //
	/**
	 * The caller references the constants using
	 * <tt>FunctionMemberConstants.EMPTY_STRING</tt>, and so on. Thus, the caller
	 * should be prevented from constructing objects of this class, by declaring
	 * this private constructor.
	 */
	private FunctionMemberConstants() {
		throw new AssertionError();
	}

}
