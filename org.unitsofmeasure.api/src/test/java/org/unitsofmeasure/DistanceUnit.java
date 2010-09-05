/**
 *  The Units of Measure API, UCUM codes, UCUM table (regardless of format),
 *  and UCUM Specification are copyright © 1999-2010, Regenstrief Institute, Inc.
 *  and the Unified Codes for Units of Measures (UCUM) Organization.
 *  All rights reserved.
 *
 * See TermsOfUse for details.
 */
package org.unitsofmeasure;

import org.unitsofmeasure.quantity.Length;

/**
 * @author paul.morrison
 * 
 */
public class DistanceUnit extends AbstractUnit<Length> {

    public static final DistanceUnit m = new DistanceUnit("m", 1.0); // reference
    // Unit
    public static final DistanceUnit REF_UNIT = m; // reference Unit
    public static final DistanceUnit in = new DistanceUnit("in", 0.0254);
    public static final DistanceUnit km = new DistanceUnit("km", 1.0e+3);
    public static final DistanceUnit mile = new DistanceUnit("mile", 1609.0);
    public static final DistanceUnit \u00C5ngstr\u00F6m = new DistanceUnit(
	    "\u00C5ngstr\u00F6m", 1.0e-10);
    public static final DistanceUnit AU = new DistanceUnit("AU", 1.5e+11);
    public static final DistanceUnit parsec = new DistanceUnit("parsec",
	    3.08e+16);

    public DistanceUnit(String name2, double convF) {
	name = name2;
	multFactor = convF;
    }

    public DistanceUnit(String name2, DistanceUnit unit, double convF) {
	name = name2;
	multFactor = unit.multFactor * convF;
    }

    @Override
    public Unit<Length> toMetric() {
	return REF_UNIT;
    }

}
