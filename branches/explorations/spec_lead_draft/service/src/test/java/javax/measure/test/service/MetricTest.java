/**
 * Unit-API - Units of Measurement API for Java (http://unitsofmeasurement.org)
 * Copyright (c) 2005-2011, Unit-API contributors, JScience and others
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure.test.service;

import static org.junit.Assert.assertNull;

import javax.measure.service.SystemOfUnitsService;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


@Ignore
public class MetricTest {

    private SystemOfUnitsService metric;

    @Before
    public void setUp() {
//      metric = Metric.getInstance();
    }

    @Test
    public void testGetUnits() {
        assertNull(metric);
    }
}
