/**
 * Unit-API - Units of Measurement API for Java (http://unitsofmeasurement.org)
 * Copyright (c) 2005-2011, Unit-API contributors, JScience and others
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.test.unit;

import java.util.Map;

import org.unitsofmeasurement.quantity.Dimensionless;
import org.unitsofmeasurement.quantity.Quantity;
import org.unitsofmeasurement.unit.Dimension;
import org.unitsofmeasurement.unit.IncommensurableException;
import org.unitsofmeasurement.unit.UnconvertibleException;
import org.unitsofmeasurement.unit.Unit;
import org.unitsofmeasurement.unit.UnitConverter;

/**
 * @author paul.morrison
 * 
 */
public abstract class TestUnit<Q extends Quantity<Q>> implements Unit<Q> {

	public static final Unit<Dimensionless> ONE = new BaseUnit<Dimensionless>(
			"one");

	// public static final Unit<Mass> METRIC_MASS = QuantityFactory.getInstance(
	// Mass.class).getMetricUnit();

	String symbol; // e.g. "A"
	String name; // e.g. "Angstrom"
	double multFactor; // e.g. 1E-10
	double addFactor = 0.0; // used for temperatures

	protected TestUnit() {

	}

	public TestUnit(String name, double factor) {
		this.name = name;
		this.multFactor = factor;
	}

	protected TestUnit(String name) {
		this(name, 0);
	}

	public Unit<Q> add(double offset) {
		// TODO Auto-generated method stub
		return null;
	}

	public Unit<?> alternate(String symbol) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T extends Quantity<T>> Unit<T> asType(Class<T> type)
			throws ClassCastException {
		// Unit<T> metricUnit =
		// QuantityFactory.getInstance(type).getMetricUnit();
		// if ((metricUnit == null) || metricUnit.isCompatible(this))
		// return (Unit<T>) this;
		//  throw new ClassCastException("The unit: " + this //$NON-NLS-1$
		//      + " is not of parameterized type " + type); //$NON-NLS-1$
		// // TODO use MsgFormat
		return null;
	}

	public Unit<Q> divide(double divisor) {
		// TODO Auto-generated method stub
		return null;
	}

	public Unit<?> divide(Unit<?> that) {
		// TODO Auto-generated method stub
		return null;
	}

	public UnitConverter getConverterTo(Unit<Q> that)
			throws UnconvertibleException {
		// TODO Auto-generated method stub
		return null;
	}

	public UnitConverter getConverterToAny(Unit<?> that)
			throws IncommensurableException, UnconvertibleException {
		// TODO Auto-generated method stub
		return null;
	}

	public Dimension getDimension() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getName() {
		return name;
	}

	public Map<Unit<?>, Integer> getProductUnits() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSymbol() {
		return symbol;
	}

	public Unit<?> inverse() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isCompatible(Unit<?> that) {
		// TODO Auto-generated method stub
		return false;
	}

	public Unit<Q> multiply(double factor) {
		// TODO Auto-generated method stub
		return null;
	}

	public Unit<?> multiply(Unit<?> that) {
		// TODO Auto-generated method stub
		return null;
	}

	public Unit<?> pow(int n) {
		// TODO Auto-generated method stub
		return null;
	}

	public Unit<?> root(int n) {
		// TODO Auto-generated method stub
		return null;
	}

	public abstract Unit<Q> getSystemUnit();

	public Unit<Q> transform(UnitConverter operation) {
		// TODO Auto-generated method stub
		return null;
	}

	public double getMultFactor() {
		return multFactor;
	}
}
