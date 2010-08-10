/**
 * The Units of Measure API, UCUM codes, UCUM table (regardless of format),
 * and UCUM Specification are copyright © 1999-2010,
 * Regenstrief Institute, Inc. and the Unified Codes for Units of Measures
 * (UCUM) Organization. All rights reserved.
 *
 * See TermsOfUse for details.
 */
package org.unitsofmeasure.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.unitsofmeasure.SystemOfUnits;

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
