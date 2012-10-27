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
import org.unitsofmeasurement.unit.Unit;

/**
 * @author Werner Keil
 */
class TestNumericQuantity<Q extends Quantity<Q, Number>> extends
		TestQuantity<Number> implements
		Measurement<TestQuantity<Number>, Number> {
	protected double scalar; // value in reference units
	protected double units; // value in units (Unit unit)

	public TestNumericQuantity<Q> add(TestNumericQuantity<Q> dn,
			TestNumericQuantity<Q> d1, TestNumericQuantity<Q> d2,
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

	public TestNumericQuantity<Q> subtract(final TestNumericQuantity<Q> dn,
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
		return (new Double(units)).toString() + ' ' + unit.getName();
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
	public Unit<TestQuantity<Number>, Number> unit() {
		return unit;
	}

	@Override
	public Measurement<TestQuantity<Number>, Number> add(
			Measurement<TestQuantity<Number>, Number> that) {
		return this.addInternal((TestNumericQuantity<Q>) that);
	}

	@Override
	public Measurement<TestQuantity<Number>, Number> substract(
			Measurement<TestQuantity<Number>, Number> that) {
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
	public Measurement<? extends Measurement<TestQuantity<Number>, Number>, Number> inverse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Measurement<TestQuantity<Number>, Number> to(
			Unit<TestQuantity<Number>, Number> unit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double doubleValue(Unit<TestQuantity<Number>, Number> unit) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long longValue(Unit<TestQuantity<Number>, Number> unit) {
		// TODO Auto-generated method stub
		return 0;
	}

}