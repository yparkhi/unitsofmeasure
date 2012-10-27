/**
 * Unit-API - Units of Measurement API for Java (http://unitsofmeasurement.org)
 * Copyright (c) 2005-2012, Unit-API contributors, JScience and others
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.quantity;

/**
 * Represents the amount of energy deposited per unit of mass. The system unit
 * for this NumericQuantity is "Gy" (Gray).
 * 
 * @param <V>
 *            The value of the quantity.
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 1.1 ($Revision$), $Date$
 * @see <a
 *      href="http://en.wikipedia.org/wiki/International_Commission_on_Radiation_Units_and_Measurements">
 *      Wikipedia: International Commission on Radiation Units and
 *      Measurements</a>
 */
public interface RadiationDoseAbsorbed<V> extends
		Quantity<RadiationDoseAbsorbed<V>, V> {

}
