/*
 * JScience - Java(TM) Tools and Libraries for the Advancement of Sciences.
 * Copyright (C) 2010-2013 - JScience (http://jscience.org/)
 * All rights reserved.
 *
 * Permission to use, copy, modify, and distribute this software is
 * freely granted, provided that this notice is preserved.
 */
package org.jscience.physics.quantity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.text.ParsePosition;

import org.unitsofmeasurement.quantity.Quantity;
import org.unitsofmeasurement.unit.Unit;

/**
 * <p> This class represents the immutable result of a scalar measurement stated
 *     in a known unit.</p>
 * 
 * <p> To avoid any lost of precision, known exact measure (e.g. physical 
 *     constants) should not be created from <code>double</code> constants but
 *     from their decimal representation.[code]
 *         public static final Measure<Velocity> C = Measure.valueOf("299792458 m/s").asType(Velocity.class);
 *         // Speed of Light (exact).
 *    [/code]</p>
 * 
 * <p> Measures can be converted to different units, the conversion precision is
 *     determined by the specified {@link MathContext}.[code]
 *         Measure<Velocity> milesPerHour = C.to(MILES_PER_HOUR, MathContext.DECIMAL128); // Use BigDecimal implementation.
 *         System.out.println(milesPerHour);
 * 
 *         > 670616629.3843951324266284896206156 [mi_i]/h
 *     [/code]
 *     If no precision is specified <code>double</code> precision is assumed.[code]
 *         Measure<Velocity> milesPerHour = C.to(MILES_PER_HOUR); // Use double implementation (fast).
 *         System.out.println(milesPerHour);
 * 
 *         > 670616629.3843951 [mi_i]/h
 *     [/code]</p>
 * 
 * <p> Applications may sub-class {@link AbstractMeasurement} for particular measurements
 *     types.[code]
 *         // Measurement of type Mass based on <code>double</code> primitive types.
 *         public class Weight extends Measure<Mass> { 
 *             private final double _kilograms; // Internal SI representation. 
 *             private Weight(double kilograms) { _kilograms = kilograms; }
 *             public static Weight valueOf(double value, Unit<Mass> unit) {
 *                 return new Weight(unit.getConverterTo(SI.KILOGRAM).convert(value));
 *             } 
 *             public Unit<Mass> getUnit() { return SI.KILOGRAM; } 
 *             public Double getValue() { return _kilograms; } 
 *             ...
 *         }
 * 
 *         // Complex numbers measurements.
 *         public class ComplexMeasure<Q extends Quantity> extends Measure<Q> {
 *             public Complex getValue() { ... } // Assuming Complex is a Number.
 *             ... 
 *         }
 * 
 *         // Specializations of complex numbers measurements.
 *         public class Current extends ComplexMeasure<ElectricCurrent> {...} 
 *         public class Tension extends ComplexMeasure<ElectricPotential> {...}
 *         [/code]</p>
 * 
 * <p> All instances of this class shall be immutable.</p>
 * 
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author  <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 1.0.1 ($Revision$), $Date$
 */
