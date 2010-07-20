/**
 *  The Units of Measure API, UCUM codes, UCUM table (regardless of format),
 *  and UCUM Specification are copyright © 1999-2010, Regenstrief Institute, Inc.
 *  and the Unified Codes for Units of Measures (UCUM) Organization.
 *  All rights reserved.
 *
 * See TermsOfUse for details.
 */
package org.unitsofmeasure.util;

/**
 * A static helper class, checking e.g. if some tests require optional console output
 * XXX this could be done using a logging framework eventually
 *
 * @version $Revision: 189 $, $Date: 2010-02-24 14:10:17 +0100 (Mi, 24 Feb 2010) $
 * @author $Author: dautelle $
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
