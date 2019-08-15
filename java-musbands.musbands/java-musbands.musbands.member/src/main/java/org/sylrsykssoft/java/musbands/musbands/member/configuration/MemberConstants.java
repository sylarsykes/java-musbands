package org.sylrsykssoft.java.musmembers.musmembers.member.configuration;

/**
 * memberConstants
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
public final class MemberConstants {
	// CACHE //
	public static final String CACHE_NAME = "members";
	public static final String CACHE_MANGER_BEAN_NAME = "musmembersCacheManager";

	// CONTROLLER //
	public static final String CONTROLLER_NAME = "memberController";
	public static final String CONTROLLER_TEST_NAME = "memberControllerTest";
	public static final String CONTROLLER_REQUEST_MAPPING_BASE_PATH = "${spring.data.rest.base-path}";
	public static final String CONTROLLER_REQUEST_MAPPING = CONTROLLER_REQUEST_MAPPING_BASE_PATH + "/members";
	public static final String CONTROLLER_REQUEST_MAPPING_BASE_PATH_TEST = "";
	public static final String CONTROLLER_REQUEST_MAPPING_TEST = CONTROLLER_REQUEST_MAPPING_BASE_PATH_TEST + "/members";
	public static final String CONTROLLER_GET_FIND_BY_ID = "/findOne/id/{id}";
	public static final String CONTROLLER_GET_FIND_BY_NAME_MAPPING = "/findOne/name/{name}";
	public static final String CONTROLLER_GET_FIND_BY_EXAMPLE = "/findOne/example";
	public static final String CONTROLLER_GET_FIND_ALL_BY_EXAMPLE = "/findAll/example";
	public static final String CONTROLLER_GET_FIND_ALL_BY_EXAMPLE_SORTABLE = "/findAll/example/sort";
	public static final String CONTROLLER_PUT_UPDATE = "/{id}";
	public static final String CONTROLLER_DELETE_DELETE = "/{id}";

	// MAPPER //
	public static final String MAPPER_RESOURCE_FUNCTION = "memberMapperToResourceFunction";
	public static final String MAPPER_RESOURCE_ASSEMBLER = "memberResourceAssembler";
	public static final String MAPPER_ENTITY_FUNCTION = "memberMapperToEntityFunction";
	
	// REPOSITORY //
	public static final String REPOSITORY_REST_COLLECTION_RESOURCE_REL = "member";
	public static final String REPOSITORY_REST_RESOURCE_PATH = "member";
	public static final String REPOSITORY_NAME = "memberRepository";
	public static final String REPOSITORY_TABLE_NAME = "member";
	public static final String REPOSITORY_ENTITY_NAME = "member";
	
	// RESOURCE //
	public static final String RESOURCE_BUILDER_NAME = "memberResourceBuilder";
	public static final String RESOURCE_ASSEMBLER_NAME = "memberResourceAssembler";
	
	
	// SERVICE //
	public static final String SERVICE_NAME = "memberService";	
	
	// PRIVATE //
	/**
	 * The caller references the constants using
	 * <tt>MemberConstants.EMPTY_STRING</tt>, and so on. Thus, the caller
	 * should be prevented from constructing objects of this class, by declaring
	 * this private constructor.
	 */
	private MemberConstants() {
		throw new AssertionError();
	}

}
