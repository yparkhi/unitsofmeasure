/**
 * Unit-API - Units of Measurement API for Java (http://unitsofmeasurement.org)
 * Copyright (c) 2005-2011, Unit-API contributors, JScience and others
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.test.unit;

import org.unitsofmeasurement.quantity.Time;
import org.unitsofmeasurement.unit.Unit;


/**
 * @author Werner Keil
 * @version 1.1
 */
public class TimeUnit extends BaseUnit<Time> {

    public static final TimeUnit s = new TimeUnit("s", 1.0); // reference Unit
    public static final TimeUnit REF_UNIT = s; // reference Unit
    public static final TimeUnit h = new TimeUnit("h", 60);

    public TimeUnit(String name2, double convF) {
        super(name2, "");
        name = name2;
        multFactor = convF;
    }

    @Override
    public Unit<Time> getSystemUnit() {
        return REF_UNIT;
    }
}
