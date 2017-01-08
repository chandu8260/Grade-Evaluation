/**
 * 
 */
package com.mindtree.mce.exception;

/**
 * @author m1018211
 *
 */
public class ApplicationException extends Exception {

	/**
	 * Default Serial Version Id
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default Constructor
	 */
	public ApplicationException() {
		super();
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public ApplicationException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * @param arg0
	 */
	public ApplicationException(String arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 */
	public ApplicationException(Throwable arg0) {
		super(arg0);
	}

}
