package test;

import main.PhoneNumberFormatter;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class PhoneNumberFormatterTest {

    private PhoneNumberFormatter phoneNumberFormatter;
    private String input;
    private String expected;

    @Before public void PhoneNumberFormatter() {
        phoneNumberFormatter = new PhoneNumberFormatter();
        input    = "";
        expected = "";
    }

    @Test
    public void testRemoveNonDigits() {
        input = "122!££31£$%-34%%%53 &&^&^45&*&^*()3-+=-{}[[[];:'@#~   555--";
        expected = "122-313-453-453-555";
        assertEquals("Removes all non digits", expected, phoneNumberFormatter.solution(input));
    }

    @Test
    public void testCheckDoubleDashes() {

    }
}