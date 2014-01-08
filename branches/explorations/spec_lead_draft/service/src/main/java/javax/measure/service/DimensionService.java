/**
 * Copyright (c) 2013 Werner Keil and others.
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure.service;

import javax.measure.Dimension;


/**
 * <p>
 * This interface represent the service to obtain {@link javax.measure.Dimension} instances.
 * </p>
 * 
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @see {@link javax.measure.Dimension}
 * @version 0.2, $Date: 2013-12-26 $
 */
public interface DimensionService {

    /**
     * Returns the default <a href="http://www.unitsofmeasure.org/">UCUM</a>
     * unit format.
     *
     * @return <code>getUnitFormat("UCUM")</code>
     */
	Dimension getDimension();
}
