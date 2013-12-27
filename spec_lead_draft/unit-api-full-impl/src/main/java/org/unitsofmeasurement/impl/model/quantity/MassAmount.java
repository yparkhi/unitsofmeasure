/**
 * Copyright (c) 2005, 2013, Werner Keil and others.
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.impl.model.quantity;

import javax.measure.Unit;
import javax.measure.quantity.Mass;

import org.unitsofmeasurement.impl.BaseMeasurement;

/**
 * Represents the measure of the quantity of matter that a body or an object contains.
 * The mass of the body is not dependent on gravity and therefore is different from but
 * proportional to its weight.
 * The metric system unit for this quantity is "kg" (kilogram).
 *
 * @author  <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author  <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 1.7, $Date: 2013-12-26 $
 */
public final class MassAmount extends BaseMeasurement<Mass> implements Mass {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3190275944382844647L;

	public MassAmount(Number number, Unit<Mass> unit) {
		super(number, unit);
	}
}
