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
abstract class StringTestQuantity<Q extends Quantity<Q, String>> implements
		Quantity<Q, String> {
    protected double scalar; // value in reference units
    protected double units; // value in units (Unit unit)
	protected TestUnit unit;

    public Object add(StringTestQuantity dn, StringTestQuantity d1, StringTestQuantity d2, TestUnit<?> au) {
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
    public Object subtract(StringTestQuantity dn, StringTestQuantity d1, StringTestQuantity d2, TestUnit<?> au) {
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

    public boolean eq(StringTestQuantity d1) {
        return (scalar == d1.scalar);
    }
    public boolean ne(StringTestQuantity d1) {
        return (scalar != d1.scalar);
    }
    public boolean gt(StringTestQuantity d1) {
        return (scalar > d1.scalar);
    }
    public boolean lt(StringTestQuantity d1) {
        return (scalar < d1.scalar);
    }
    public boolean ge(StringTestQuantity d1) {
        return (scalar >= d1.scalar);
    }
    public boolean le(StringTestQuantity d1) {
        return (scalar <= d1.scalar);
    }

    public String toString() {
		return (value() + ' ' + unit.getName());
    }

    String showInUnits(TestUnit<?> u, int precision) {
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

	public String value() {
		return String.valueOf(units);
	}

	public Unit<Q, String> unit() {
		return unit;
	}

}
