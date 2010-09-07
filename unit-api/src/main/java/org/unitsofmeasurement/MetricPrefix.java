/**
 * Unit-API - Units of Measurement API for Java (http://unitsofmeasurement.org)
 * Copyright (c) 2005-2010, Unit-API contributors, JScience and others
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement;

import org.unitsofmeasurement.quantity.Quantity;

/**
 * <p>
 * This class provides support for the 20 SI prefixes used in the metric system
 * (decimal multiples and submultiples of SI units). For example:
 * 
 * <pre>
 * <code>
 *     import static my.units.impl.SI.*;       // Static import.
 *     import static org.unitsofmeasurement.MetricPrefix.*; // Static import.
 *     import org.unitsofmeasurement.Unit;   
 *     import org.unitsofmeasurement.quantity.*;
 *     ...
 *     Unit<Pressure> HECTOPASCAL = HECTO(PASCAL);
 *     Unit<Length> KILOMETRE = KILO(METRE);
 * </pre>
 * 
 * </code>
 * </p>
 * 
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @see <a
 *      href="http://en.wikipedia.org/wiki/International_System_of_Units">Wikipedia:
 *      International System of Units</a>
 * @version 1.0.2 ($Revision$), $Date$
 */
public final class MetricPrefix {

    private MetricPrefix() {
	// Utility class no visible constructor.
    }

    /**
     * Returns the specified unit multiplied by the factor
     * <code>10<sup>24</sup></code>
     * 
     * @param <Q>
     *            The type of the quantity measured by the unit.
     * @param unit
     *            any unit.
     * @return <code>unit.multiply(1e24)</code>.
     */
    public static <Q extends Quantity<Q>> Unit<Q> YOTTA(Unit<Q> unit) {
	return unit.multiply(1E24);
    }

    /**
     * Returns the specified unit multiplied by the factor
     * <code>10<sup>21</sup></code>
     * 
     * @param <Q>
     *            The type of the quantity measured by the unit.
     * @param unit
     *            any unit.
     * @return <code>unit.multiply(1e21)</code>.
     */
    public static <Q extends Quantity<Q>> Unit<Q> ZETTA(Unit<Q> unit) {
	return unit.multiply(1E21);
    }

    /**
     * Returns the specified unit multiplied by the factor
     * <code>10<sup>18</sup></code>
     * 
     * @param <Q>
     *            The type of the quantity measured by the unit.
     * @param unit
     *            any unit.
     * @return <code>unit.multiply(1e18)</code>.
     */
    public static <Q extends Quantity<Q>> Unit<Q> EXA(Unit<Q> unit) {
	return unit.multiply(1E18);
    }

    /**
     * Returns the specified unit multiplied by the factor
     * <code>10<sup>15</sup></code>
     * 
     * @param <Q>
     *            The type of the quantity measured by the unit.
     * @param unit
     *            any unit.
     * @return <code>unit.multiply(1e15)</code>.
     */
    public static <Q extends Quantity<Q>> Unit<Q> PETA(Unit<Q> unit) {
	return unit.multiply(1E15);
    }

    /**
     * Returns the specified unit multiplied by the factor
     * <code>10<sup>12</sup></code>
     * 
     * @param <Q>
     *            The type of the quantity measured by the unit.
     * @param unit
     *            any unit.
     * @return <code>unit.multiply(1e12)</code>.
     */
    public static <Q extends Quantity<Q>> Unit<Q> TERA(Unit<Q> unit) {
	return unit.multiply(1E12);
    }

    /**
     * Returns the specified unit multiplied by the factor
     * <code>10<sup>9</sup></code>
     * 
     * @param <Q>
     *            The type of the quantity measured by the unit.
     * @param unit
     *            any unit.
     * @return <code>unit.multiply(1e9)</code>.
     */
    public static <Q extends Quantity<Q>> Unit<Q> GIGA(Unit<Q> unit) {
	return unit.multiply(1E9);
    }

    /**
     * Returns the specified unit multiplied by the factor
     * <code>10<sup>6</sup></code>
     * 
     * @param <Q>
     *            The type of the quantity measured by the unit.
     * @param unit
     *            any unit.
     * @return <code>unit.multiply(1e6)</code>.
     */
    public static <Q extends Quantity<Q>> Unit<Q> MEGA(Unit<Q> unit) {
	return unit.multiply(1E6);
    }

    /**
     * Returns the specified unit multiplied by the factor
     * <code>10<sup>3</sup></code>
     * 
     * @param <Q>
     *            The type of the quantity measured by the unit.
     * @param unit
     *            any unit.
     * @return <code>unit.multiply(1e3)</code>.
     */
    public static <Q extends Quantity<Q>> Unit<Q> KILO(Unit<Q> unit) {
	return unit.multiply(1E3);
    }

