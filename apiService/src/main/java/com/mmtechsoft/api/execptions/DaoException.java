package com.mmtechsoft.api.execptions;
/**
 * The class DaoException
 * 
 * @author anjaiah M
 * @version 1.x
 * @see com.disneycruise.corecomp.execptions.ServiceException.
 * @since Apr 14th,2018
 * 
 */

public class DaoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DaoException() {
		super();
	}

	public DaoException(String message) {
		super(message);
	}

	public DaoException(Throwable throwable) {
		super(throwable);
	}

	public DaoException(String message, Throwable throwable) {
		super(message, throwable);
	}

}