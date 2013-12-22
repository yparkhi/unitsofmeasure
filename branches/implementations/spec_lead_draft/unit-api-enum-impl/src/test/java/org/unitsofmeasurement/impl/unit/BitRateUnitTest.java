package org.unitsofmeasurement.impl.unit;

import org.hamcrest.Matchers;
import org.junit.Test;
import static org.junit.Assert.assertThat;

/**
 * @author Werner Keil
 * Date: 7/23/11
 * Time: 4:50 PM
 */
public class BitRateUnitTest {

    @Test
    public void testAlternate() throws Exception {
        BitRateUnit bru = BitRateUnit.Kbps;
        BitRateUnit alternate = (BitRateUnit)bru.alternate("K");
        assertThat(alternate, Matchers.equalTo(BitRateUnit.Kbps));
    }

    @Test
    public void testGetBySymbolLower() throws Exception {
        BitRateUnit bru = BitRateUnit.getBySymbol("kbps");
        assertThat(bru, Matchers.equalTo(BitRateUnit.Kbps));
    }

    @Test
    public void testGetBySymbolUpper() throws Exception {
        BitRateUnit bru = BitRateUnit.getBySymbol("MBPS");
        assertThat(bru, Matchers.equalTo(BitRateUnit.Mbps));
    }
}
