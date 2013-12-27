/**
 * Copyright (c) 2013, Werner Keil and others.
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.impl.model.quantity;

import static org.junit.Assert.*;
import static org.unitsofmeasurement.impl.system.SI.METRE;

import javax.measure.quantity.Length;

import org.junit.Before;
import org.junit.Test;

public class LengthTest {

	private Length sut;
	
	@Before
	public void init() {
		sut = new LengthAmount(Integer.valueOf(10), METRE);
	}
	
	@Test
	public void testUnit() {
		assertEquals(METRE, sut.getUnit());
	}
	
	@Test
	public void testValue() {
		assertEquals(Integer.valueOf(10), sut.getValue());
	}
	
	@Test
	public void testToString() {
		assertEquals("10 m", sut.toString());
	}

}
