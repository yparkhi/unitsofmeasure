/**
 * Copyright (c) 2013 Werner Keil and others.
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.impl.util;

/**
 * @author Werner Keil
 * Date: 4/25/11
 * Time: 12:53 PM
 */
public interface Multiplier {
	static final double BYTE_FACTOR = 8.0;
	
    double getMultFactor();
}
