/**
 *  The Units of Measure API, UCUM codes, UCUM table (regardless of format),
 *  and UCUM Specification are copyright © 1999-2010, Regenstrief Institute, Inc.
 *  and the Unified Codes for Units of Measures (UCUM) Organization.
 *  All rights reserved.
 *
 * See TermsOfUse for details.
 */
package org.unitsofmeasure;

/**
 * Signals that a problem of some sort has occurred either when creating a
 * converter between two units or during the conversion itself.
 *
 * @author  <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author  <a href="mailto:jsr275@catmedia.us">Werner Keil</a>
 * @version 1.4 ($Revision: 198 $), $Date: 2010-02-24 19:53:02 +0100 (Mi, 24 Feb 2010) $
 * @deprecated not official yet, here using RuntimeException instead looks better
 */
public class ConversionException extends RuntimeException {

    /** The serialVersionUID */
    private static final long serialVersionUID = -2846245619420930853L;

    /**
     * Constructs a <code>ConversionException</code> with the specified detail
     * message.
     *
     * @param  message the detail message.
     */
    public ConversionException(String message) {
        super(message);
    }
}
