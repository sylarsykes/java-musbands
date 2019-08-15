package org.sylrsykssoft.java.musbands.musbands.band.configuration;

/**
 * FunctionMemberConstants
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
public final class BandFunctionMemberConstants {
	public static final String CONTROLLER_REQUEST_NAME = "bandFunctionMembers";
	public static final String CONTROLLER_REQUEST_NAME_BACKUP = "functionMembers";
	
	
	// REPOSITORY //
	public static final String REPOSITORY_NAME = "bandFunctionMemberRepository";
	public static final String REPOSITORY_TABLE_NAME = "band_function_member";
	public static final String REPOSITORY_ENTITY_NAME = "band_function_member";
	public static final String REPOSITORY_BUILDER_NAME = "bandFunctionMemberBuilder";
	
	// RESOURCE //
	public static final String RESOURCE_BUILDER_NAME = "bandFunctionMemberResourceBuilder";
	public static final String RESOURCE_ASSEMBLER_NAME = "bandFunctionMemberResourceAssembler";
	
	
	// PRIVATE //
	/**
	 * The caller references the constants using
	 * <tt>FunctionMemberConstants.EMPTY_STRING</tt>, and so on. Thus, the caller
	 * should be prevented from constructing objects of this class, by declaring
	 * this private constructor.
	 */
	private BandFunctionMemberConstants() {
		throw new AssertionError();
	}

}
