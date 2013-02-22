package mikera.util.mathz;

/**
 * Mostly experimental. Alternative implementation sof maths functions.
 * 
 * 
 * @author Mike
 *
 */
public class AlternativeMaths {

	/** Branchless min for ints */
	public static int min2(int a, int b) {
		return a^((a^b) & ((b-a)>>31));
	}
	
	/** Branchless max for ints */
	public static int max2(int a, int b) {
		return a^((a^b) & ((a-b)>>31));
	}
	
	/** 
	 * Fast branchless integer sign 
	 * Not correct for MIN_INTEGER - but valid for all other int values
	 */
	public static int sign2fast(int a) {
		return 1+(a>>31)+((a-1)>>31);
	}
	
	public static double tanh (double x) {
		double ex=Math.exp(2*x);
		double df=((ex-1)/(ex+1));
		if (Double.isNaN(df)) return (x>0)?1:-1;
		return df;
	}
	
	/**
	 * Mike's fast integer sign algorithm
	 * @param a
	 * @return Sign of the given number (-1, 0 or 1)
	 */
	public static final int sign2(int a) {
		return (a>>31)+((a>0)?1:0);
	}
	

	
}
