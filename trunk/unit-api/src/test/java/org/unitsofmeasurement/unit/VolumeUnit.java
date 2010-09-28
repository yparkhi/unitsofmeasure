/**
 * Unit-API - Units of Measurement API for Java (http://unitsofmeasurement.org)
 * Copyright (c) 2005-2010, Unit-API contributors, JScience and others
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.unit;

import org.unitsofmeasurement.unit.Unit;
import org.unitsofmeasurement.quantity.Volume;

/**
 * @author paul.morrison
 *
 */
public class VolumeUnit extends AbstractUnit<Volume> {
    public static final VolumeUnit cumetre = new VolumeUnit("cumetre", 1.0); // reference
    // Unit
    public static final VolumeUnit REF_UNIT = cumetre; // reference Unit
    public static final VolumeUnit cumile = new VolumeUnit("cumile",
        1609.0 * 1609.0 * 1609.0);
    public static final VolumeUnit bushel = new VolumeUnit("bushel", 0.03524);
    public static final VolumeUnit litre = new VolumeUnit("litre", 0.001);
    public static final VolumeUnit cc = new VolumeUnit("cc", 1.0e-6);

    public VolumeUnit(String name2, double convF) {
    name = name2;
    multFactor = convF;
    }

    @Override
    public Unit<Volume> getSystemUnit() {
    return REF_UNIT;
    }

}
