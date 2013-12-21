package org.jscience.samples.converter;

import javax.measure.Measurable;
import javax.measure.Measure;
import javax.measure.unit.*;
import javax.measure.quantity.*;
import static javax.measure.unit.SI.*;
import static javax.measure.unit.NonSI.*;
import static javax.measure.unit.Dimension.*;

public class Main {
  public static void main(String[] args) {
    // Conversion between units.
    System.out.println(KILO(METER).getConverterTo(MILE).convert(10.0));
    // Retrieval of the system unit (identifies the measurement type).
    System.out.println(REVOLUTION.divide(MINUTE).getStandardUnit());
    // Dimension checking (allows/disallows conversions)
    System.out.println(ELECTRON_VOLT.isCompatible(WATT.times(HOUR)));
    // Retrieval of the unit dimension (depends upon the current model).
    System.out.println(ELECTRON_VOLT.getDimension());
  }
}

