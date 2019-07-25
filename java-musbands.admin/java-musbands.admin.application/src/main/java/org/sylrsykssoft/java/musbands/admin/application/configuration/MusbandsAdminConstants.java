package org.sylrsykssoft.java.musbands.admin.application.configuration;

/**
 * FunctionMemberConstants
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
public final class MusbandsAdminConstants {
	// CACHE //
	public static final String CACHE_NAME = "musbandsAdmin";
	public static final String CACHE_MANGER_BEAN_NAME = "musbandsAdminCacheManager";

	
	// PRIVATE //
	/**
	 * The caller references the constants using
	 * <tt>FunctionMemberConstants.EMPTY_STRING</tt>, and so on. Thus, the caller
	 * should be prevented from constructing objects of this class, by declaring
	 * this private constructor.
	 */
	private MusbandsAdminConstants() {
		throw new AssertionError();
	}

}