public abstract class AbstractMeasurement<Q extends Quantity<Q>> implements Measurement<Q>,
        Serializable {

	private Number value;
	
	private final Unit<Q> unit;
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -4993173119977931016L;

	/**
     * Default constructor.
     */
//    protected AbstractMeasurement() {
//    }
    
	/**
     * constructor.
     */
    protected AbstractMeasurement(Number number, Unit<Q> unit) {
    	this.value = number;
    	this.unit = unit;
    }
    
    
	/**
     * constructor.
     */
    protected AbstractMeasurement(Unit<Q> unit) {
    	this.unit = unit;
    }

    /**
     * Returns the measurement numeric value.
     *
     * @return the measurement value.
     */
    public Number getValue() {
    	return value;
    }

    /**
     * Returns the measurement unit.
     *
     * @return the measurement unit.
     */
    public Unit<Q> getUnit() {
    	return unit;
    }
    
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Measurement#unit()
	 */
	@Override
	public Unit<Q> unit() {
		return getUnit();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Measurement#value()
	 */
	@Override
	public Number value() {
		return getValue();
	}

    /**
     * Convenient method equivalent to {@link #to(javax.measure.unit.Unit)
     * to(this.getUnit().toSI())}.
     *
     * @return this measure or a new measure equivalent to this measure but
     *         stated in SI units.
     * @throws ArithmeticException if the result is inexact and the quotient
     *         has a non-terminating decimal expansion.
     */
    public AbstractMeasurement<Q> toSI() {
        return to(this.getUnit().getSystemUnit());
    }

    /**
     * Returns this measure after conversion to specified unit. The default
     * implementation returns
     * <code>Measure.valueOf(doubleValue(unit), unit)</code>. If this measure is
     * already stated in the specified unit, then this measure is returned and
     * no conversion is performed.
     *
     * @param unit the unit in which the returned measure is stated.
     * @return this measure or a new measure equivalent to this measure but
     *         stated in the specified unit.
     * @throws ArithmeticException if the result is inexact and the quotient has
     *         a non-terminating decimal expansion.
     */
    public AbstractMeasurement<Q> to(Unit<Q> unit) {
        if (unit.equals(this.getUnit())) {
            return this;
        }
        return AbstractMeasurement.valueOf(doubleValue(unit), unit);
    }

    /**
     * Returns this measure after conversion to specified unit. The default
     * implementation returns
     * <code>Measure.valueOf(decimalValue(unit, ctx), unit)</code>. If this
     * measure is already stated in the specified unit, then this measure is
     * returned and no conversion is performed.
     *
     * @param unit the unit in which the returned measure is stated.
     * @param ctx the math context to use for conversion.
     * @return this measure or a new measure equivalent to this measure but
     *         stated in the specified unit.
     * @throws ArithmeticException if the result is inexact but the rounding
     *         mode is <code>UNNECESSARY</code> or
     *         <code>mathContext.precision == 0</code> and the quotient has
     *         a non-terminating decimal expansion.
     */
    public AbstractMeasurement<Q> to(Unit<Q> unit, MathContext ctx) {
        if (unit.equals(this.getUnit())) {
            return this;
        }
        return AbstractMeasurement.valueOf(decimalValue(unit, ctx), unit);
    }

    /**
     * Compares this measure to the specified IMeasure quantity. The default
     * implementation compares the {@link Measurement#doubleValue(Unit)} of both
     * this measure and the specified IMeasure stated in the same unit (this
     * measure's {@link #getUnit() unit}).
     *
     * @return a negative integer, zero, or a positive integer as this measure
     *         is less than, equal to, or greater than the specified IMeasure
     *         quantity.
     * @return <code>Double.compare(this.doubleValue(getUnit()),
     *         that.doubleValue(getUnit()))</code>
     */
    public int compareTo(Measurement<Q> that) {
        Unit<Q> unit = getUnit();
        return Double.compare(doubleValue(unit), that.doubleValue(unit));
    }

    /**
     * Compares this measure against the specified object for <b>strict</b>
     * equality (same unit and same amount).
     *
     * <p> Similarly to the {@link BigDecimal#equals} method which consider 2.0
     *     and 2.00 as different objects because of different internal scales,
     *     measurements such as <code>Measure.valueOf(3.0, KILOGRAM)</code>
     *     <code>Measure.valueOf(3, KILOGRAM)</code> and
     *     <code>Measure.valueOf("3 kg")</code> might not be considered equals
     *     because of possible differences in their implementations.</p>
     *
     * <p> To compare measures stated using different units or using different
     *     amount implementations the {@link #compareTo compareTo} or
     *     {@link #equals(javax.measure.Measurement, double, javax.measure.unit.Unit)
     *      equals(IMeasure, epsilon, epsilonUnit)} methods should be used.</p>
     *
     * @param obj the object to compare with.
     * @return <code>this.getUnit.equals(obj.getUnit())
     *         && this.getValue().equals(obj.getValue())</code>
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof AbstractMeasurement<?>)) {
            return false;
        }
        AbstractMeasurement<?> that = (AbstractMeasurement<?>) obj;
        return this.getUnit().equals(that.getUnit()) && this.getValue().equals(that.getValue());
    }

    /**
     * Compares this measure and the specified IMeasure to the given accuracy.
     * Measurements are considered approximately equals if their absolute
     * differences when stated in the same specified unit is less than the
     * specified epsilon.
     *
     * @param that the IMeasure to compare with.
     * @param epsilon the absolute error stated in epsilonUnit.
     * @param epsilonUnit the epsilon unit.
     * @return <code>abs(this.doubleValue(epsilonUnit) - that.doubleValue(epsilonUnit)) &lt;= epsilon</code>
     */
    public boolean equals(Measurement<Q> that, double epsilon, Unit<Q> epsilonUnit) {
        return Math.abs(this.doubleValue(epsilonUnit) - that.doubleValue(epsilonUnit)) <= epsilon;
    }

    /**
     * Returns the hash code for this measure.
     *
     * @return the hash code value.
     */
    @Override
    public int hashCode() {
        return getUnit().hashCode() + getValue().hashCode();
    }

    /**
     * Returns the <code>String</code> representation of this measure. The
     * string produced for a given measure is always the same; it is not
     * affected by locale. This means that it can be used as a canonical string
     * representation for exchanging measure, or as a key for a Hashtable, etc.
     * Locale-sensitive measure formatting and parsing is handled by the
     * {@link MeasureFormat} class and its subclasses.
     *
     * @return <code>UnitFormat.getInternational().format(this)</code>
     */
    @Override
    public final String toString() {
        return MeasureFormat.getStandard().format(this);
    }

    protected abstract  BigDecimal decimalValue(Unit<Q> unit, MathContext ctx)
            throws ArithmeticException;
    
    // Implements IMeasure
    public final int intValue(Unit<Q> unit) throws ArithmeticException {
        long longValue = longValue(unit);
        if ((longValue < Integer.MIN_VALUE) || (longValue > Integer.MAX_VALUE)) {
            throw new ArithmeticException("Cannot convert " + longValue + " to int (overflow)");
        }
        return (int) longValue;
    }
//
    // Implements IMeasure
    public long longValue(Unit<Q> unit) throws ArithmeticException {
        double result = doubleValue(unit);
        if ((result < Long.MIN_VALUE) || (result > Long.MAX_VALUE)) {
            throw new ArithmeticException("Overflow (" + result + ")");
        }
        return (long) result;
    }

    // Implements IMeasure
    public final float floatValue(Unit<Q> unit) {
        return (float) doubleValue(unit);
    }

    /**
     * Casts this measure to a parameterized unit of specified nature or throw a
     * <code>ClassCastException</code> if the dimension of the specified
     * quantity and this measure unit's dimension do not match. For
     * example:[code]
     *     Measure<Length> length = Measure.valueOf("2 km").asType(Length.class);
     * [/code]
     *
     * @param type the quantity class identifying the nature of the measure.
     * @return this measure parameterized with the specified type.
     * @throws ClassCastException if the dimension of this unit is different
     *         from the specified quantity dimension.
     * @throws UnsupportedOperationException
     *             if the specified quantity class does not have a public static
     *             field named "UNIT" holding the SI unit for the quantity.
     * @see Unit#asType(Class)
     */
    @SuppressWarnings("unchecked")
    public final <T extends Quantity<T>> AbstractMeasurement<T> asType(Class<T> type)
            throws ClassCastException {
        this.getUnit().asType(type); // Raises ClassCastException is dimension
        // mismatches.
        return (AbstractMeasurement<T>) this;
    }

    /**
     * Returns the
     * {@link #valueOf(java.math.BigDecimal, javax.measure.unit.Unit) decimal}
     * measure of unknown type corresponding to the specified representation.
     * This method can be used to parse dimensionless quantities.[code]
     *     Measure<Dimensionless> proportion = Measure.valueOf("0.234").asType(Dimensionless.class);
     * [/code]
     *
     * <p> Note: This method handles only
     * {@link javax.measure.unit.UnitFormat#getStandard standard} unit format
     * (<a href="http://unitsofmeasure.org/">UCUM</a> based). Locale-sensitive
     * measure formatting and parsing are handled by the {@link MeasureFormat}
     * class and its subclasses.</p>
     *
     * @param csq the decimal value and its unit (if any) separated by space(s).
     * @return <code>MeasureFormat.getStandard().parse(csq, new ParsePosition(0))</code>
     */
    public static AbstractMeasurement<?> valueOf(CharSequence csq) {
        return MeasureFormat.getStandard().parse(csq, new ParsePosition(0));
    }

    /**
     * Returns the scalar measure for the specified <code>int</code> stated in
     * the specified unit.
     *
     * @param intValue the measurement value.
     * @param unit the measurement unit.
     * @return the corresponding <code>int</code> measure.
     */
    public static <Q extends Quantity<Q>> AbstractMeasurement<Q> valueOf(int intValue,
            Unit<Q> unit) {
        return new IntegerMeasure<Q>(intValue, unit);
    }

    private static final class IntegerMeasure<T extends Quantity<T>> extends AbstractMeasurement<T> {

        /**
		 * 
		 */
		private static final long serialVersionUID = 5355395476874521709L;
		int _value;

        public IntegerMeasure(int value, Unit<T> unit) {
        	super(unit);
        	_value = value;
        }

        @Override
        public Integer getValue() {
            return _value;
        }

        // Implements IMeasure
        public double doubleValue(Unit<T> unit) {
            return (super.unit.equals(unit)) ? _value : super.unit.getConverterTo(unit).convert(_value);
        }

        // Implements IMeasure
        public BigDecimal decimalValue(Unit<T> unit, MathContext ctx)
                throws ArithmeticException {
            BigDecimal decimal = BigDecimal.valueOf(_value);
            return (super.unit.equals(unit)) ? decimal : super.unit.getConverterTo(unit).convert(decimal, ctx);
        }

		@Override
		public Measurement<T> add(Measurement<T> that) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Measurement<T> substract(Measurement<T> that) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Measurement<?> multiply(Measurement<?> that) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Measurement<?> multiply(Number that) {
			return valueOf(_value * that.intValue(), super.unit);
		}

		@Override
		public Measurement<?> divide(Measurement<?> that) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Measurement<? extends Measurement<T>> inverse() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long longValue(Unit<T> unit) {
	        double result = doubleValue(unit);
	        if ((result < Long.MIN_VALUE) || (result > Long.MAX_VALUE)) {
	            throw new ArithmeticException("Overflow (" + result + ")");
	        }
	        return (long) result;
		}

    }
    
    /**
     * Returns the scalar measure for the specified <code>float</code> stated in
     * the specified unit.
     *
     * @param floatValue the measurement value.
     * @param unit the measurement unit.
     * @return the corresponding <code>float</code> measure.
     */
    public static <Q extends Quantity<Q>> AbstractMeasurement<Q> valueOf(float floatValue,
            Unit<Q> unit) {
        return new FloatMeasure<Q>(floatValue, unit);
    }

    private static final class FloatMeasure<T extends Quantity<T>> extends AbstractMeasurement<T> {

        float _value;

        public FloatMeasure(float value, Unit<T> unit) {
        	super(unit);
            _value = value;
        }

        @Override
        public Float getValue() {
            return _value;
        }

        // Implements Measurable
        public double doubleValue(Unit<T> unit) {
            return (super.unit.equals(unit)) ? _value : super.unit.getConverterTo(unit).convert(_value);
        }

        // Implements Measurable
        public BigDecimal decimalValue(Unit<T> unit, MathContext ctx)
                throws ArithmeticException {
            BigDecimal decimal = BigDecimal.valueOf(_value);
            return (super.unit.equals(unit)) ? decimal : super.unit.getConverterTo(unit).convert(decimal, ctx);
        }
        private static final long serialVersionUID = 1L;

		@Override
		public Measurement<T> add(Measurement<T> that) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Measurement<T> substract(Measurement<T> that) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Measurement<?> multiply(Measurement<?> that) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Measurement<?> multiply(Number that) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Measurement<?> divide(Measurement<?> that) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Measurement<? extends Measurement<T>> inverse() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long longValue(Unit<T> unit) {
	        double result = doubleValue(unit);
	        if ((result < Long.MIN_VALUE) || (result > Long.MAX_VALUE)) {
	            throw new ArithmeticException("Overflow (" + result + ")");
	        }
	        return (long) result;
		}
    }

    /**
     * Returns the scalar measure for the specified <code>double</code> stated
     * in the specified unit.
     *
     * @param doubleValue the measurement value.
     * @param unit the measurement unit.
     * @return the corresponding <code>double</code> measure.
     */
    public static <Q extends Quantity<Q>> AbstractMeasurement<Q> valueOf(double doubleValue,
            Unit<Q> unit) {
        return new DoubleMeasure<Q>(doubleValue, unit);
    }

    private static final class DoubleMeasure<T extends Quantity<T>> extends AbstractMeasurement<T> {

        double _value;

        public DoubleMeasure(double value, Unit<T> unit) {
        	super(unit);
            _value = value;
        }

        @Override
        public Double getValue() {
            return _value;
        }


        @Override
        public double doubleValue(Unit<T> unit) {
            return (super.unit.equals(unit)) ? _value : super.unit.getConverterTo(unit).convert(_value);
        }

        @Override
        public BigDecimal decimalValue(Unit<T> unit, MathContext ctx)
                throws ArithmeticException {
            BigDecimal decimal = BigDecimal.valueOf(_value);
            return (super.unit.equals(unit)) ? decimal : super.unit.getConverterTo(unit).convert(decimal, ctx);
        }
        private static final long serialVersionUID = 1L;

		@Override
		public Measurement<T> add(Measurement<T> that) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Measurement<T> substract(Measurement<T> that) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Measurement<?> multiply(Measurement<?> that) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Measurement<?> multiply(Number that) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Measurement<?> divide(Measurement<?> that) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Measurement<? extends Measurement<T>> inverse() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long longValue(Unit<T> unit) {
	        double result = doubleValue(unit);
	        if ((result < Long.MIN_VALUE) || (result > Long.MAX_VALUE)) {
	            throw new ArithmeticException("Overflow (" + result + ")");
	        }
	        return (long) result;
		}

		@Override
		public Number value() {
			return getValue();
		}
    }

    /**
     * Returns the scalar measure for the specified <code>BigDecimal</code>
     * stated in the specified unit.
     *
     * @param decimalValue the measurement value.
     * @param unit the measurement unit.
     * @return the corresponding <code>BigDecimal</code> measure.
     */
    public static <Q extends Quantity<Q>> AbstractMeasurement<Q> valueOf(
            BigDecimal decimalValue, Unit<Q> unit) {
        return new DecimalMeasure<Q>(decimalValue, unit);
    }

    private static final class DecimalMeasure<T extends Quantity<T>> extends AbstractMeasurement<T> {

        /**
		 * 
		 */
		private static final long serialVersionUID = 6504081836032983882L;
		BigDecimal _value;

        public DecimalMeasure(BigDecimal value, Unit<T> unit) {
        	super(value, unit);
        }

        @Override
        public BigDecimal getValue() {
            return _value;
        }

        // Implements Measurable
        public double doubleValue(Unit<T> unit) {
            return (unit.equals(unit)) ? _value.doubleValue() : unit.getConverterTo(unit).convert(_value.doubleValue());
        }

        // Implements Measurable
        public BigDecimal decimalValue(Unit<T> unit, MathContext ctx)
                throws ArithmeticException {
            return (super.unit.equals(unit)) ? _value : unit.getConverterTo(unit).convert(_value, ctx);
        }

		@Override
		public Measurement<T> add(Measurement<T> that) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Measurement<T> substract(Measurement<T> that) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Measurement<?> multiply(Measurement<?> that) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Measurement<?> multiply(Number that) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Measurement<?> divide(Measurement<?> that) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Measurement<? extends Measurement<T>> inverse() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long longValue(Unit<T> unit) {
	        double result = doubleValue(unit);
	        if ((result < Long.MIN_VALUE) || (result > Long.MAX_VALUE)) {
	            throw new ArithmeticException("Overflow (" + result + ")");
	        }
	        return (long) result;
		}
    }   

}
