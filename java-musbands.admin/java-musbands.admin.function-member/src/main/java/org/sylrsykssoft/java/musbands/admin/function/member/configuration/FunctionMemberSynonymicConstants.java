package org.sylrsykssoft.java.musbands.admin.function.member.configuration;

/**
 * FunctionMemberConstants
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
public final class FunctionMemberSynonymicConstants {
	// REPOSITORY //
	public static final String REPOSITORY_NAME = "functionMemberRepository";
	public static final String REPOSITORY_TABLE_NAME = "function_member_synonymic";
	public static final String REPOSITORY_ENTITY_NAME = "function_member_synonymic";
	
	// RESOURCE //
	public static final String RESOURCE_BUILDER_NAME = "functionMemberResourceBuilder";
	public static final String RESOURCE_ASSEMBLER_NAME = "functionMemberResourceAssembler";
	
	// PRIVATE //
	/**
	 * The caller references the constants using
	 * <tt>FunctionMemberConstants.EMPTY_STRING</tt>, and so on. Thus, the caller
	 * should be prevented from constructing objects of this class, by declaring
	 * this private constructor.
	 */
	private FunctionMemberSynonymicConstants() {
		throw new AssertionError();
	}

}
