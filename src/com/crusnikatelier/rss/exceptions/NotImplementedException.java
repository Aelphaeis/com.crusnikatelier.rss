package com.crusnikatelier.rss.exceptions;

/**
 * This class is used to detonate that a piece of functionality has
 * not yet been completed.
 * @author Aelphaeis
 *
 */
public class NotImplementedException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NotImplementedException() {
		super();
	}

	public NotImplementedException(String message) {
		super(message);
	}

	public NotImplementedException(String message, Throwable cause) {
		super(message, cause);
	}
	public NotImplementedException(Throwable cause) {
		super(cause);
	}


}
