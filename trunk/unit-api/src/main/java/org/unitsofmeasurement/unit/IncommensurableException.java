/**
 * Unit-API - Units of Measurement API for Java (http://unitsofmeasurement.org)
 * Copyright (c) 2005-2011, Unit-API contributors, JScience and others
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.unit;


/**
 * Signals that a problem of some sort has occurred due to incommensurable of
 * some quantities/units. Only commensurable quantity (quantities with the same
 * dimensions) may be compared, equated, added, or subtracted. Also, one unit
 * can be converted to another unit only if both units are commensurable.
 *
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 1.2
 *
 * @see <a href="http://en.wikipedia.org/wiki/Unit_commensurability#Commensurability">Unit Commensurability on Wikipedia</a>
 * @since 0.6.0
 */
public class IncommensurableException extends Exception {
    /**
     * For cross-version compatibility.
     */
    private static final long serialVersionUID = -3676414292638136515L;

    /**
     * Constructs a {@code IncommensurableException} with the given message.
     *
     * @param message the detail message, or {@code null} if none.
     */
    public IncommensurableException(final String message) {
        super(message);
    }
}
