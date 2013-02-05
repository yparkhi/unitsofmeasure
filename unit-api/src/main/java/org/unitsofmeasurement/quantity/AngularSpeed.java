/**
 * Unit-API - Units of Measurement API for Java (http://unitsofmeasurement.org)
 * Copyright (c) 2005-2010, Unit-API contributors, JScience and others
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.quantity;


/**
 * Rate of change of angular displacement with respect to time.
 * The system unit for this quantity is "rad/s" (radian per second).
 *
 * <p><cite>Angular speed</cite> is a scalar value, while <cite>angular velocity</cite> is a
 * pseudo-vector. The angular speed is the magnitude of the angular velocity pseudo-vector.</p>
 *
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @version 1.1
 *
 * @see Angle
 * @see Time
 * @see AngularAcceleration
 * @see Velocity
 * @see <a href="http://en.wikipedia.org/wiki/Speed">Wikipedia: Angular Speed</a>
 */
public interface AngularSpeed extends Quantity<AngularSpeed> {
}
