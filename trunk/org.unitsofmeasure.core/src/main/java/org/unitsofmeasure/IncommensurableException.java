/**
 * The Units of Measure API, UCUM codes, UCUM table (regardless of format),
 * and UCUM Specification are copyright © 1999-2010, 
 * Regenstrief Institute, Inc. and the Unified Codes for Units of Measures 
 * (UCUM) Organization. All rights reserved.
 *
 * See TermsOfUse for details.
 */
package org.unitsofmeasure;

/**
 * Signals that a problem of some sort has occurred due to incommensurable of
 * some quantities/units. Only commensurable quantity (quantities with the same
 * dimensions) may be compared, equated, added, or subtracted. Also, one unit
 * can be converted to another unit only if both units are commensurable.
 * 
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:jsr275@catmedia.us">Werner Keil</a>
 * @see <a
 *      href="http://en.wikipedia.org/wiki/Unit_commensurability#Commensurability">
 *      Wikipedia: Unit Commensurability</a>
 * @version 1.1 ($Revision$), $Date$
 */
public class IncommensurableException extends UnitException {

    /** The serialVersionUID */
    private static final long serialVersionUID = 678172064267032047L;

    /**
     * Constructs a <code>IncommensurableException</code> with the specified
     * detail message.
     * 
     * @param message
     *            the detail message.
     */
    public IncommensurableException(String message) {
	super(message);
    }
}
