package org.sylrsykssoft.java.musbands.musbands.discographic.configuration;

/**
 * MusicalGenreConstants
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
public final class DiscographicConstants {
	// CACHE //
	public static final String CACHE_NAME = "discographics";
	public static final String CACHE_MANGER_BEAN_NAME = "musicalGenreCacheManager";

	// CONTROLLER //
	public static final String CONTROLLER_NAME = "discographicController";
	public static final String CONTROLLER_REQUEST_MAPPING = "/admin/musicalGenres";
	public static final String CONTROLLER_GET_FIND_BY_ID = "/findOne/id/{id}";
	public static final String CONTROLLER_GET_FIND_BY_NAME_MAPPING = "/findOne/name/{name}";
	public static final String CONTROLLER_GET_FIND_BY_EXAMPLE = "/findOne/example";
	public static final String CONTROLLER_GET_FIND_ALL_BY_EXAMPLE = "/findAll/example";
	public static final String CONTROLLER_GET_FIND_ALL_BY_EXAMPLE_SORTABLE = "/findAll/example/sort";
	public static final String CONTROLLER_PUT_UPDATE = "/{id}";
	public static final String CONTROLLER_DELETE_DELETE = "/{id}";

	// MAPPER //
	public static final String MAPPER_RESOURCE_FUNCTION = "discographicMapperToResourceFunction";
	public static final String MAPPER_ENTITY_FUNCTION = "discographicMapperToEntityFunction";
	
	// REPOSITORY //
	public static final String REPOSITORY_REST_COLLECTION_RESOURCE_REL = "discographic";
	public static final String REPOSITORY_REST_RESOURCE_PATH = "discographic";
	public static final String REPOSITORY_TABLE_NAME = "discographic";
	public static final String REPOSITORY_ENTITY_NAME = "discographic";
	
	// RESOURCE //
	public static final String RESOURCE_BUILDER_NAME = "discographicResourceBuilder";
	public static final String RESOURCE_ASSEMBLER_NAME = "discographicResourceAssembler";
	
	
	// SERVICE //
	public static final String SERVICE_NAME = "musicalGenreService";
	
	
	// PRIVATE //
	/**
	 * The caller references the constants using
	 * <tt>MusicalGenreConstants.EMPTY_STRING</tt>, and so on. Thus, the caller
	 * should be prevented from constructing objects of this class, by declaring
	 * this private constructor.
	 */
	private DiscographicConstants() {
		throw new AssertionError();
	}

}
