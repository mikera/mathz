package mikera.util;

public class FloatMaths {
	
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


	public static final float smoothStep(float a, float b, float x) {
	    if (x <= a)
	        return 0;
	    if (x >= b)
	        return 1;
	    float t = bound(0.0f, (x - a) / (b - a), 1.0f);
	    return t * t * (3 - 2 * t);
	}
	

    /** Bound a value within a given range */
	public static final float bound(float min, float v, float max) {
		if (v<min) return min;
		if (v>max) return max;
		return v;
	}

}
