/**
 * The Units of Measure API, UCUM codes, UCUM table (regardless of format),
 * and UCUM Specification are copyright © 1999-2010,
 * Regenstrief Institute, Inc. and the Unified Codes for Units of Measures
 * (UCUM) Organization. All rights reserved.
 *
 * See TermsOfUse for details.
 */
package org.unitsofmeasure.util;

/**
 * A static helper class, checking e.g. if some tests require optional console
 * output XXX this could be done using a logging framework eventually
 * 
 * It prints a given object to the console only if the system property
 * <code>-DtestConsoleOutput=true</code> was set.
 * 
 * @version $Revision$, $Date$
 * @author $Author$
 */
public abstract class TestUtil {
    private static final String TEST_CONSOLE_OUTPUT = "testConsoleOutput";

    public static final boolean isTestOutput() {
       return ("true".equals(System.getProperty(TEST_CONSOLE_OUTPUT)));
    }
    public static final void print(String message) {
        if (isTestOutput()) {
            System.out.println(message);
        }
    }
    public static final void print(Object object) {
    	print(String.valueOf(object));
    }
}
