/**
 * Unit-API - Units of Measurement API for Java (http://unitsofmeasurement.org)
 * Copyright (c) 2005-2012, Unit-API contributors, JScience and others
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.test.unit;

import java.util.Map;

import org.unitsofmeasurement.unit.Dimension;
import org.unitsofmeasurement.unit.IncommensurableException;
import org.unitsofmeasurement.unit.UnconvertibleException;
import org.unitsofmeasurement.unit.Unit;
import org.unitsofmeasurement.unit.UnitConverter;

/**
 * <p>
 * This class represents the building blocks on top of which all others units
 * are created. Base units are always unscaled metric units.
 * </p>
 * 
 * <p>
 * When using the {@linkplain Dimensional.Model#STANDARD standard} model
 * (default), all seven base units are dimensionally independent.
 * </p>
 * 
 * @param <Q>
 *            The type of the quantity measured by this unit.
 * 
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 1.8 ($Revision: 105 $), $Date: 2010-08-05 21:44:23 +0100 (Do, 05 Aug
 *          2010) $
 * @see <a href="http://en.wikipedia.org/wiki/SI_base_unit"> Wikipedia: SI base
 *      unit</a>
 */
public class BaseUnit<V> extends TestUnit {

	/**
	 * Creates a base unit having the specified symbol.
	 * 
	 * @param symbol
	 *            the symbol of this base unit.
	 * @throws IllegalArgumentException
	 *             if the specified symbol is associated to a different unit.
	 */
	@SuppressWarnings("unchecked")
	public BaseUnit(String symbol, String name) {
		super(name);
		this.symbol = symbol;
	}

	/**
	 * Creates a base unit having the specified symbol.
	 * 
	 * @param symbol
	 *            the symbol of this base unit.
	 * @throws IllegalArgumentException
	 *             if the specified symbol is associated to a different unit.
	 */
	public BaseUnit(String symbol) {
		this(symbol, null);
	}

	@Override
	public String getSymbol() {
		return symbol;
	}

	@Override
	public Unit getSystemUnit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dimension getDimension() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map getProductUnits() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCompatible(Unit that) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Unit asType(Class type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UnitConverter getConverterTo(Unit that)
			throws UnconvertibleException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UnitConverter getConverterToAny(
			@SuppressWarnings("rawtypes") Unit that)
			throws IncommensurableException, UnconvertibleException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Unit transform(UnitConverter operation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Unit add(double offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Unit multiply(double factor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Unit multiply(Unit that) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Unit inverse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Unit divide(double divisor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Unit divide(Unit that) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Unit root(int n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Unit pow(int n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean equals(Object that) {
		if (this == that)
			return true;
		if (!(that instanceof BaseUnit<?>))
			return false;
		BaseUnit<?> thatUnit = (BaseUnit<?>) that;
		return this.symbol.equals(thatUnit.symbol);
	}

	@Override
	public Unit alternate(String symbol) {
		// TODO Auto-generated method stub
		return null;
	}
}
