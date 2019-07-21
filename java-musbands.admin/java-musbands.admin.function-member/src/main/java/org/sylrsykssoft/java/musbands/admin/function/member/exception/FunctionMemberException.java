package org.sylrsykssoft.java.musbands.admin.function.member.exception;

import java.beans.ConstructorProperties;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.sylrsykssoft.coreapi.framework.library.error.exception.CoreApiFrameworkLibraryException;

/**
 * FunctionMemberException
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class FunctionMemberException extends CoreApiFrameworkLibraryException {
	private static final long serialVersionUID = 4594253434183319508L;

	/**
	 * Deafult constructor
	 */
	public FunctionMemberException() {
		super();
	}

	/**
	 * Message constructor 
	 * 
	 * @param message
	 */
	@ConstructorProperties({ "message"})
	public FunctionMemberException(final String message) {
		super(message);
	}
	
	/**
	 * Cause constructor
	 * 
	 * @param cause
	 */
	@ConstructorProperties({ "cause"})
	public FunctionMemberException(final Throwable cause) {
		super(cause);
	}
	
	/**
	 * AllArgsConstructor
	 * 
	 * @param message
	 * @param cause
	 */
	@ConstructorProperties({ "message", "cause"})
	public FunctionMemberException(final String message, final Throwable cause) {
		super(message, cause);
	}

}
