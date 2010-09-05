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
 * Represents the number of elementary entities (molecules, for example) of a
 * substance. The metric system unit for this quantity is "mol" (mole).
 * 
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:jcp@catmedia.us">Werner Keil</a>
 * @version 1.1, $Date: 2010-08-23 01:01:37 +0200 (Mo, 23 Aug 2010) $
 */
public interface Substance extends Quantity<Substance> {
    // TODO name? Substance or e.g. SubstanceNumber, SubstanceElements, etc.?
}
