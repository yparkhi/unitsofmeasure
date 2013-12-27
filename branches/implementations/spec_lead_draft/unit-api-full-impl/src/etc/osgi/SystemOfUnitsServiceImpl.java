/*
 * JScience - Java(TM) Tools and Libraries for the Advancement of Sciences.
 * Copyright (C) 2010 - JScience (http://jscience.org/)
 * All rights reserved.
 *
 * Permission to use, copy, modify, and distribute this software is
 * freely granted, provided that this notice is preserved.
 */
package org.unitsofmeasurement.impl.internal.osgi;

import org.unitsofmeasurement.impl.unit.system.SI;
import org.unitsofmeasurement.impl.unit.system.UCUM;
import javax.measure.service.SystemOfUnitsService;
import javax.measure.SystemOfUnits;

/**
 * SystemOfUnitsService Implementation.
 */
class SystemOfUnitsServiceImpl implements SystemOfUnitsService {

    /**
     * Returns the SI instance.
     */
    public SystemOfUnits getSystemOfUnits() {
        return SI.getInstance();
    }

    /**
     * Returns the instance having the specified name.
     */
    public SystemOfUnits getSystemOfUnits(String name) {
        if (name.equals("SI")) return SI.getInstance();
        if (name.equals("UCUM")) return UCUM.getInstance();
        return null;
    }
    
}
