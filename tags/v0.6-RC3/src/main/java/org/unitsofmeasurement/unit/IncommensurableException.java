/**
 * Unit-API - Units of Measurement API for Java (http://unitsofmeasurement.org)
 * Copyright (c) 2005-2010, Unit-API contributors, JScience and others
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
 * @author <a href="mailto:jcp@catmedia.us">Werner Keil</a>
 * @see <a
 *      href="http://en.wikipedia.org/wiki/Unit_commensurability#Commensurability">
 *      Wikipedia: Unit Commensurability</a>
 * @version 1.1 ($Revision$), $Date$
 */
public class IncommensurableException extends Exception {

    /**
     * For cross-version compatibility.
     */
    private static final long serialVersionUID = -3676414292638136515L;

    /**
     * Constructs a <code>IncommensurableException</code> with the specified
     * detail message.
     *
     * @param message the detail message.
     */
    public IncommensurableException(String message) {
        super(message);
    }
}
