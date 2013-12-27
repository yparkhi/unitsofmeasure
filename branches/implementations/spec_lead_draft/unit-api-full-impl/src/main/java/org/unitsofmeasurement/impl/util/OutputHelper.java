/**
 * Copyright (c) 2005, 2013, Werner Keil and others.
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.impl.util;

/**
 * A static helper class, checking e.g. if some tests require optional console
 * output XXX this could have options for using a logging framework eventually
 * TODO change to Service (either OSGi LogService or separate service)
 * @version 0.9.1, 2013-12-26
 * @author Werner Keil
 */
public abstract class OutputHelper {
	static final String CONSOLE_OUTPUT = "consoleOutput"; //$NON-NLS-1$

	public static final boolean isConsoleOutput() {
		return ("true".equals(System.getProperty(CONSOLE_OUTPUT))); //$NON-NLS-1$
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
