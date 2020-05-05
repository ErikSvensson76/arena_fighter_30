package se.lexicon.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberGeneratorTest {

    @Test
    public void given_min_and_max_generateInt_return_expected_value(){
        int min = 1, max = 1;
        int expectedValue = 1;

        assertEquals(expectedValue, NumberGenerator.generateInt(min, max));
    }

}
