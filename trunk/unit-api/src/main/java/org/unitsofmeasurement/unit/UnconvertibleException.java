/**
 * Unit-API - Units of Measurement API for Java (http://unitsofmeasurement.org)
 * Copyright (c) 2005-2010, Unit-API contributors, JScience and others
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.unit;

/**
 * Signals that a problem of some sort has occurred due to the impossibility of
 * constructing a converter between two units. For example, the mutiplication of
 * offset units are usually units not convertible to their {@link Unit#getSystemUnit
 * system unit}.
 * 
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:jcp@catmedia.us">Werner Keil</a>
 * @version 1.1.2 ($Revision$), $Date$
 */
public class UnconvertibleException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4623551240019830166L;

	/**
     * Constructs a <code>UnconvertibleException</code> with the specified
     * detail message.
     * 
     * @param message the detail message.
     */
    public UnconvertibleException(String message) {
	super(message);
    }

    /**
     * Constructs a <code>UnconvertibleException</code> with the specified
     * detail message.
     * 
     * @param cause the original exception.
     */
    public UnconvertibleException(Throwable cause) {
	super(cause);
    }
}