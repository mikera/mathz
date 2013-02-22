package mikera.util;

/**
 * Helpful maths functions
 * 
 * Focus on using floats rather than doubles for speed
 * 
 * @author Mike
 *
 */
public final class Maths {
	public static final double ROOT_TWO=Math.sqrt(2);
	public static final double ROOT_THREE=Math.sqrt(3);
	
	/** mathematical constant e */
	public static final double E=java.lang.Math.E;
	
	/** Mathematical constant Pi = 3.1415926... */
	public static final double PI=Math.PI;
	public static final double TWO_PI=2.0*PI;

	/** Mathematical constant Tau = 2 * Pi */
	public static final double TAU=TWO_PI;
	public static final double HALF_PI=0.5*PI;
	public static final double QUARTER_PI=0.25*PI;
	private static final double EPSILON = 0.00001;
	
	public static float sqrt(float a) {
		return (float)Math.sqrt(a);
	}
	
	public static double sqrt(double a) {
		return Math.sqrt(a);
	}
	
	/**
	 * Clamp a double value to an integer range
	 */
	public static int clampToInteger(double value, int min, int max) {
		int v=(int)value;
		if (v<min) return min;
		if (v>max) return max;
		return v;
	}
	
	/**
	 * Clamp a float value to an integer range
	 */
	public static int clampToInteger(float value, int min, int max) {
		int v=(int)value;
		if (v<min) return min;
		if (v>max) return max;
		return v;
	}
	

	/** Linear interpolation between a and b */
	public static final double lerp(double t,double a, double b) {
	    return (1-t) * a + t*b;		
	}
	
	/**
	 * Return the middle value of 3 numbers
	 * 
	 * Can use faster "bound" method if first and last parameters are in order
	 */
	public static int middle(int a, int b, int c) {
		if (a<b) {
			if (b<c) {
				return b;
			}
			return (a<c)?c:a;
		}
		if (a<c) {
			return a;
		}
		return (b<c)?c:b;
	}
	
	/**
	 * Return the middle value of 3 numbers
	 * 
	 * Can use faster "bound" method if first and last parameters are in order
	 */
	public static float middle(float a, float b, float c) {
		if (a<b) {
			if (b<c) {
				return b;
			}
			return (a<c)?c:a;
		}
		if (a<c) {
			return a;
		}
		return (b<c)?c:b;
	}
	
	/**
	 * Return the sign of a double value
	 */
	public static int sign(double x) {
		if (x==0.0) return 0;
		return (x>0)?1:-1;
	}

	/**
	 * Return the sign of a float value
	 */
	public static int sign(float x) {
		if (x==0.0f) return 0;
		return (x>0)?1:-1;
	}
	
	/**
	 * Return the sign of an int value
	 */
	public static final int sign(int a) {
		return (a==0) ? 0 : ( (a>0)?1:-1 );
	}
	

	
	/** Return the sign of a long value */
	public static int sign(long a) {
		if (a==0) return 0;
		return (a>0)?1:-1;
	}

	
	/**
	 * Integer modulus function
	 * @param n number
	 * @param d divisor
	 * @return
	 */
	public static int mod(int number, int divisor) {
		int r= (number%divisor);
		if (r<0) r+=divisor;
		return r;
	}
	
	/**
	 * Detects the number of times that boundary is passed when adding increase to base
	 * @param increase
	 * @param boundary
	 * @param base
	 * @return
	 */
	public static long quantize(long increase, long boundary, long base) {
		return ((base+increase)/boundary)-(base/boundary);
	}
	
	/** Return the minimum of three values */
	public static double min(double a, double b, double c) {
		double result=a;
		if (b<result) result=b;
		if (c<result) result=c;
		return result;
	}
	
	/** Return the maximum of three values */
	public static double max(double a, double b, double c) {
		double result=a;
		if (b>result) result=b;
		if (c>result) result=c;
		return result;
	}
	
	/** Return the minimum of three values */	
	public static float min(float a, float b, float c) {
		float result=a;
		if (b<result) result=b;
		if (c<result) result=c;
		return result;
	}
	
	/** Return the maximum of three values */
	public static float max(float a, float b, float c) {
		float result=a;
		if (b>result) result=b;
		if (c>result) result=c;
		return result;
	}
	
	/** Return the minimum of four values */	
	public static final float min(float a, float b, float c, float d) {
	    float result=a;
		if (result > b) result = b;
	    if (result > c) result = c;
	    if (result > d) result = d;
	    return result;
	}

	/** Return the maximum of four values */	
	public static final float max(float a, float b, float c, float d) {
		float result=a;
		if (result < b) result = b;
	    if (result < c) result = c;
	    if (result < d) result = d;
	    return result;
	}

	/** Return the minimum of two numbers */
	public static int min(final int a, final int b) {
		// oddly, this seems to outperform java.lang.Math.min by about 10% on caliper tests.....
		return (a<b)?a:b;
	}
	
