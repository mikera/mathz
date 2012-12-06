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
}
