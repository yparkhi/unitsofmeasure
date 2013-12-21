/*
 * JScience - Java(TM) Tools and Libraries for the Advancement of Sciences.
 * Copyright (C) 2006-2007 - JScience (http://jscience.org/)
 * All rights reserved.
 * 
 * Permission to use, copy, modify, and distribute this software is
 * freely granted, provided that this notice is preserved.
 */
package org.jscience.samples.money;

// Constants (Java 5 static import)
import static javax.measure.unit.NonSI.GALLON_LIQUID_US;
import static javax.measure.unit.NonSI.LITRE;
import static javax.measure.unit.NonSI.MILE;
import static javax.measure.unit.SI.KILO;
import static javax.measure.unit.SI.METRE;
import static org.jscience.economics.money.Currency.EUR;
import static org.jscience.economics.money.Currency.GBP;
import static org.jscience.economics.money.Currency.USD;
import static org.jscience.samples.money.MonetaryUnits.INR;

import javax.measure.quantity.Length;
import javax.measure.unit.UnitFormat;
import org.jscience.economics.money.Currency;
import org.jscience.economics.money.Money;
import org.jscience.physics.amount.Amount;

//import javax.measure.Measure;

/**
 * @author Werner Keil
 * @version 0.9, $Date: 2011-07-05 02:14:56 +0530 (Di, 05 Jul 2011) $
 */
public class MoneyDemo {
  
	
	/**
	 * @param args The application arguments if required.
	 */
	public static void main(String[] args) {
        ///////////////////////////////////////////////////////////////////////
        // Calculates the cost of a car trip in Europe for an American tourist.
        ///////////////////////////////////////////////////////////////////////
		
        // Use currency symbols instead of ISO-4217 codes.
        UnitFormat.getInstance().label(USD, "$"); // Use "$" symbol instead of currency code ("USD")
        UnitFormat.getInstance().label(EUR, "€"); // Use "€" symbol instead of currency code ("EUR")
        UnitFormat.getInstance().label(GBP, "£"); // Use "£" symbol instead of currency code ("GBP")
        UnitFormat.getInstance().label(INR, "Rp"); // Use "Rp" instead of currency code ("IRP")
        
        // Sets exchange rates.
        Currency.setReferenceCurrency(EUR);
        //EUR.setExchangeRate(1.4); // 1.0 € = 1.4 $
        USD.setExchangeRate(0.75d);
        GBP.setExchangeRate(1.2); // 1.0 £ = 1.2 €
        INR.setExchangeRate(0.022); // 1.0Rp = ~0.022 $
        
        //java.util.Currency utilCurr = java.util.Currency.getInstance("USD");
        
        // Calculates trip cost.
        /*
        Measure<?> carMileage        = Measure.valueOf(20, MILE.divide(GALLON_LIQUID_US)); // 20 mi/gal.
        Measure<?> gazPrice          = Measure.valueOf(1.2, EUR.divide(LITER)); // 1.2 €/L
        Measure<Length> tripDistance = Measure.valueOf(400, KILO(SI.METER)); // 400 km
        Measure<Money>  tripCost     = tripDistance.divide(carMileage).times(gazPrice).to(USD);
		*/
        
        // Calculates trip cost.
        Amount<?> carMileage        = Amount.valueOf(20, MILE.divide(GALLON_LIQUID_US)); // 20 mi/gal.
        Amount<?> gazPrice          = Amount.valueOf(1.2, EUR.divide(LITRE)); // 1.2 €/L
        Amount<Length> tripDistance = Amount.valueOf(400, KILO(METRE)); // 400 km
        Amount<?>  tripCost     = tripDistance.divide(carMileage).times(gazPrice);
        final Amount<Money> tripCostUSD = tripCost.to(USD);
        Amount<Money> tripCostEUR = tripCost.to(EUR);
        
		// Display trip.
		System.out.println("Car  mileage  = " + carMileage);
		System.out.println("Trip distance = " + tripDistance);

        // Displays cost.
		System.out.println("Gas price = " + gazPrice);
        System.out.println("Trip cost = " + tripCost );
        System.out.println("Trip cost = " + tripCostEUR );
        System.out.println("Trip cost = " + tripCostUSD + " (" + tripCostUSD.to(EUR) + ")");
        System.out.println("Trip cost = " + tripCostUSD + " (" + tripCostUSD.to(GBP) + ")");
        //System.out.println("Trip cost = " + tripCostUSD + " (" + tripCostUSD.to(INR) + ")");
        
        //System.out.println(utilCurr.getSymbol());
	}

}
