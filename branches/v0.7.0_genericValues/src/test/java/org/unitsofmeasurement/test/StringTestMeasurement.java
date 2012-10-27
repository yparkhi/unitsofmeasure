/**
 * Unit-API - Units of Measurement API for Java (http://unitsofmeasurement.org)
 * Copyright (c) 2005-2012, Unit-API contributors, JScience and others
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.unitsofmeasurement.Measurement;
import org.unitsofmeasurement.quantity.Quantity;
import org.unitsofmeasurement.test.unit.TestUnit;
import org.unitsofmeasurement.unit.Unit;

/**
 * @author Werner Keil
 * @version 1.2 ($Revision$), $Date$
 */
public class StringTestMeasurement<Q extends Quantity<Q, String>> implements
		Measurement<Q, String> {
    protected double scalar; // value in reference units
    protected double units; // value in units (Unit unit)
	protected TestUnit<Q, String> unit;

	public Measurement<Q, String> add(StringTestMeasurement<Q> dn,
			StringTestMeasurement<Q> d1,
 StringTestMeasurement<?> d2,
			TestUnit<Q, String> au) {
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

	public Object subtract(StringTestMeasurement dn, StringTestMeasurement d1,
			StringTestMeasurement d2, TestUnit<?, String> au) {
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

    public boolean eq(StringTestMeasurement d1) {
        return (scalar == d1.scalar);
    }
    public boolean ne(StringTestMeasurement d1) {
        return (scalar != d1.scalar);
    }
    public boolean gt(StringTestMeasurement d1) {
        return (scalar > d1.scalar);
    }
    public boolean lt(StringTestMeasurement d1) {
        return (scalar < d1.scalar);
    }
    public boolean ge(StringTestMeasurement d1) {
        return (scalar >= d1.scalar);
    }
    public boolean le(StringTestMeasurement d1) {
        return (scalar <= d1.scalar);
    }

    public String toString() {
		return (value() + ' ' + unit.getName());
    }

	String showInUnits(TestUnit<?, String> u, int precision) {
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

	@Override
	public Measurement<Q, String> add(Measurement<Q, String> that) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Measurement<Q, String> substract(Measurement<Q, String> that) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Measurement<?, String> multiply(Measurement<?, String> that) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Measurement<?, String> multiply(String that) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Measurement<?, String> divide(Measurement<?, String> that) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Measurement<? extends Measurement<Q, String>, String> inverse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Measurement<Q, String> to(Unit<Q, String> unit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double doubleValue(Unit<Q, String> unit) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long longValue(Unit<Q, String> unit) {
		// TODO Auto-generated method stub
		return 0;
	}

}
