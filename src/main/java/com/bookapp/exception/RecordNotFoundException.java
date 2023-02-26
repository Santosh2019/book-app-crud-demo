package com.bookapp.exception;

/**
 * @author santosh
 *
 */
public class RecordNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public RecordNotFoundException(String message) {
		super(message);
	}

}
