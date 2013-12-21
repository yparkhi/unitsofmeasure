/*
 * JScience - Java(TM) Tools and Libraries for the Advancement of Sciences.
 * Copyright (C) 2010-2013 - JScience (http://jscience.org/)
 * All rights reserved.
 *
 * Permission to use, copy, modify, and distribute this software is
 * freely granted, provided that this notice is preserved.
 */
package org.jscience.physics.quantity;

import org.unitsofmeasurement.quantity.Quantity;
import org.unitsofmeasurement.unit.Unit;

/**
 * <p> This interface represents the measurable, countable, or comparable 
 *     property or aspect of a thing.</p>
 *     
 * <p> Implementing instances are typically the result of a measurement:[code]
 *         Measurement<Mass> weight = BaseAmount.valueOf(180.0, POUND);
 *     [/code]
 *     They can also be created from custom classes:[code]
 *     class Delay implements Measurement<Duration> {
 *          private long nanoSeconds; // Implicit internal unit.
 *          public double doubleValue(Unit<Velocity> unit) { ... }
 *          public long longValue(Unit<Velocity> unit) { ... }
 *     }
 *     Thread.wait(new Delay(24, HOUR)); // Assuming Thread.wait(Measurement<Duration>) method.
 *     [/code]</p>
 *     
 * <p> Although Measurement instances are for the most part scalar quantities; 
 *     more complex implementations (e.g. vectors, data set) are allowed as 
 *     long as an aggregate magnitude can be determined. For example:[code]
 *     class Velocity3D implements Measurement<Velocity> {
 *          private double x, y, z; // Meter per seconds.
 *          public double doubleValue(Unit<Velocity> unit) { ... } // Returns vector norm.
 *          ... 
 *     }
 *     class Sensor<Q extends Quantity> extends QuantityAmount<double[], Q> {
 *          public doubleValue(Unit<Q> unit) { ... } // Returns median value. 
 *          ...
 *     } [/code]</p>
 * 
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:uomo@catmedia.us">Werner Keil</a>
 * @version 5.4.1, $Date: 2013-11-18 02:03:44 +0200 $
 * @param <Q>
 */
public interface Measurement<Q extends Quantity<Q>> extends Quantity<Q> {    
        
    /**
     * Returns the sum of this amount with the one specified.
     *
     * @param  that the amount to be added.
     * @return <code>this + that</code>.
     */
    Measurement<Q> add(Measurement<Q> that);
    
    /**
     * Returns the difference between this amount and the one specified.
     *
     * @param  that the number to be subtracted.
     * @return <code>this - that</code>.
     */
    Measurement<Q> substract(Measurement<Q> that);
    
    /**
     * Returns the product of this amount with the one specified.
     *
     * @param  that the amount multiplier.
     * @return <code>this · that</code>.
     */
    Measurement<?> multiply(Measurement<?> that);
    
    /**
     * Returns the product of this amount with the number specified.
     *
     * @param  that the number multiplier.
     * @return <code>this · that</code>.
     */
    Measurement<?> multiply(Number that);
    
    /**
     * Returns this amount divided by the one specified.
     *
     * @param  that the amount divisor.
     * @return <code>this / that</code>.
     */
    Measurement<?> divide(Measurement<?> that);
    
    Measurement<? extends Measurement<Q>> inverse();
    
    /**
     * Returns this measurement converted into another unit.
     * 
     * @param unit
     * @return the converted result.
     */
    Measurement<Q> to(Unit<Q> unit);
    
    /**
     * Returns the value of this quantity as <code>double</code> stated
     * in the specified unit. This method is recommended over <code>
     * q.getUnit().getConverterTo(unit).convert(q.getValue()).doubleValue()</code>
     *
     * @param unit the unit in which the returned value is stated.
     * @return the value of this quantity when stated in the specified unit.
     */
    public double doubleValue(Unit<Q> unit);
    
    /**
     * Returns the value of this quantity as <code>long</code> stated
     * in the specified unit. This method is recommended over <code>
     * q.getUnit().getConverterTo(unit).convert(q.getValue()).longValue()</code>
     *
     * @param unit the unit in which the returned value is stated.
     * @return the value of this quantity when stated in the specified unit.
     */
    public long longValue(Unit<Q> unit);
}