    /**
     * Returns the specified unit multiplied by the factor
     * <code>10<sup>2</sup></code>
     * 
     * @param <Q>
     *            The type of the quantity measured by the unit.
     * @param unit
     *            any unit.
     * @return <code>unit.multiply(1e2)</code>.
     */
    public static <Q extends Quantity<Q>> Unit<Q> HECTO(Unit<Q> unit) {
	return unit.multiply(1E2);
    }

    /**
     * Returns the specified unit multiplied by the factor
     * <code>10<sup>1</sup></code>
     * 
     * @param <Q>
     *            The type of the quantity measured by the unit.
     * @param unit
     *            any unit.
     * @return <code>unit.multiply(1e1)</code>.
     */
    public static <Q extends Quantity<Q>> Unit<Q> DEKA(Unit<Q> unit) {
	return unit.multiply(1E1);
    }

    /**
     * Returns the specified unit multiplied by the factor
     * <code>10<sup>-1</sup></code>
     * 
     * @param <Q>
     *            The type of the quantity measured by the unit.
     * @param unit
     *            any unit.
     * @return <code>unit.divide(1e1)</code>.
     */
    public static <Q extends Quantity<Q>> Unit<Q> DECI(Unit<Q> unit) {
	return unit.divide(1E1);
    }

    /**
     * Returns the specified unit multiplied by the factor
     * <code>10<sup>-2</sup></code>
     * 
     * @param <Q>
     *            The type of the quantity measured by the unit.
     * @param unit
     *            any unit.
     * @return <code>unit.divide(1e2)</code>.
     */
    public static <Q extends Quantity<Q>> Unit<Q> CENTI(Unit<Q> unit) {
	return unit.divide(1E2);
    }

    /**
     * Returns the specified unit multiplied by the factor
     * <code>10<sup>-3</sup></code>
     * 
     * @param <Q>
     *            The type of the quantity measured by the unit.
     * @param unit
     *            any unit.
     * @return <code>unit.divide(1e3)</code>.
     */
    public static <Q extends Quantity<Q>> Unit<Q> MILLI(Unit<Q> unit) {
	return unit.divide(1E3);
    }

    /**
     * Returns the specified unit multiplied by the factor
     * <code>10<sup>-6</sup></code>
     * 
     * @param <Q>
     *            The type of the quantity measured by the unit.
     * @param unit
     *            any unit.
     * @return <code>unit.divide(1e6)</code>.
     */
    public static <Q extends Quantity<Q>> Unit<Q> MICRO(Unit<Q> unit) {
	return unit.divide(1E6);
    }

    /**
     * Returns the specified unit multiplied by the factor
     * <code>10<sup>-9</sup></code>
     * 
     * @param <Q>
     *            The type of the quantity measured by the unit.
     * @param unit
     *            any unit.
     * @return <code>unit.divide(1e9)</code>.
     */
    public static <Q extends Quantity<Q>> Unit<Q> NANO(Unit<Q> unit) {
	return unit.divide(1E9);
    }

    /**
     * Returns the specified unit multiplied by the factor
     * <code>10<sup>-12</sup></code>
     * 
     * @param <Q>
     *            The type of the quantity measured by the unit.
     * @param unit
     *            any unit.
     * @return <code>unit.divide(1e12)</code>.
     */
    public static <Q extends Quantity<Q>> Unit<Q> PICO(Unit<Q> unit) {
	return unit.divide(1E12);
    }

    /**
     * Returns the specified unit multiplied by the factor
     * <code>10<sup>-15</sup></code>
     * 
     * @param <Q>
     *            The type of the quantity measured by the unit.
     * @param unit
     *            any unit.
     * @return <code>unit.divide(1e15)</code>.
     */
    public static <Q extends Quantity<Q>> Unit<Q> FEMTO(Unit<Q> unit) {
	return unit.divide(1E15);
    }

    /**
     * Returns the specified unit multiplied by the factor
     * <code>10<sup>-18</sup></code>
     * 
     * @param <Q>
     *            The type of the quantity measured by the unit.
     * @param unit
     *            any unit.
     * @return <code>unit.divide(1e18)</code>.
     */
    public static <Q extends Quantity<Q>> Unit<Q> ATTO(Unit<Q> unit) {
	return unit.divide(1E18);
    }

    /**
     * Returns the specified unit multiplied by the factor
     * <code>10<sup>-21</sup></code>
     * 
     * @param <Q>
     *            The type of the quantity measured by the unit.
     * @param unit
     *            any unit.
     * @return <code>unit.divide(1e21)</code>.
     */
    public static <Q extends Quantity<Q>> Unit<Q> ZEPTO(Unit<Q> unit) {
	return unit.divide(1E21);
    }

    /**
     * Returns the specified unit multiplied by the factor
     * <code>10<sup>-24</sup></code>
     * 
     * @param <Q>
     *            The type of the quantity measured by the unit.
     * @param unit
     *            any unit.
     * @return <code>unit.divide(1e24)</code>.
     */
    public static <Q extends Quantity<Q>> Unit<Q> YOCTO(Unit<Q> unit) {
	return unit.divide(1E24);
    }

}
