/**
 * Unit-API - Units of Measurement API for Java (http://unitsofmeasurement.org)
 * Copyright (c) 2005-2011, Unit-API contributors, JScience and others
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.test.quantity;


import org.unitsofmeasurement.test.unit.BitRateUnit;
import org.unitsofmeasurement.test.unit.BitUnit;

/**
 * @author Werner Keil
 * @version 1.0
 */
public class BitQuantity extends TestQuantity {

    public BitQuantity(double val, BitUnit un) {
        units = val;
        unit = un;
        scalar = val * unit.getMultFactor();
    }

    public BitQuantity(){
    }

    /*
     * Distance(double val) {
     *
     * units = val; unit = m; // reference Unit scalar = val;
     *
     * }
     */
    public BitQuantity add(BitQuantity d1) {
        BitQuantity dn = new BitQuantity();
        Object o = super.add(dn, this, d1, BitUnit.REF_UNIT);
        return (BitQuantity) o;
    }


    public BitQuantity subtract(BitQuantity d1) {
        BitQuantity dn = new BitQuantity();
        Object o = super.subtract(dn, this, d1, BitUnit.REF_UNIT);
        return (BitQuantity) o;
    }


    public boolean eq(BitQuantity d1) {
        return super.eq(d1);
    }

    public boolean ne(BitQuantity d1) {
        return super.ne(d1);
    }

    public boolean gt(BitQuantity d1) {
        return super.gt(d1);
    }

    public boolean lt(BitQuantity d1) {
        return super.lt(d1);
    }

    public boolean ge(BitQuantity d1) {
        return super.ge(d1);
    }

    public boolean le(BitQuantity d1) {
        return super.le(d1);
    }

    public BitQuantity multiply(double v) {
        return new BitQuantity(units * v, (BitUnit) unit);
    }

    public BitQuantity divide(double v) {
        return new BitQuantity(units / v, (BitUnit) unit);
    }



    // mixed type operations
    // public AreaQuantity multiply(BitQuantity d1) {
    // BitQuantity dq0 = convert(DistanceUnit.m);
    // BitQuantity dq1 = d1.convert(DistanceUnit.m);
    // return new AreaQuantity(dq0.units * dq1.units, AreaUnit.sqmetre);
    // }
    //
    // public VolumeQuantity multiply(AreaQuantity a1) {
    // BitQuantity dq = convert(DistanceUnit.m);
    // AreaQuantity aq = a1.convert(AreaUnit.sqmetre);
    // return new VolumeQuantity(dq.units * aq.units, VolumeUnit.cumetre);
    // }
    // public Speed divide(TimeInterval t1) {
    // return new Speed(scalar /
    // t1.scalar, Speed.refUnit);
    // }
    // public TimeInterval divide(Speed s1) {
    // return new TimeInterval(scalar /
    // s1.scalar, TimeInterval.refUnit);
    // }

    public BitRateQuantity divide(TimeQuantity t) {
        return new BitRateQuantity(scalar / t.scalar, BitRateUnit.REF_UNIT);
    }

    public BitQuantity convert(BitUnit newUnit) {
        return new BitQuantity(scalar / newUnit.getMultFactor(), newUnit);
    }

    public String showInUnits(BitUnit u, int precision) {
        return super.showInUnits(u, precision);
    }
}
