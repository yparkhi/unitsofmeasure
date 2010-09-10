/**
 * Unit-API - Units of Measurement API for Java (http://unitsofmeasurement.org)
 * Copyright (c) 2005-2010, Unit-API contributors, JScience and others
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class MetricTest {

	private SystemOfUnits metric;

	@Before
	public void setUp() {
	// metric = Metric.getInstance();
	}

	@Test
	public void testGetUnits() {
	assertNull(metric);
	}

}
