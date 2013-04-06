/*
 * JSR-275 - Measures and Units.
 * Copyright (C) 2006-2008 - Java Community Process (http://jcp.org/)
 * All rights reserved.
 * 
 * Permission to use, copy, modify, and distribute this software is
 * freely granted, provided that this notice is preserved.
 */
package net.java.jsr275.samples.money;

// Constants (Java 5 static import)
import static javax.measure.unit.NonSI.GALLON_LIQUID_US;
import static javax.measure.unit.NonSI.LITER;
import static javax.measure.unit.NonSI.MILE;
import static javax.measure.unit.SI.KILO;
import static javax.measure.unit.SI.METER;
import static net.java.jsr275.samples.money.MonetaryUnits.INR;
import static org.jscience.economics.money.Currency.EUR;
import static org.jscience.economics.money.Currency.GBP;
import static org.jscience.economics.money.Currency.USD;

import javax.measure.quantity.Length;
import javax.measure.unit.UnitFormat;

import org.jscience.economics.money.Currency;
import org.jscience.economics.money.Money;
import org.jscience.physics.amount.Amount;

//import javax.measure.Measure;

/**
 * @author Werner Keil
 * @version 0.9, $Date$
 * @deprecated
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
        Currency.setReferenceCurrency(USD);
        EUR.setExchangeRate(1.55); // 1.0 € = 1.4 $
        GBP.setExchangeRate(2); // 1.0 £ = 2.0 $
        //INR.setExchangeRate(0.022); // 1.0Rp = ~0.022 $
        
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
        Amount<?> gazPrice          = Amount.valueOf(1.2, EUR.divide(LITER)); // 1.2 €/L
        Amount<Length> tripDistance = Amount.valueOf(400, KILO(METER)); // 400 km
        Amount<Money>  tripCost     = tripDistance.divide(carMileage).times(gazPrice).to(USD);

        
        // Displays cost.
        System.out.println("Trip cost = " + tripCost + " (" + tripCost.to(EUR) + ")");
        System.out.println("Trip cost = " + tripCost + " (" + tripCost.to(GBP) + ")");
        System.out.println("Trip cost = " + tripCost + " (" + tripCost.to(INR) + ")");
        
        //System.out.println(utilCurr.getSymbol());
	}

	/*
	 1.00 CZK=0.0640254 USD
	Czech Republic Koruny 	  	United States Dollars
	1 CZK = 0.0640254 USD 	  	1 USD = 15.6188 CZK
	 */
}
