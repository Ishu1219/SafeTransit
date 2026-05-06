package com.cts.exception;

public class NotExistException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NotExistException(String msg) {
		super(msg);
	}
}

