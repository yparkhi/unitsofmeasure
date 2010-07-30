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
 * Signals that a problem of some sort has occurred due to the impossibility of
 * constructing a converter between two units. For example, the mutiplication of
 * offset units are usually units not convertible to their {@link Unit#toMetric
 * metric units}.
 * 
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:jcp@catmedia.us">Werner Keil</a>
 * @version 1.1.1 ($Revision$), $Date$
 */
public class UnconvertibleException extends RuntimeException {

    /** The serialVersionUID */
    private static final long serialVersionUID = 2738859544898650397L;

    /**
     * Constructs a <code>UnconvertibleException</code> with the specified
     * detail message.
     * 
     * @param message
     *            the detail message.
     */
    public UnconvertibleException(String message) {
	super(message);
    }

    /**
     * Constructs a <code>UnconvertibleException</code> with the specified
     * detail message.
     * 
     * @param cause
     *            the original exception.
     */
    public UnconvertibleException(Throwable cause) {
	super(cause);
    }
}