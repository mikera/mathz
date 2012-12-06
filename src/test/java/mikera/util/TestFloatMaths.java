package mikera.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestFloatMaths {

	@Test public void testFastSqrt() {
		assertEquals(0.5,FloatMaths.fastInverseSqrt(4),0.01f);
		
		// System.out.println(Maths.alternateSqrt(33f)+" vs."+Maths.sqrt(33f));
	}
}
