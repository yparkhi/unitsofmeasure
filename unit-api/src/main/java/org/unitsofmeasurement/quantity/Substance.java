/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2005-2010, Unit-API contributors, JScience and others
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.quantity;


/**
 * Represents the number of elementary entities (molecules, for example) of a
 * substance. The metric system unit for this quantity is "mol" (mole).
 * 
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:jcp@catmedia.us">Werner Keil</a>
 * @version 1.1, $Date$
 */
public interface Substance extends Quantity<Substance> {
    // TODO name? Substance or e.g. SubstanceNumber, SubstanceElements, etc.?
}