	/** Return the maximum of two numbers */
	public static int max(final int a, final int b) {
		return (a>b)?a:b;
	}
	
	
	/** Return the minimum of two numbers */
	public static float min(float a, float b) {
		return (a<b)?a:b;
	}
	
	/** Return the maximum of two numbers */
	public static float max(float a, float b) {
		return (a>b)?a:b;
	}
	
	/** Return the minimum of three numbers */
	public static int min(int a, int b, int c) {
		int result=a;
		if (b<result) result=b;
		if (c<result) result=c;
		return result;
	}
	
	/** Return the maximum of three numbers */
	public static int max(int a, int b, int c) {
		int result=a;
		if (b>result) result=b;
		if (c>result) result=c;
		return result;
	}
	
	/**
	 * Standard logistic function
	 * @param x
	 * @return
	 */
	public static double logistic (double x) {
		double ea=Math.exp(-x);
		double df=(1/(1.0f+ea));
		if (Double.isNaN(df)) return (x>0)?1:0;
		return df;
	}
	
	public static double softplus (double x) {
		if (x>100) return x;
		if (x<-100) return 0.0;
		return Math.log(1+Math.exp(x));
	}
	

	public static double tanhScaled(double x) {
		return 1.7159*Math.tanh((2.0/3.0)*x);
	}
	
	public static double tanhScaledDerivative(double x) {
		double ta=Math.tanh((2.0/3.0)*x);
		return (1.7159*(2.0/3.0))*(ta*(1-ta));
	}
	
	public static double inverseLogistic (double y) {
		if (y>=1) return 800;
		if (y<=0) return -800;
		double ea=y/(1.0-y);
		return Math.log(ea);
	}
	
	public static double logisticDerivative (double x) {
		double sa=logistic(x);
		return sa*(1-sa);
	}

	
	public static double tanhDerivative (double x) {
		double sa=Math.tanh(x);
		return 1.0-(sa*sa);
	}
	


	
	/** Return the (always non-negative) fractional part of a number */
	public static float frac(float a) {
		return a-roundDown(a);
	}
	
	/** Return the (always non-negative) fractional part of a number */
	public static double frac(double a) {
		return a-Math.floor(a);
	}


	/** Return the square of a number */
	public static int square(byte b) {
		return b*b;
	}
	
	/** Return the square of a number */
	public static int square(int x) {
		return x*x;
	}
	
	/** Return the square of a number */
	public static float square(float x) {
		return x*x;
	}
	
	/** Return the square of a number */
	public static double square(double x) {
		return x*x;
	}
	
	/** Round up to next integer */
	public static int roundUp(double x) {
		int i=(int) x;
		return (i==x)?i:(i+1);
	}
	
	
	
	/** Round up to next integer */
	public static int roundUp(Number x) {
		return roundUp(x.doubleValue());
	}
	
	/** Round up to next integer */
	public static int roundUp(float x) {
		int i=(int) x;
		return (i==x)?i:(i+1);
	}

	/** Rounds down (integer floor) of a double value */	
	public static int roundDown(double x) {
		if (x>=0) return (int)x;
		int r=(int)x;
		return (x==r)?r:r-1;
	}
	
	/** Round down to next smallest integer (towards negative infinity) */
	public static int roundDown(float x) {
		if (x>=0) return (int)x;
		int r=(int)x;
		return (x==r)?r:r-1;
	}
	
	/**
	 * Soft maximum function
	 */
	public static double softMaximum(double x, double y) {
		double max=Math.max(x, y);
		double min=Math.min(x, y);
		return max+Math.log(1.0+Math.exp(max-min));
	}
	
	/** Bound a value within a given range */
	public static final double bound(double v, double min, double max) {
		if (v<min) return min;
		if (v>max) return max;
		return v;
	}
	
	/** Bound a value within a given range */
	public static final float bound(float v, float min, float max) {
		if (v<min) return min;
		if (v>max) return max;
		return v;
	}
	
	/** Bound a value within a given range */
	public static final int bound(int v, int min, int max) {
		if (v<min) return min;
		if (v>max) return max;
		return v;
	}
	
	/**
	 * Returns (x^pow) mod (2^32) as an int
	 */
	public static int modPower32Bit(int x, int pow) {
		int result=1;
		for (int n = pow; n > 0; n >>>= 1) {
			if ((n & 1) != 0) {
				result *= x;
			}
			x *= x;
		}
		return result;
	}

	/** Tests whether a value is near zero, to a default tolerance level */
	public static boolean notNearZero(double x) {
		return (x<-EPSILON)||(x>EPSILON);
	}
	
    /** Double mod function with fractional divisor */
	public static double mod(double num, double div) {
		double result=num%div;
		if (result<0) result+=div;
		return result;
	}
	
    /** Triangle wave with wavelength 1.0, and range 0.0 - 1.0 */
	public static double triangleWave(double x) {
		x-=Math.floor(x);
		return (x<0.5)?x*2:(2-x*2);
	}

	
}
