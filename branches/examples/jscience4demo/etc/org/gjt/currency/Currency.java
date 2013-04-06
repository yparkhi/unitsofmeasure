/*
** Java currency library package.
** Copyright (c) 1999 by Bruno Antunes
**
** This program is free software.
**
** You may redistribute it and/or modify it under the terms of the GNU
** General Public License as published by the Free Software Foundation.
** Version 2 of the license should be included with this distribution in
** the file LICENSE, as well as License.html. If the license is not
** included	with this distribution, you may find a copy at the FSF web
** site at 'www.gnu.org' or 'www.fsf.org', or you may write to the
** Free Software Foundation, 675 Mass Ave, Cambridge, MA 02139 USA.
**
** THIS SOFTWARE IS PROVIDED AS-IS WITHOUT WARRANTY OF ANY KIND,
** NOT EVEN THE IMPLIED WARRANTY OF MERCHANTABILITY. THE AUTHOR
** OF THIS SOFTWARE, ASSUMES _NO_ RESPONSIBILITY FOR ANY
** CONSEQUENCE RESULTING FROM THE USE, MODIFICATION, OR
** REDISTRIBUTION OF THIS SOFTWARE.
**
*/
package org.gjt.currency;

import java.util.Locale;
import java.text.*;
import java.io.Serializable;

/**
 * Representation of a monetary unit (a currency). A Currency is composed of
 * a International Currency Symbol and an exchange rate, the equivalent value
 * for one euro in the currency
 *
 * @author Bruno Antunes
 * @version 1.0 30/10/1999
 */
public class Currency implements Serializable {
    /** the equivalent value of one euro in this currency */
    private float exchangeRate;

    /** International Currency Symbol for this currency */
    private String internationalCurrencySymbol;

    /**
     * @param internationalCurrencySymbol the International Currency Symbol for
     * the currency
     * @param exchangeRate the exchange rate of this currency in relation do one
     * euro.
     */
    public Currency(String internationalCurrencySymbol,
                    float exchangeRate) {
        if (internationalCurrencySymbol == null) {
            throw new IllegalArgumentException("Invalid symbol");
        } else if (exchangeRate <= 0) {
            throw new IllegalArgumentException("Invalid exchange rate");
        }
        this.internationalCurrencySymbol = internationalCurrencySymbol;
        this.exchangeRate = exchangeRate;
    }

    /**
     * The value of this currency equivalent to one euro
     *
     * @return the exchange rate
     */
    public float getExchangeRate() {
        return exchangeRate;
    }

    /**
     * The International Currency Symbol for this Currency
     *
     * @return the string representation of the symbol
    */
    public String getInternacionalCurrencySymbol() {
        return internationalCurrencySymbol;
    }

    /**
    * Compares the specified Object with this Currency for equality. Two
    * currencys are equal if they have de same International Currency Symbol and
    * the same exchange rate.
    *
    * @param o the Object to be compared for equality with this Currency.
    * @return true if the specified Object is equal to this Currency
    */
    public boolean equals(Object obj) {
        if (obj instanceof Currency) {
            Currency passedCurrency = (Currency)obj;
            return (exchangeRate == passedCurrency.exchangeRate) &&
                    internationalCurrencySymbol.equals(
                            passedCurrency.internationalCurrencySymbol);
        } else {
          return false;
        }
    }

    /** @return a String representation of this currency */
    public String toString() {
        return internationalCurrencySymbol + ";" + exchangeRate;
    }
}
