package com.crusnikatelier.rss.exceptions;
/**
 * This class is used to indicate that it is impossible to adhere to 
 * the really simple syndication (RSS) DTD because values of classes
 * are invalid.
 * 
 * @author Aelphaeis
 *
 */
public class SyndicationSyntaxException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public SyndicationSyntaxException() {
		super();
	}

	public SyndicationSyntaxException(String message) {
		super(message);
	}

	public SyndicationSyntaxException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public SyndicationSyntaxException(Throwable cause) {
		super(cause);
	}

}
