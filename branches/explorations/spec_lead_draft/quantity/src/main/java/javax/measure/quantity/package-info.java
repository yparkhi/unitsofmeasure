/**
 * Unit-API - Units of Measurement API for Java (http://unitsofmeasurement.org)
 * Copyright (c) 2005-2010, Unit-API contributors, JScience and others
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */


/**
 * Provides quantitative properties or attributes of thing such as
 * mass, time, distance, heat, and angular separation.
 * Quantities of different kinds are represented by sub-types of the
 * {@link javax.measure.Quantity} interface.
 *
 * <p>Only quantities defined in the <a href="http://en.wikipedia.org/wiki/International_System_of_Units">International System of Units</a>
 * are provided here. Users can create their own quantity types by extending the
 * {@link javax.measure.Quantity Quantity} interface.</p>
 *
 * <p>This package supports <cite>measurable</cite> quantities, which can be expressed
 * as ({@link java.lang.Number}, {@link javax.measure.Unit}) tuples.
 * Those tuples are not expected to be used directly in numerically intensive code.
 * They are more useful as metadata converted to the application internal representation
 * (for example {@code double} primitive type with the requirement to provide values in metres)
 * before computation begins.</p>
 *
 * <p>Quantities sub-types are also used as parameterized type to characterize
 * generic classes and provide additional compile time check. This technic is
 * used extensively by the {@link javax.measure.Unit} interface,
 * but users can apply the same approach to their own classes. In the example
 * below, {@code Sensor}, {@code MyQuantity} and {@code Vector3D} are user-defined
 * classes:</p>
 *
 * [code]
 *    // A general-purpose Sensor class used for temperature measurements:
 *    Sensor<Temperature> sensor ...;
 *    Temperature temp = sensor.getValue();
 *
 *    // A vector of velocity in a three-dimensional space.
 *    Unit<Velocity> = metrePerSecond = METRE.divide(SECOND);
 *    Vector3D<Velocity> aircraftSpeed = new Vector3D(200.0, 50.0, -0.5, metrePerSecond);
 * [/code]
 *
 * <p>This package holds only the quantities required by the metric system.</p>
 *
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 2.2
 *
 * @since 0.6.0
 */
package javax.measure.quantity;
