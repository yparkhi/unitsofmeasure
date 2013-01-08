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
 * constructing a converter between two units. For example, the multiplication of
 * offset units are usually units not convertible to their {@linkplain Unit#getSystemUnit()
 * system unit}.
 *
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 1.1.2
 *
 * @since 0.6.0
 */
public class UnconvertibleException extends RuntimeException {
    /**
     * For cross-version compatibility.
     */
    private static final long serialVersionUID = -4623551240019830166L;

    /**
     * Constructs a {@code UnconvertibleException} with the given message.
     *
     * @param message the detail message, or {@code null} if none.
     */
    public UnconvertibleException(final String message) {
        super(message);
    }

    /**
     * Constructs a {@code UnconvertibleException} with the given cause.
     *
     * @param cause the cause of this exception, or {@code null} if none.
     */
    public UnconvertibleException(final Throwable cause) {
        super(cause);
    }
}
