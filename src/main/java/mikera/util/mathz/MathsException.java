package mikera.util.mathz;

@SuppressWarnings("serial")
public class MathsException extends RuntimeException {
	public MathsException(String message) {
		super(message);
	}
	
	public MathsException(Throwable t) {
		super(t);
	}
}
