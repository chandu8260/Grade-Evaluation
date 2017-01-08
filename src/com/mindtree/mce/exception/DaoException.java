/**
 * 
 */
package com.mindtree.mce.exception;

/**
 * @author m1018211
 * 
 */
public class DaoException extends ApplicationException {

	/**
	 * Default Serial Version Id
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default Constructor
	 */
	public DaoException() {
		super();
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public DaoException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * @param arg0
	 */
	public DaoException(String arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 */
	public DaoException(Throwable arg0) {
		super(arg0);
	}

}
