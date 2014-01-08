/**
 * Unit-API - Units of Measurement API for Java (http://unitsofmeasurement.org)
 * Copyright (c) 2005-2012, Unit-API contributors, JScience and others
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure.service;

import java.util.Locale;

/**
 * <p>
 * This interface represent the service to obtain {@link UnitFormat} instances.
 * </p>
 * 
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @see <a href="http://aurora.regenstrief.org/~ucum/ucum.html">UCUM Full
 *      Specification</a>
 * @version 1.2, $Date: 2013-09-20 01:04:46 +0200 (Fr, 20 Sep 2013) $
 */
public interface UnitFormatService {

    /**
     * Returns the default <a href="http://www.unitsofmeasure.org/">UCUM</a>
     * unit format.
     *
     * @return <code>getUnitFormat("UCUM")</code>
     */
	UnitFormat getUnitFormat();

    /**
     * Returns the unit format having the specified name or
     * <code>null</code> if none.
     *
     * @param name the name of the format.
     * @return the corresponding unit format.
     */
	UnitFormat getUnitFormat(String name);

    /**
     * Returns the unit format for the specified locale or
     * <code>null</code> if none.
     *
     * @param locale the locale for the format.
     * @return the corresponding unit format.
     */
	UnitFormat getUnitFormat(Locale locale);

}
