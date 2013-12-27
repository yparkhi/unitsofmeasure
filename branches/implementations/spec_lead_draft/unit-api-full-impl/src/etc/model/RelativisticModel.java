/*
 * JScience - Java(TM) Tools and Libraries for the Advancement of Sciences.
 * Copyright (C) 2010 - JScience (http://jscience.org/)
 * All rights reserved.
 * 
 * Permission to use, copy, modify, and distribute this software is
 * freely granted, provided that this notice is preserved.
 */
package org.unitsofmeasurement.impl.model;

import org.unitsofmeasurement.impl.AbstractDimension;
import org.unitsofmeasurement.impl.function.AbstractConverter;
import org.unitsofmeasurement.impl.function.RationalConverter;

/**
 * This class represents the relativistic model.
 *
 * @author  <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @version 5.0, October 12, 2010
 */
public class RelativisticModel extends StandardModel {
    
    /**
     * Holds the meter to time transform.
     */
    private static RationalConverter METRE_TO_TIME 
        = new RationalConverter(1, 299792458);
    
    /**
     * Default constructor.
     */
    public RelativisticModel() {
    }

    @Override
    public AbstractDimension getFundamentalDimension(AbstractDimension dimension) {
        if (dimension.equals(AbstractDimension.LENGTH)) return AbstractDimension.TIME;
        return super.getFundamentalDimension(dimension);
    }

    @Override
    public AbstractConverter getDimensionalTransform(AbstractDimension dimension) {
        if (dimension.equals(AbstractDimension.LENGTH)) return METRE_TO_TIME;
        return super.getDimensionalTransform(dimension);
    }

}