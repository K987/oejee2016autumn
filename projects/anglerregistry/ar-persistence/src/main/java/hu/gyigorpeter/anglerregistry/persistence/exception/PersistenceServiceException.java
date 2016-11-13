package hu.gyigorpeter.anglerregistry.persistence.exception;

public class PersistenceServiceException extends Exception {

	private static final long serialVersionUID = -8835505548071255722L;

	public PersistenceServiceException(String message) {
		super(message);
	}

	public PersistenceServiceException(String message, Throwable cause) {
		super(message, cause);
	}

}
