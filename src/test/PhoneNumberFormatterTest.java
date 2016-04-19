package test;

import main.PhoneNumberFormatter;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class PhoneNumberFormatterTest {

    private PhoneNumberFormatter phoneNumberFormatter;
    private String input;
    private String expected;

    @Before
    public void setUp() {
        phoneNumberFormatter = new PhoneNumberFormatter();
        input    = "";
        expected = "";
    }

    @Test
    public void testEvenPhoneNumbers() {
        input = "122!££31£$%-34%%%53 &&^&^45&*&^*()3-+=-{}[[[];:'@#~   555--";
        expected = "122-313-453-453-555";
        assertEquals("Removes all non digits", expected, phoneNumberFormatter.solution(input));
    }

    @Test
    public void testOddPhoneNumbers() {
        input = "0 - 22 1985--342";
        expected = "022-198-53-42";
        assertEquals("Checks double dashes", expected, phoneNumberFormatter.solution(input));
    }

    @Test
    public void testOddOnlyDigitPhoneNumbers() {
        input = "1234567";
        expected = "123-45-67";
        assertEquals("Odd Only digit phone number", expected, phoneNumberFormatter.solution(input));
    }

    @Test
    public void testEvenOnyDigitPhoneNumbers() {
        input = "1234567";
        expected = "123-45-67";
        assertEquals("Even Only digit phone number", expected, phoneNumberFormatter.solution(input));
    }
}