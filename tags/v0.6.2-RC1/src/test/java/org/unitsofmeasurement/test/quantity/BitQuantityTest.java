package org.unitsofmeasurement.test.quantity;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.unitsofmeasurement.test.unit.BitUnit;
import org.unitsofmeasurement.test.unit.TimeUnit;

public class BitQuantityTest {
    BitQuantity bq;
    BitUnit bu;

    @Before
    public void setUp() {
        bu = BitUnit.bit;
        bq = new BitQuantity(100, bu);
    }

    @Test
    public void testAddBitQuantity() {
        BitQuantity bq1 = bq.add(new BitQuantity(100, bu));
        assertEquals(Double.valueOf(200), Double.valueOf(bq1.scalar));
    }

    @Test
    public void testDivideTimeQuantity() {
        BitRateQuantity brq = bq.divide(new TimeQuantity(20, TimeUnit.s));
        assertEquals(Double.valueOf(5), Double.valueOf(brq.scalar));
        assertEquals("5.0 bps", brq.toString());
    }
}
