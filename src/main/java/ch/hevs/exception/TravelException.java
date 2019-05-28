package ch.hevs.exception;

public class TravelException extends RuntimeException {
	
	public TravelException() {
		super();
	}

	public TravelException(String arg0) {
		super(arg0);
	}

	public TravelException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public TravelException(Throwable arg0) {
		super(arg0);
	}

}
