/*
 * JSR-275 - Measures and Units.
 * Copyright (C) 2006-2008 - Java Community Process (http://jcp.org/)
 * All rights reserved.
 * 
 * Permission to use, copy, modify, and distribute this software is
 * freely granted, provided that this notice is preserved.
 */
package net.java.jsr275.samples.money;

import javax.measure.converter.ConversionException;
import javax.measure.converter.UnitConverter;

/**
 * @author Werner Keil
 * @version 0.2, $Date$
 */
public final class CurrencyConverter extends UnitConverter {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1136752067343452168L;
	
	private double exchangeRate;
	
	/**
	 * @return the exchangeRate
	 */
	public double getExchangeRate() {
		return exchangeRate;
	}

	/**
	 * @param exchangeRate the exchangeRate to set
	 */
	public void setExchangeRate(double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

    String _code;
    
    boolean _invert;
    
    /**
     * @param exchangeRate
     */
    public CurrencyConverter(double exchangeRate) {
    	this.setExchangeRate(exchangeRate);
    }
    
    private CurrencyConverter(String code, boolean invert) {
        _code = code;
        _invert = invert;
    }

    @Override
    public UnitConverter inverse() {
        return new CurrencyConverter(_code, !_invert);
    }

    @Override
    public double convert(double x) throws ConversionException {
        //Double refAmount = TO_REFERENCE.get(_code);
    	Double refAmount = Double.valueOf(exchangeRate);
        if (refAmount == null) 
              throw new ConversionException("Exchange rate not set for " + _code);
        return _invert ? x / refAmount.doubleValue() : x * refAmount.doubleValue();
    }

    @Override
    public boolean isLinear() {
        return true;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof CurrencyConverter))
           return false;
        CurrencyConverter that = (CurrencyConverter) obj;
        return this._code.equals(that._code) && (this._invert == that._invert);
    }

    @Override
    public int hashCode() {
        return _invert ? _code.hashCode() : - _code.hashCode();
    }

    private static UnitConverter valueOf(double factor) {
        //float asFloat = (float) factor;
        return factor == 1.0 ? UnitConverter.IDENTITY
                : new CurrencyConverter(factor);
    }
}