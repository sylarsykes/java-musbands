package org.sylrsykssoft.java.musbands.musbands.band.configuration;

/**
 * BandConstants
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
public final class BandConstants {
	// CACHE //
	public static final String CACHE_NAME = "bands";
	public static final String CACHE_MANGER_BEAN_NAME = "musbandsCacheManager";

	// CONTROLLER //
	public static final String CONTROLLER_NAME = "bandController";
	public static final String CONTROLLER_TEST_NAME = "bandControllerTest";
	public static final String CONTROLLER_REQUEST_MAPPING_BASE_PATH = "${spring.data.rest.base-path}";
	public static final String CONTROLLER_REQUEST_MAPPING = CONTROLLER_REQUEST_MAPPING_BASE_PATH + "/bands";
	public static final String CONTROLLER_REQUEST_MAPPING_BASE_PATH_TEST = "";
	public static final String CONTROLLER_REQUEST_MAPPING_TEST = CONTROLLER_REQUEST_MAPPING_BASE_PATH_TEST + "/bands";
	public static final String CONTROLLER_GET_FIND_BY_ID = "/findOne/id/{id}";
	public static final String CONTROLLER_GET_FIND_BY_NAME_MAPPING = "/findOne/name/{name}";
	public static final String CONTROLLER_GET_FIND_BY_EXAMPLE = "/findOne/example";
	public static final String CONTROLLER_GET_FIND_ALL_BY_EXAMPLE = "/findAll/example";
	public static final String CONTROLLER_GET_FIND_ALL_BY_EXAMPLE_SORTABLE = "/findAll/example/sort";
	public static final String CONTROLLER_PUT_UPDATE = "/{id}";
	public static final String CONTROLLER_DELETE_DELETE = "/{id}";

	// MAPPER //
	public static final String MAPPER_RESOURCE_FUNCTION = "bandMapperToResourceFunction";
	public static final String MAPPER_RESOURCE_ASSEMBLER = "bandResourceAssembler";
	public static final String MAPPER_ENTITY_FUNCTION = "bandMapperToEntityFunction";
	
	// REPOSITORY //
	public static final String REPOSITORY_REST_COLLECTION_RESOURCE_REL = "band";
	public static final String REPOSITORY_REST_RESOURCE_PATH = "band";
	public static final String REPOSITORY_NAME = "bandRepository";
	public static final String REPOSITORY_TABLE_NAME = "band";
	public static final String REPOSITORY_ENTITY_NAME = "band";
	
	// RESOURCE //
	public static final String RESOURCE_BUILDER_NAME = "bandResourceBuilder";
	public static final String RESOURCE_ASSEMBLER_NAME = "bandResourceAssembler";
	
	
	// SERVICE //
	public static final String SERVICE_NAME = "bandService";	
	
	// PRIVATE //
	/**
	 * The caller references the constants using
	 * <tt>BandConstants.EMPTY_STRING</tt>, and so on. Thus, the caller
	 * should be prevented from constructing objects of this class, by declaring
	 * this private constructor.
	 */
	private BandConstants() {
		throw new AssertionError();
	}

}
