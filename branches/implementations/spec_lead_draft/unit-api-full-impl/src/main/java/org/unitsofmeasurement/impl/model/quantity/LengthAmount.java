/**
 * Copyright (c) 2005, 2013, Werner Keil and others.
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.impl.model.quantity;

import javax.measure.Unit;
import javax.measure.quantity.Length;

import org.unitsofmeasurement.impl.BaseMeasurement;

/**
 * Represents the extent of something along its greatest
 * dimension or the extent of space between two objects or places.
 * The metric system unit for this quantity is "m" (metre).
 *
 * @author  <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author  <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 1.6, $Date: 2013-12-25 $
 */
public final class LengthAmount extends BaseMeasurement<Length> implements Length {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1088138019909223368L;

	public LengthAmount(Number number, Unit<Length> unit) {
		super(number, unit);
	}
}
