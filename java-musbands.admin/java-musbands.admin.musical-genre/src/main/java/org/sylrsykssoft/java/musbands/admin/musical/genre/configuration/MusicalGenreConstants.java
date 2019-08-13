package org.sylrsykssoft.java.musbands.admin.musical.genre.configuration;

/**
 * MusicalGenreConstants
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
public final class MusicalGenreConstants {
	// CACHE //
	public static final String CACHE_NAME = "musicalGenres";
	public static final String CACHE_MANGER_BEAN_NAME = "musbandsAdminCacheManager";

	// CONTROLLER //
	public static final String CONTROLLER_NAME = "musicalGenreController";
	public static final String CONTROLLER_TEST_NAME = "musicalGenreControllerTest";
	public static final String CONTROLLER_REQUEST_MAPPING_BASE_PATH = "${spring.data.rest.base-path}";
	public static final String CONTROLLER_REQUEST_NAME = "musicalGenres";
	public static final String CONTROLLER_REQUEST_MAPPING = CONTROLLER_REQUEST_MAPPING_BASE_PATH + "/" + CONTROLLER_REQUEST_NAME;
	public static final String CONTROLLER_REQUEST_MAPPING_BASE_PATH_TEST = "/admin";
	public static final String CONTROLLER_REQUEST_MAPPING_TEST = CONTROLLER_REQUEST_MAPPING_BASE_PATH_TEST + "/musicalGenres";
	public static final String CONTROLLER_GET_FIND_BY_ID = "/findOne/id/{id}";
	public static final String CONTROLLER_GET_FIND_BY_ID2 = "/findOne/id2/{id}";
	public static final String CONTROLLER_GET_FIND_BY_NAME_MAPPING = "/findOne/name/{name}";
	public static final String CONTROLLER_GET_FIND_BY_EXAMPLE = "/findOne/example";
	public static final String CONTROLLER_GET_FIND_ALL_BY_EXAMPLE = "/findAll/example";
	public static final String CONTROLLER_GET_FIND_ALL_BY_EXAMPLE_SORTABLE = "/findAll/example/sort";
	public static final String CONTROLLER_PUT_UPDATE = "/{id}";
	public static final String CONTROLLER_DELETE_DELETE = "/{id}";

	// MAPPER //
	public static final String MAPPER_RESOURCE_FUNCTION = "musicalGenreMapperToResourceFunction";
	public static final String MAPPER_RESOURCE_ASSEMBLER = "musicalGenreResourceAssembler";
	public static final String MAPPER_ENTITY_FUNCTION = "musicalGenreMapperToEntityFunction";
	
	// REPOSITORY //
	public static final String REPOSITORY_REST_COLLECTION_RESOURCE_REL = "musical_genre";
	public static final String REPOSITORY_REST_RESOURCE_PATH = "musical_genre";
	public static final String REPOSITORY_NAME = "musicalGenreRepository";
	public static final String REPOSITORY_TABLE_NAME = "musical_genre";
	public static final String REPOSITORY_ENTITY_NAME = "musical_genre";
	
	// RESOURCE //
	public static final String RESOURCE_BUILDER_NAME = "musicalGenreResourceBuilder";
	public static final String RESOURCE_ASSEMBLER_NAME = "musicalGenreResourceAssembler";
	
	
	// SERVICE //
	public static final String SERVICE_NAME = "musicalGenreService";
	
	
	// PRIVATE //
	/**
	 * The caller references the constants using
	 * <tt>MusicalGenreConstants.EMPTY_STRING</tt>, and so on. Thus, the caller
	 * should be prevented from constructing objects of this class, by declaring
	 * this private constructor.
	 */
	private MusicalGenreConstants() {
		throw new AssertionError();
	}

}
