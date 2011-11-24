/**
 * Unit-API - Units of Measurement API for Java (http://unitsofmeasurement.org)
 * Copyright (c) 2005-2010, Unit-API contributors, JScience and others
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.util;

/**
 * A static helper class, checking e.g. if some tests require optional console
 * output XXX this could have options for using a logging framework eventually
 *
 * @version $Revision: 63 $, $Date: 2010-07-19 11:35:31 +0100 (Mo, 19 Jul 2010) $
 * @author Werner Keil
 */
public abstract class PrintUtils {
    private static final String CONSOLE_OUTPUT = "consoleOutput";

    public static final boolean isConsoleOutput() {
    return ("true".equals(System.getProperty(CONSOLE_OUTPUT)));
    }

    public static final void print(String message) {
    if (isConsoleOutput()) {
        System.out.print(message);
    }
    }

    public static final void println(String message) {
    if (isConsoleOutput()) {
        System.out.println(message);
    }
    }

    public static final void print(Object object) {
    print(String.valueOf(object));
    }

    public static final void println(Object object) {
    println(String.valueOf(object));
    }

    /**
     * This is a Fantom-style convenience method for console output
     */
    public static final void echo(Object obj) {
    println(obj);
    }

    /**
     * This is a Fantom-style convenience method for console output
     */
    public static final void echo(String str) {
    println(str);
    }
}
