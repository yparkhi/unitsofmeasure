/**
 * Copyright (c) 2013, Werner Keil and others.
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.impl.model;

import static org.junit.Assert.*;
import static org.unitsofmeasurement.impl.system.SI.*;

import javax.measure.Quantity;
import javax.measure.quantity.*;

import org.junit.Test;

/**
 * @author Werner Keil
 *
 */
public class QuantityFactoryTest {

	@Test
	public void testLength() {
		Length l =  QuantityFactory.getInstance(Length.class).apply(23.5, METRE); // 23.0 km
		assertEquals(Double.valueOf(23.5d), l.getValue());
		assertEquals(METRE, l.getUnit());
		assertEquals("m", l.getUnit().getSymbol());
	}

	
	@Test
	public void testMass() {
		Mass m = QuantityFactory.getInstance(Mass.class).apply(10, KILOGRAM); // 10 kg
		assertEquals(Integer.valueOf(10), m.getValue());
		assertEquals(KILOGRAM, m.getUnit());
		assertEquals("kg", m.getUnit().getSymbol());
		assertEquals("10 kg", m.toString());
	}
	
	@Test
	public void testTime() {
		Quantity<Time> t = QuantityFactory.getInstance(Time.class).apply(40, MINUTE); // 40 min
		assertEquals(Integer.valueOf(40), t.getValue());
		assertEquals(MINUTE, t.getUnit());
		assertEquals("s", t.getUnit().getSymbol()); // FIXME this should be "min", tweak for TransformedUnit
		assertEquals("40 min", t.toString());
	}

}
