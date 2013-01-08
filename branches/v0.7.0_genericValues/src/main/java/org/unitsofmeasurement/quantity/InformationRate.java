/**
 * Unit-API - Units of Measurement API for Java (http://unitsofmeasurement.org)
 * Copyright (c) 2005-2012, Unit-API contributors, JScience and others
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.quantity;

/**
 * This interface represents the speed of data-transmission. The system unit for
 * this NumericQuantity is "bit/s" (bit per second).
 * 
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 1.3, $Date$
 * @param <V>
 *            The value of the quantity.
 * @see <a href="http://en.wikipedia.org/wiki/Information_rate"> Wikipedia:
 *      Information Rate</a>
 * 
 */
public interface InformationRate<V> extends Quantity<InformationRate<V>, V> {
}