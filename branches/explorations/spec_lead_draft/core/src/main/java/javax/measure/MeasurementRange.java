/**
 * Unit-API - Units of Measurement API for Java (http://unitsofmeasurement.org)
 * Copyright (c) 2005-2013, Unit-API contributors and others
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure;

/**
 * A Range is a pair of <code>V</code> values that represent a range of values.<p>
 * Range limits and resolution MUST be presented in the same scale and have the same unit as measured data values. The MeasurementRange MUST be immutable.
 * 
 * @param <V>
 *            The value of the measurement range.
 * 
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 0.1
 */
public class MeasurementRange<V> {
    private final V min;
    private final V max;
    private V res;

    /**
     * Construct an instance of Range with a min and max value.
     *
     * @param min The minimum value for the measurement range.
     * @param max The maximum value for the measurement range.
     * @param res The  resolution of the measurement range.
     */
    public MeasurementRange(V min, V max, V res) {
    	this.min = min;
        this.max = max;
        this.res = res;
    }
    
    /**
     * Construct an instance of Range with a min and max value.
     *
     * @param min The minimum value for the measurement range.
     * @param max The maximum value for the measurement range.
     */
    public MeasurementRange(V min, V max) {
    	this.min = min;
        this.max = max;
    }

    /**
     * Returns the smallest value of the range. The value is the same as that given as the constructor parameter for the smallest value.
     * @return the minimum value
     */
    public V getMinimum() {
        return min;
    }

    /**
     * Returns the largest value of the measurement range. The value is the same as that given as the constructor parameter for the largest value.
     * 
     * @return the maximum value
     */
    public V getMaximum() {
        return max;
    }
    
    /**
     * Returns the resolution of the measurement range. The value is the same as that given as the constructor parameter for the largest value.
     * 
     * @return resolution of the range, the value is the same as that given as the constructor parameter for the resolution
     */
    public V getResolution() {
        return res;
    }

    @Override
    public boolean equals(Object object) {
        if(object instanceof MeasurementRange<?>)  {
            @SuppressWarnings("unchecked")
            final MeasurementRange<V> that = (MeasurementRange<V>) object;
            return this == that || (
                    that.getMinimum() == getMinimum() &&
                    that.getMaximum() == getMaximum() &&
                    that.getResolution() == getResolution());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return min.hashCode() + max.hashCode() + (res!=null ? res.hashCode() : 0);
    }

    @Override
    public String toString() {
        return new StringBuilder()
            .append("min").append(": ").append(getMinimum())
            .append("max").append(": ").append(getMaximum())
            .toString();
    }
}
