package hu.musicorganizer.ejbservice.exception;

public class FacadeException extends Exception  {

	private static final long serialVersionUID = 3284961056545281597L;

	public FacadeException(String message) {
		super(message);
	}

	public FacadeException(String message, Throwable cause) {
		super(message, cause);
	}  
	
}
