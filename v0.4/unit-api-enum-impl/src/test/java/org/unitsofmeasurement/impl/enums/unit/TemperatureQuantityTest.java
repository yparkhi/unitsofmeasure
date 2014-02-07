/**
 *  Unit-API - Units of Measurement API for Java
 *  Copyright 2013-2014, Jean-Marie Dautelle, Werner Keil, V2COM and individual
 *  contributors by the @author tag.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *  http://www.apache.org/licenses/LICENSE-2.0
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.unitsofmeasurement.impl.enums.unit;

import static org.junit.Assert.*;
import static org.unitsofmeasurement.impl.enums.unit.TemperatureUnit.CELSIUS;
import javax.measure.quantity.Temperature;
import org.junit.Test;
import org.unitsofmeasurement.impl.enums.quantity.TemperatureQuantity;


/**
 * @author Werner Keil
 *
 */
public class TemperatureQuantityTest {

	@Test
	public void testInstanciate() {
		Temperature t =  new TemperatureQuantity(23.0, CELSIUS); // 23.0 °C
		assertEquals(Double.valueOf(23.0d), t.getValue());
		assertEquals(CELSIUS, t.getUnit());
		//assertEquals("km", l.getUnit().getSymbol());
	}
	
	@Test
	public void testToString() {
		Temperature t =  new TemperatureQuantity(23.0d, CELSIUS); // 23.0 °C
		assertEquals("23.0°C", t.toString());
	}
}
