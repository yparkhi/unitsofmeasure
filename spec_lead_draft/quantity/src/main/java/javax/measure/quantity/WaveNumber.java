/**
 * Unit-API - Units of Measurement API for Java (http://unitsofmeasurement.org)
 * Copyright (c) 2005-2010, Unit-API contributors, JScience and others
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure.quantity;

import javax.measure.Quantity;


/**
 * This interface represents a wave property inversely related to wavelength.
 * The system unit for this quantity is "1/m" (reciprocal meters).
 *
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 1.8.1
 *
 * @see Length
 * @see <a href="http://en.wikipedia.org/wiki/Wavenumber">Wikipedia: Wavenumber</a>
 */
public interface WaveNumber extends Quantity<WaveNumber> {
}
