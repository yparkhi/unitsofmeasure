/**
 * Copyright (c) 2005, 2013, Werner Keil and others.
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.impl.model.quantity;

import javax.measure.Unit;
import javax.measure.quantity.Acceleration;
import org.unitsofmeasurement.impl.BaseMeasurement;

/**
 * Represents the rate of change of velocity with respect to time.
 * The metric system unit for this quantity is "m/s²" (metre per square second).
 *
 * @author  <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author  <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 1.6, $Date: 2013-12-26 $
 */
public final class AccelerationAmount extends BaseMeasurement<Acceleration> implements Acceleration {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3979825836742796484L;

	public AccelerationAmount(Number number, Unit<Acceleration> unit) {
		super(number, unit);
	}
}
