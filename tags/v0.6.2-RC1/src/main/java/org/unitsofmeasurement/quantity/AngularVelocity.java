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
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @version 1.1
 *
 * @see Angle
 * @see Time
 * @see AngularAcceleration
 * @see Velocity
 *
 * @deprecated Renamed {@link AngularSpeed}, because speed is a scalar value while velocity is a vector.
 */
public interface AngularVelocity extends Quantity<AngularVelocity> {
}
