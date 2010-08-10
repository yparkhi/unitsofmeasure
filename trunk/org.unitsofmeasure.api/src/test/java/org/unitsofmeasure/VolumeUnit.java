/**
 * The Units of Measure API, UCUM codes, UCUM table (regardless of format),
 * and UCUM Specification are copyright © 1999-2010,
 * Regenstrief Institute, Inc. and the Unified Codes for Units of Measures
 * (UCUM) Organization. All rights reserved.
 *
 * See TermsOfUse for details.
 */
package org.unitsofmeasure;

import org.unitsofmeasure.quantity.Volume;

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
    public Unit<Volume> toMetric() {
	return REF_UNIT;
    }

}
