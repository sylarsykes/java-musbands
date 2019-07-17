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
	public static final String CACHE_MANGER_BEAN_NAME = "musicalGenreCacheManager";

	// CONTROLLER //
	public static final String CONTROLLER_NAME = "musicalGenreCacheManager";
	public static final String CONTROLLER_REQUEST_MAPPING = "/admin/musicalGenres";
	public static final String CONTROLLER_GET_FIND_BY_NAME_MAPPING = "/name/{name}";
	public static final String CONTROLLER_GET_FIND_BY_ID = "/{id}";
	public static final String CONTROLLER_PUT_UPDATE = "/{id}";
	public static final String CONTROLLER_DELETE_DELETE = "/{id}";

	// MAPPER //
	public static final String MAPPER_RESOURCE_FUNCTION = "musicalGenreMapperToResourceFunction";
	public static final String MAPPER_ENTITY_FUNCTION = "musicalGenreMapperToEntityFunction";
	
	// REPOSITORY //
	public static final String REPOSITORY_REST_COLLECTION_RESOURCE_REL = "musical_genre";
	public static final String REPOSITORY_REST_RESOURCE_PATH = "musical_genre";
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
