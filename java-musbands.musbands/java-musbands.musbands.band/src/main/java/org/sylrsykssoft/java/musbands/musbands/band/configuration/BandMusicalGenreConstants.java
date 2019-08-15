package org.sylrsykssoft.java.musbands.musbands.band.configuration;

/**
 * BandMusicalGenreConstants
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
public final class BandMusicalGenreConstants {
	public static final String CONTROLLER_REQUEST_NAME = "bandMusicalGenres";
	public static final String CONTROLLER_REQUEST_NAME_BACKUP = "musicalGenres";
	
	
	// REPOSITORY //
	public static final String REPOSITORY_NAME = "bandMusicalGenreRepository";
	public static final String REPOSITORY_TABLE_NAME = "band_musical_genre";
	public static final String REPOSITORY_ENTITY_NAME = "band_musical_genre";
	public static final String REPOSITORY_BUILDER_NAME = "bandMusicalGenreBuilder";
	
	// RESOURCE //
	public static final String RESOURCE_BUILDER_NAME = "bandMusicalGenreResourceBuilder";
	public static final String RESOURCE_ASSEMBLER_NAME = "bandMusicalGenreResourceAssembler";
	
	// PRIVATE //
	/**
	 * The caller references the constants using
	 * <tt>FunctionMemberConstants.EMPTY_STRING</tt>, and so on. Thus, the caller
	 * should be prevented from constructing objects of this class, by declaring
	 * this private constructor.
	 */
	private BandMusicalGenreConstants() {
		throw new AssertionError();
	}

}
