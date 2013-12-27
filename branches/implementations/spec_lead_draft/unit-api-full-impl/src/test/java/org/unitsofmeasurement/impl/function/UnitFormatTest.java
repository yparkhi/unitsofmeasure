/**
 * Copyright (c) 2013, Werner Keil and others.
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.impl.function;

import static org.junit.Assert.*;
import static org.unitsofmeasurement.impl.system.SI.METRE;
import static org.unitsofmeasurement.impl.system.SI.MINUTE;
import static org.unitsofmeasurement.impl.system.SI.SECOND;
import static org.unitsofmeasurement.impl.system.SI.KILOGRAM;

import java.io.IOException;

import javax.measure.Unit;
import javax.measure.exception.ParserException;
import javax.measure.function.UnitFormat;
import javax.measure.quantity.Length;
import javax.measure.quantity.Velocity;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.unitsofmeasurement.impl.model.quantity.LengthAmount;

public class UnitFormatTest {
	private Length sut;

	@Before
	public void init() {
		sut = new LengthAmount(Integer.valueOf(10), METRE);
	}

	@Test
	public void testFormatLocal() {
		final UnitFormat format = LocalUnitFormat.getInstance();
		final Appendable a = new StringBuilder();
		try {
			format.format(METRE, a);
		} catch (IOException e) {
			fail(e.getMessage());
		}
		assertEquals(METRE, sut.getUnit());
		assertEquals("m", a.toString());

		final Appendable a2 = new StringBuilder();
		@SuppressWarnings("unchecked")
		Unit<Velocity> v = (Unit<Velocity>) sut.getUnit().divide(SECOND);
		try {
			format.format(v, a2);
		} catch (IOException e) {
			fail(e.getMessage());
		}
		assertEquals("m/s", a2.toString());
	}

	@Test
	public void testFormatUCUMPrint() {
		final UnitFormat format = UCUMFormat.getPrintInstance();
		final Appendable a = new StringBuilder();
		try {
			format.format(METRE, a);
		} catch (IOException e) {
			fail(e.getMessage());
		}
		assertEquals(METRE, sut.getUnit());
		assertEquals("m", a.toString());

		final Appendable a2 = new StringBuilder();
		@SuppressWarnings("unchecked")
		Unit<Velocity> v = (Unit<Velocity>) sut.getUnit().divide(SECOND);
		try {
			format.format(v, a2);
		} catch (IOException e) {
			fail(e.getMessage());
		}
		assertEquals("1/s.m", a2.toString());
	}

	@Test
	public void testFormatUCUMCS() {
		final UnitFormat format = UCUMFormat.getCaseSensitiveInstance();
		final Appendable a = new StringBuilder();
		try {
			format.format(METRE, a);
		} catch (IOException e) {
			fail(e.getMessage());
		}
		assertEquals(METRE, sut.getUnit());
		assertEquals("m", a.toString());

		final Appendable a2 = new StringBuilder();
		@SuppressWarnings("unchecked")
		Unit<Velocity> v = (Unit<Velocity>) sut.getUnit().divide(SECOND);
		try {
			format.format(v, a2);
		} catch (IOException e) {
			fail(e.getMessage());
		}
		assertEquals("1/s.m", a2.toString());
	}

	@Test
	public void testFormatUCUMCI() {
		final UnitFormat format = UCUMFormat.getCaseInsensitiveInstance();
		final Appendable a = new StringBuilder();
		try {
			format.format(METRE, a);
		} catch (IOException e) {
			fail(e.getMessage());
		}
		assertEquals(METRE, sut.getUnit());
		assertEquals("M", a.toString());
	}

	@Test
	@Ignore
	public void testParseLocal() {
		final UnitFormat format = LocalUnitFormat.getInstance();
		try {
			Unit u = format.parse("min");
		} catch (ParserException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testParseUCUMCI() {
		final UnitFormat format = UCUMFormat.getCaseInsensitiveInstance();
		try {
			Unit u = format.parse("min");
			assertEquals(MINUTE, u);
		} catch (ParserException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testParseUCUMCS() {
		final UnitFormat format = UCUMFormat.getCaseInsensitiveInstance();
		try {
			Unit u = format.parse("M");
			assertEquals(METRE, u);
		} catch (ParserException e) {
			fail(e.getMessage());
		}
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void testParseUCUMPrint() {
		final UnitFormat format = UCUMFormat.getPrintInstance();
		try {
			Unit u = format.parse("kg");
			assertEquals(KILOGRAM, u);
		} catch (ParserException e) {
			fail(e.getMessage());
		}
	}
}
