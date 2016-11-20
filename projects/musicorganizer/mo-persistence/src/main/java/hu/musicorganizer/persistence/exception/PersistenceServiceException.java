package hu.musicorganizer.persistence.exception;

public class PersistenceServiceException extends Exception {

	private static final long serialVersionUID = -1485283030009218264L;

	public PersistenceServiceException(String message) {
		super(message);
	}

	public PersistenceServiceException(String message, Throwable cause) {
		super(message, cause);
	}
}
