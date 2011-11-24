/**
 * Unit-API - Units of Measurement API for Java (http://unitsofmeasurement.org)
 * Copyright (c) 2005-2010, Unit-API contributors, JScience and others
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.unit;

import org.unitsofmeasurement.unit.Unit;
import org.unitsofmeasurement.quantity.Area;

/**
 * @author paul.morrison
 */
public class AreaUnit extends AbstractUnit<Area> {

    public static final AreaUnit sqmetre = new AreaUnit("sqmetre", 1.0); // reference
    // Unit
    public static final AreaUnit REF_UNIT = sqmetre; // reference Unit
    public static final AreaUnit sqmile = new AreaUnit("sqmile",
        1609.0 * 1609.0);
    public static final AreaUnit acre = new AreaUnit("acre", 4047.0);
    public static final AreaUnit hectare = new AreaUnit("hectare", 1.0e4);

    public AreaUnit(String name2, double convF) {
    name = name2;
    multFactor = convF;

    }

    @Override
    public Unit<Area> getSystemUnit() {
    return REF_UNIT;
    }

}
