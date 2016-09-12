package com.strater.jenn;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jstrater
 */
public class temperatureConversionTest {
    
    @Test
    public void convertFarenheitToCelcius() {
        double result = convertTemp(100, net.webservicex.TemperatureUnit.DEGREE_CELSIUS, net.webservicex.TemperatureUnit.DEGREE_FAHRENHEIT);
        assertEquals(212.0, result, 0.0);
    }
    
    @Test
    public void convertCelciusToFarenheight() {
        double result = convertTemp(-20.0, net.webservicex.TemperatureUnit.DEGREE_FAHRENHEIT, net.webservicex.TemperatureUnit.DEGREE_CELSIUS);
        assertEquals(-28.888, result, 0.008);
    }

    private static double convertTemp(double temperature, net.webservicex.TemperatureUnit fromUnit, net.webservicex.TemperatureUnit toUnit) {
        net.webservicex.ConvertTemperature service = new net.webservicex.ConvertTemperature();
        net.webservicex.ConvertTemperatureSoap port = service.getConvertTemperatureSoap();
        return port.convertTemp(temperature, fromUnit, toUnit);
    }
}
