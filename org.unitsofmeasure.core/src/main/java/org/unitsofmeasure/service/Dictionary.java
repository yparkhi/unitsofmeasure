/**
 *  The Units of Measure API, UCUM codes, UCUM table (regardless of format),
 *  and UCUM Specification are copyright © 1999-2010, Regenstrief Institute, Inc.
 *  and the Unified Codes for Units of Measures (UCUM) Organization.
 *  All rights reserved.
 *
 * See TermsOfUse for details.
 */
package org.unitsofmeasure.service;

/**
 * @author Werner Keil
 * OSGi demo.
 * 
 * @deprecated change this into something more useful for UOM, e.g. Conversion
 */
public interface Dictionary {
	
    /**
     * Returns the language of the dictionary
     *
     * @return the language of the dictionary
     */
    public String getLanguage();
	
    /**
     * Check for the existence of a word in the dictionary
     * 
     * @param word the word to be checked.
     * @return true if the word is in the dictionary
     */
    public boolean check(String word);

}
