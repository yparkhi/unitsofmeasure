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
 * This interface represents an energy multiplied by a duration (quantity
 * associated to the <a
 * href="http://en.wikipedia.org/wiki/Planck%27s_constant">Planck Constant</a>).
 * The system unit for this quantity is "J.s" (joules second).
 * 
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @version 1.1, $Date$
 * @see <a href="http://en.wikipedia.org/wiki/Action_(physics)">Wikipedia's
 *      Action</a>
 * 
 */
public interface Action extends Quantity<Action> {

}
