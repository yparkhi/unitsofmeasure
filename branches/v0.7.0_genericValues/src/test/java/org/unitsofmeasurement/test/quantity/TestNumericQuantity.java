/**
 * Unit-API - Units of Measurement API for Java (http://unitsofmeasurement.org)
 * Copyright (c) 2005-2011, Unit-API contributors, JScience and others
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.test.quantity;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.unitsofmeasurement.Measurement;
import org.unitsofmeasurement.quantity.Quantity;
import org.unitsofmeasurement.test.unit.BaseUnit;
import org.unitsofmeasurement.test.unit.TestUnit;
import org.unitsofmeasurement.unit.Unit;

/**
 * @author Werner Keil
 */
class TestNumericQuantity<Q extends Quantity<Q, Number>> implements
		Measurement<Q, Number> {
	protected TestUnit<Q, Number> unit;
	protected double scalar; // value in reference units
	protected double units; // value in units (Unit unit)

	@SuppressWarnings("unchecked")
	protected TestNumericQuantity<Q> add(TestNumericQuantity<Q> dn,
			TestNumericQuantity<Q> d1, TestNumericQuantity<?> d2,
			BaseUnit<Number> au) {
		if (d1.unit == d2.unit) {
			dn.unit = d1.unit;
			dn.scalar = d1.scalar + d2.scalar;
			dn.units = d1.units + d2.units;
		} else {
			dn.unit = au;
			dn.scalar = d1.scalar + d2.scalar;
			dn.units = dn.scalar;
		}
		return dn;
	}

	/** Only to be called by subclasses */
	protected TestNumericQuantity() {

	}

	protected TestNumericQuantity<Q> addInternal(
			final TestNumericQuantity<Q> toAdd) {
		toAdd.scalar = toAdd.scalar + this.scalar;
		toAdd.units = toAdd.units + this.units;
		return toAdd;
	}

	@SuppressWarnings("unchecked")
	protected TestNumericQuantity<Q> subtract(final TestNumericQuantity<Q> dn,
			final TestNumericQuantity<Q> d1, TestNumericQuantity<Q> d2,
			BaseUnit<Number> au) {
		if (d1.unit == d2.unit) {
			dn.unit = d1.unit;
			dn.scalar = d1.scalar - d2.scalar;
			dn.units = d1.units - d2.units;
		} else {
			dn.unit = au;
			dn.scalar = d1.scalar - d2.scalar;
			dn.units = dn.scalar;
		}
		return dn;

	}

	public boolean eq(TestNumericQuantity<Q> d1) {
		return (scalar == d1.scalar);
	}

	public boolean ne(TestNumericQuantity<Q> d1) {
		return (scalar != d1.scalar);
	}

	public boolean gt(TestNumericQuantity<Q> d1) {
		return (scalar > d1.scalar);
	}

	public boolean lt(TestNumericQuantity<Q> d1) {
		return (scalar < d1.scalar);
	}

	public boolean ge(TestNumericQuantity<Q> d1) {
		return (scalar >= d1.scalar);
	}

	public boolean le(TestNumericQuantity<Q> d1) {
		return (scalar <= d1.scalar);
	}

	public String toString() {
		return (new Double(units)).toString() + ' ' + unit;
	}

	String showInUnits(BaseUnit<?> u, int precision) {
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

		return str + exp + ' ' + u.getName();

	}

	@Override
	public Number value() {
		return Double.valueOf(units);
	}

	@Override
	public Unit<Q, Number> unit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Measurement<Q, Number> add(Measurement<Q, Number> that) {
		return addInternal((TestNumericQuantity<Q>) that);
	}

	@Override
	public Measurement<Q, Number> substract(Measurement<Q, Number> that) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Measurement<?, Number> multiply(Measurement<?, Number> that) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Measurement<?, Number> multiply(Number that) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Measurement<?, Number> divide(Measurement<?, Number> that) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Measurement<? extends Measurement<Q, Number>, Number> inverse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Measurement<Q, Number> to(Unit<Q, Number> unit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double doubleValue(Unit<Q, Number> unit) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long longValue(Unit<Q, Number> unit) {
		// TODO Auto-generated method stub
		return 0;
	}

}
