package mikera.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestFloatMaths {

	@Test public void testFastSqrt() {
		assertEquals(0.5,FloatMaths.fastInverseSqrt(4),0.01f);
		
	}
	
	@Test public void testMod() {
		assertEquals(0.2f,FloatMaths.mod(1.2f, 1.0f),0.00001f);
		assertEquals(0.2f,FloatMaths.mod(-0.8f, 1.0f),0.00001f);

		assertEquals(0.2f,FloatMaths.mod(1.6f, 1.4f),0.00001f);
		assertEquals(0.0f,FloatMaths.mod(1.6f, 1.6f),0.00001f);

		
		assertEquals(2.0f,FloatMaths.mod(-8f, 10.0f),0.00001f);

		
	}
}
