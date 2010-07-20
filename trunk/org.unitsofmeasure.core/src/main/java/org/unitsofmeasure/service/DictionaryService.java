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
 * @deprecated change this into something more useful for UOM, e.g. ConversionService
 */
public interface DictionaryService {
	
    /**
     * Register a dictionary
     * 
     * @param dictionary the dictionary to be added.
     */
    public void registerDictionary(Dictionary dictionary);
    
    /**
     * Remove a dictionary
     * 
     * @param dictionary the dictionary to be removed.
     */
    public void unregisterDictionary(Dictionary dictionary);
	
    /**
     * Check for the existence of a word across all dictionaries
     * 
     * @param word the word to be checked.
     * @return true if the word is in any dictionary
     */
    public boolean check(String word);

}
