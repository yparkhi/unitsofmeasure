/**
 *  The Units of Measure API, UCUM codes, UCUM table (regardless of format),
 *  and UCUM Specification are copyright © 1999-2010, Regenstrief Institute, Inc.
 *  and the Unified Codes for Units of Measures (UCUM) Organization.
 *  All rights reserved.
 *
 * See TermsOfUse for details.
 */
package org.unitsofmeasure.quantity;

import org.unitsofmeasure.Quantity;

/**
 * This interface represents the moment of a force. The system unit for this
 * quantity is "N.m" (Newton-Metre).
 * 
 * <p>
 * Note: The Newton-metre ("N.m") is also a way of expressing a Joule (unit of
 * energy). However, torque is not energy. So, to avoid confusion, we will use
 * the units "N.m" for torque and not "J". This distinction occurs due to the
 * scalar nature of energy and the vector nature of torque.
 * </p>
 * 
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @version 1.2, $Date$
 */
public interface Torque extends Quantity<Torque> {
}
