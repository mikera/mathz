package mikera.util;

/*
 * Copyright (c) 2011.  Peter Lawrey
 *
 * "THE BEER-WARE LICENSE" (Revision 128)
 * As long as you retain this notice you can do whatever you want with this stuff.
 * If we meet some day, and you think this stuff is worth it, you can buy me a beer in return
 * There is no warranty.
 */

import org.junit.Test;

import static mikera.util.Unsigned.*;
import static junit.framework.Assert.assertEquals;

/**
 * @author peter.lawrey
 */
public class TestUnsigned {
	@SuppressWarnings("deprecation")
	@Test
	public void testAdd() {
		assertEquals((byte) 250, add((byte) 200, (byte) 50));

		assertEquals((short) 25000, add((short) 20000, (short) 5000));

		assertEquals((int) 2500000000L, add(2000000000, 500000000));

		assertEquals("18446744073709551614",
				asString(add(Long.MAX_VALUE, Long.MAX_VALUE)));
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testMinus() {
		assertEquals((byte) 200, minus((byte) 250, (byte) 50));

		assertEquals((short) 20000, minus((short) 25000, (short) 5000));

		assertEquals(2000000000, minus((int) 2500000000L, 500000000));

		assertEquals(Long.MAX_VALUE,
				minus(multiply(Long.MAX_VALUE, 2), Long.MAX_VALUE));
	}
}
