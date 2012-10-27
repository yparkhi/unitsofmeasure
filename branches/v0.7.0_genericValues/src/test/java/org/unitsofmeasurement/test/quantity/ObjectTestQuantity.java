/**
 * Unit-API - Units of Measurement API for Java (http://unitsofmeasurement.org)
 * Copyright (c) 2005-2012, Unit-API contributors, JScience and others
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.test.quantity;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.unitsofmeasurement.quantity.Quantity;
import org.unitsofmeasurement.test.unit.TestUnit;
import org.unitsofmeasurement.unit.Unit;

/**
 * @author Werner Keil
 * @version 1.0 ($Revision$), $Date$
 */
abstract class ObjectTestNumericQuantity<Q extends Quantity<Q, Object>>
		implements Quantity<Q, Object> {
    protected double scalar; // value in reference units
    protected double units; // value in units (Unit unit)
	protected Unit<Q, Object> unit;

	public Object add(ObjectTestNumericQuantity dn,
			ObjectTestNumericQuantity d1, ObjectTestNumericQuantity d2,
			TestUnit<?, Object> au) {
        if (d1.unit == d2.unit){
            dn.unit = d1.unit;
            dn.scalar = d1.scalar + d2.scalar;
            dn.units = d1.units + d2.units;
        }
        else {
            dn.unit = au;
            dn.scalar = d1.scalar + d2.scalar;
            dn.units = dn.scalar;
        }
        return dn;
    }

	public Object subtract(ObjectTestNumericQuantity dn,
			ObjectTestNumericQuantity d1, ObjectTestNumericQuantity d2,
			TestUnit<?, Object> au) {
        if (d1.unit == d2.unit){
            dn.unit = d1.unit;
            dn.scalar = d1.scalar - d2.scalar;
            dn.units = d1.units - d2.units;
        }
        else {
            dn.unit = au;
            dn.scalar = d1.scalar - d2.scalar;
            dn.units = dn.scalar;
        }
        return dn;

    }

    public boolean eq(ObjectTestNumericQuantity d1) {
        return (scalar == d1.scalar);
    }
    public boolean ne(ObjectTestNumericQuantity d1) {
        return (scalar != d1.scalar);
    }
    public boolean gt(ObjectTestNumericQuantity d1) {
        return (scalar > d1.scalar);
    }
    public boolean lt(ObjectTestNumericQuantity d1) {
        return (scalar < d1.scalar);
    }
    public boolean ge(ObjectTestNumericQuantity d1) {
        return (scalar >= d1.scalar);
    }
    public boolean le(ObjectTestNumericQuantity d1) {
        return (scalar <= d1.scalar);
    }

    public String toString() {
		return (new Double(units)).toString() + ' '
 + String.valueOf(value());
    }

	String showInUnits(TestUnit<?, Object> u, int precision) {
        double result = scalar / u.getMultFactor();

        String str = (new Double(result)).toString();
        char cs[] = str.toCharArray();
        int i = 0;
        while (i < cs.length && (cs[i] >= '0' && cs[i] <= '9' || cs[i] == '.'))
            i++;
        BigDecimal bd = new BigDecimal(new String(cs, 0, i));
        BigDecimal bd2 = bd.setScale(precision, RoundingMode.HALF_UP);
        str = bd2.toString();

        String exp = "";
        if (i < cs.length)
            exp = new String(cs, i, cs.length - i);

        return str + exp  + ' ' + u.getName();

    }

	public Object value() {
		return Double.valueOf(units);
	}

	public Unit<Q, Object> unit() {
		return unit;
	}

}
