package mikera.util.mathz;

import mikera.util.Maths;

/**
 * Static class for specialised maths functions that return floats
 * 
 * @author Mike
 *
 */
public final class FloatMaths {
	
	/** Float round to a specified number of decimal places */
	public static float round(float f, int dp) {
		float factor=(float)Math.pow(10, -dp);
		return Math.round(f/factor)*factor;
	}
	
	/**
	 * Computes a fast approximation to <code>Math.pow(a, b)</code>. Adapted
	 * from <url>http://www.dctsystems.co.uk/Software/power.html</url>.
	 * 
	 * @param a a positive number
	 * @param b a number
	 * @return a^b
	 */
	public static final float fastPower(float a, float b) {
	    // adapted from: http://www.dctsystems.co.uk/Software/power.html
	    float x = Float.floatToRawIntBits(a);
	    x *= 1.0f / (1 << 23);
	    x = x - 127;
	    float y = x - (int) Math.floor(x);
	    b *= x + (y - y * y) * 0.346607f;
	    y = b - (int) Math.floor(b);
	    y = (y - y * y) * 0.33971f;
	    return Float.intBitsToFloat((int) ((b + 127 - y) * (1 << 23)));
	}
	

	/** Linear interpolation between a and b */
	public static final float lerp(float t,float a, float b) {
	    return (1-t) * a + t*b;		
	}
	
	/** Smooth factor function for linear interpolation, with dy/dx=0 at x=0 and x=1 */
	public static final float smoothFactor(float x) {
	    return x * x * (3 - (2 * x));		
	}
	
	
	/** Mod function implemented for float values */
	public static float mod(float n, float d) {
		float x=n/d;
		return n- (Maths.roundDown(x)*d);
	}


	public static final float smoothStep(float a, float b, float x) {
	    if (x <= a)
	        return 0;
	    if (x >= b)
	        return 1;
	    float t = bound((x - a) / (b - a), 0.0f, 1.0f);
	    return t * t * (3 - 2 * t);
	}
	

    /** Bound a value within a given range */
	public static final float bound(float v, float min, float max) {
		if (v<min) return min;
		if (v>max) return max;
		return v;
	}
	
	/** float abs function */
	public static float abs(final float a) {
		if (a<0) return -a;
		return a;
	}

	/** Square function */
	public static float square(float x) {
		return x*x;
	}
	
	/**
	 * Interesting way to approximate a square root.... however seems to be slower than standard Math.sqrt() approach
	 * @param x
	 * @return
	 */
	public static float alternateSqrt(float x) {
		if (x<0) return 0;
		float r=approxSqrt(x);
		r=r-(0.5f*((r*r)-x)/r); // Newton iteration
		r=r-(0.5f*((r*r)-x)/r); // Newton iteration
		return r;
	}
	
	/** Fast approximate square root */
	public static float approxSqrt(float x) {
	    int i = Float.floatToRawIntBits(x);
	    //int exponent=i&0x7F800000; // 8 bits below sign bit
	    //int value=(i&0x7FFFFFF)+((exponent!=0)?0:0x08000000); // 23 low bits, implicit 1 unless exponent=0
	    i=(i+0x3F800000)>>>1;
	    return Float.intBitsToFloat(i);
	}
	
	
	/** Fast inverse square root on floats - amusing hack used in Quake */
	public static float fastInverseSqrt(float x) {
	    float xhalf = 0.5f*x;
	    int i = Float.floatToRawIntBits(x);
	    i = 0x5F3759DF - (i>>1);
	    x = Float.intBitsToFloat(i);
	    x = x*(1.5f - xhalf*x*x);
	    return x;
	}
	
	public static float sin(double a) {
		a = a % Maths.TWO_PI;
		return (float)Math.sin(a);
	}
	
	public static float cos(double a) {
		a = a % Maths.TWO_PI;
		return (float)Math.cos(a);
	}

	public static float sin(float a) {
		a =  a % ((float) Maths.TWO_PI);
		return (float)Math.sin(a);
	}
	
	public static float cos(float a) {
		a =  a % ((float) Maths.TWO_PI);
		return (float)Math.cos(a);
	}
}
