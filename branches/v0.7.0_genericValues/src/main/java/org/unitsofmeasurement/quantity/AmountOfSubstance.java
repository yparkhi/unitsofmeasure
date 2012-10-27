/**
 * Unit-API - Units of Measurement API for Java (http://unitsofmeasurement.org)
 * Copyright (c) 2005-2012, Unit-API contributors, JScience and others
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.quantity;

/**
 * Represents the number of elementary entities (molecules, for example) of a
 * substance. The metric system unit for this NumericQuantity is "mol" (mole).
 * 
 * @param <V>
 *            The value of the quantity.
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 1.1 ($Revision$), $Date$
 */
public interface AmountOfSubstance<V> extends Quantity<AmountOfSubstance<V>, V> {

}
