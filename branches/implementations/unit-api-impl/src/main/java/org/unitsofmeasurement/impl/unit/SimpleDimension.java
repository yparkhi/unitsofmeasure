/**
 *
 */
package org.unitsofmeasurement.impl.unit;

import org.unitsofmeasurement.unit.Dimension;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Werner Keil.
 * User: 605805680
 * Date: 4/26/11
 * Time: 5:04 PM
 */
final class SimpleDimension implements Dimension {
    static final Dimension INSTANCE = new SimpleDimension();

    @Override
    public Dimension multiply(Dimension dimension) {
        return this;
    }

    @Override
    public Dimension divide(Dimension dimension) {
        return this;
    }

    @Override
    public Dimension pow(int i) {
        return this;
    }

    @Override
    public Dimension root(int i) {
        return this;
    }

    @Override
    public Map<? extends Dimension, Integer> getProductDimensions() {
        Map<Dimension, Integer> products = new HashMap<Dimension, Integer>();
        products.put(this, Integer.valueOf(1));
        return products;
    }
}
