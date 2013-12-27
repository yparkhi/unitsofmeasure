/*
 * JScience - Java(TM) Tools and Libraries for the Advancement of Sciences.
 * Copyright (C) 2010-2013 - JScience (http://jscience.org/)
 * All rights reserved.
 *
 * Permission to use, copy, modify, and distribute this software is
 * freely granted, provided that this notice is preserved.
 */
package org.unitsofmeasurement.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

import javax.measure.Measurement;
import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.exception.IncommensurableException;
import javax.measure.exception.UnconvertibleException;
import javax.measure.function.UnitConverter;

import org.unitsofmeasurement.impl.function.AbstractConverter;

/**
 * An amount of quantity, consisting of a Number and a Unit. BaseMeasurement
 * objects are immutable.
 * 
 * @see java.lang.Number
 * @see MeasureUnit
 * @author <a href="mailto:uomo@catmedia.us">Werner Keil</a>
 * @param <Q>
 *            The type of the quantity.
 * @version 1.4 ($Revision: 212 $), $Date: 2013-12-25 $
 *          FIXME Bug 338334 overwrite equals()
 */
public class BaseMeasurement<Q extends Quantity<Q>> extends AbstractMeasurement<Q>
		implements Measurement<Q, Number>, Comparable<BaseMeasurement<Q>> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1794798190459768561L;

	
	private final Number value;
	
	/**
	 * Holds a dimensionless measure of one (exact).
	 */
//	public static final Quantity<Dimensionless> ONE =
//			QuantityFactory.getInstance(Dimensionless.class).create(
//					BigDecimal.ONE, AbstractUnit.ONE);
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.icu.util.Measure#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (this.getClass() == obj.getClass()) {
			return super.equals(obj);
		} else {
			if (obj instanceof Quantity) {
				@SuppressWarnings("rawtypes")
				Quantity m = (Quantity) obj;
				if (m.getValue().getClass() == this.getValue().getClass()
						&& m.getUnit().getClass() == this.getUnit().getClass()) {
					return super.equals(obj);
				} else {
					// if (this.getQuantityUnit() instanceof AbstractUnit<?>) {
					// if
					// }
					return super.equals(obj);
				}
			}
			return false;
		}
	}

	/**
	 * Indicates if this measure is exact.
	 */
	private final boolean isExact;

	/**
	 * Indicates if this measure is big.
	 */
	private final boolean isBig;
	
	/**
	 * Holds the exact value (when exact) stated in this measure unit.
	 */
	// private long _exactValue;

	/**
	 * Holds the minimum value stated in this measure unit. For inexact
	 * measures: _minimum < _maximum
	 */
	// private double _minimum;

	/**
	 * Holds the maximum value stated in this measure unit. For inexact
	 * measures: _maximum > _minimum
	 */
	// private double _maximum;

	protected BaseMeasurement(Number number, Unit<Q> unit) {
		super(unit);
		value = number;
		isExact = false;
		isBig = false;;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Measurement#doubleValue(org.unitsofmeasurement.unit
	 * .Unit)
	 */
	public double doubleValue(Unit<Q> unit) {
		Unit<Q> myUnit = getUnit();
		try {
			UnitConverter converter = unit.getConverterTo(myUnit);
			return converter.convert(getValue().doubleValue());
		} catch (UnconvertibleException e) {
			throw e;
		} // catch (IncommensurableException e) {
		// throw new IllegalArgumentException(e.getMessage());
		// }
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.uomo.units.AbstractMeasurement#longValue(org.unitsofmeasurement.unit
	 * .Unit)
	 */
	public long longValue(Unit<Q> unit) {
		Unit<Q> myUnit = getUnit();
		try {
			UnitConverter converter = unit.getConverterToAny(myUnit);
			if ((getValue() instanceof BigDecimal || getValue() instanceof BigInteger) 
					&& converter instanceof AbstractConverter) {
				return (((AbstractConverter)converter).convert(
						BigDecimal.valueOf(getValue().longValue()),
						MathContext.DECIMAL128)).longValue();
			} else {
		        double result = doubleValue(unit);
		        if ((result < Long.MIN_VALUE) || (result > Long.MAX_VALUE)) {
		            throw new ArithmeticException("Overflow (" + result + ")");
		        }
		        return (long) result;
			}
		} catch (UnconvertibleException e) {
			throw e;
		} catch (IncommensurableException e) {
			throw new IllegalArgumentException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.measure.Quantity#getValue()
	 */
	public Number getValue() {
		return value;
	}

	/**
	 * Indicates if this measured amount is exact. An exact amount is guarantee
	 * exact only when stated in this measure unit (e.g.
	 * <code>this.longValue()</code>); stating the amount in any other unit may
	 * introduce conversion errors.
	 * 
	 * @return <code>true</code> if this measure is exact; <code>false</code>
	 *         otherwise.
	 */
	public boolean isExact() {
		return isExact;
	}
	
	/**
	 * Indicates if this measured amount is a big number, i.E. BigDecimal or BigInteger.
	 * In all other cases this would be false.
	 * 
	 * @return <code>true</code> if this measure is big; <code>false</code>
	 *         otherwise.
	 */
	public boolean isBig() {
		return isBig;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public BaseMeasurement<Q> add(AbstractMeasurement<Q> that) {
		final AbstractMeasurement<Q> thatToUnit = that.to(getUnit());
		return new BaseMeasurement(this.getValue().doubleValue()
				+ thatToUnit.getValue().doubleValue(), getUnit());
	}
	
	@Override
	public BaseMeasurement<?> multiply(Number that) {
		return (BaseMeasurement<Q>) of((getValue().doubleValue() * that
				.doubleValue()), getUnit());	
	}

	// ////////////////////
	// Factory Creation //
	// ////////////////////
	
//	private static <Q extends Quantity<Q>> QuantityAmount<Q> create(Number value, Unit<Q> unit) {
//		
//	}
	

//	@SuppressWarnings("unchecked")
//	protected static <Q extends Quantity<Q>> QuantityAmount<Q> newInstance(
//			Number value, Unit<?> unit) {
//		QuantityAmount<Q> measure = FACTORY.create(value, unit);
//
//		measure._unit = (Unit<Q>) unit;
//
//		return measure;
//	}

	
	public String toString() {
		return  String.valueOf(getValue()) + " " + String.valueOf(getUnit());
	}

	@Override
	public Measurement<Q, Number> add(Measurement<Q, Number> that) {
		// TODO Auto-generated method stub
		return null;
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
	public Measurement<?, Number> divide(Measurement<?, Number> that) {
		Unit<?> unit = getUnit().divide(that.getUnit());
		return of((getValue().doubleValue() / that.getValue()
				.doubleValue()), unit);	}

	@Override
	public Measurement<Q, Number> inverse() {
		@SuppressWarnings({ "rawtypes", "unchecked" })
		final Measurement<Q, Number> m = new BaseMeasurement(getValue(),
				getUnit().inverse()); // TODO keep value the same?
		return m;
	}

	@Override
	public BigDecimal decimalValue(Unit<Q> unit, MathContext ctx)
			throws ArithmeticException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int compareTo(BaseMeasurement<Q> o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
