/**
 * Unit-API - Units of Measurement API for Java (http://unitsofmeasurement.org)
 * Copyright (c) 2005-2012, Unit-API contributors, JScience and others
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.quantity;

/**
 * This interface represents an energy multiplied by a duration (quantity
 * associated to the <a
 * href="http://en.wikipedia.org/wiki/Planck%27s_constant">Planck Constant</a>).
 * The system unit for this quantity is "J.s" (joules second).
 * 
 * @param <V>
 *            The value of the quantity.
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 1.2 ($Revision$), $Date: 2012-04-30 01:07:51 +0200 (Mo, 30 Apr 2012)
 *          $
 * @see <a href="http://en.wikipedia.org/wiki/Action_(physics)">Wikipedia's
 *      Action</a>
 * 
 */
public interface Action<V> extends Quantity<Action<V>, V> {

}
