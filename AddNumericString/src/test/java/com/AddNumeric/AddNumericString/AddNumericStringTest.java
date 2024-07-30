package com.AddNumeric.AddNumericString;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AddNumericStringTest {

    @Test
    public void testAddEmptyString() {
        AddNumericString ans = new AddNumericString();
        int actualResult = ans.add("");
        assertEquals(0, actualResult);
    }

    @Test
    public void testAddSingleNumber() {
        AddNumericString ans = new AddNumericString();
        int actualResult = ans.add("1");
        assertEquals(1, actualResult);
    }

    @Test
    public void testAddTwoNumbers() {
        AddNumericString ans = new AddNumericString();
        int actualResult = ans.add("1,5");
        assertEquals(6, actualResult);
    }

    @Test
    public void testAddMultipleNumbers() {
        AddNumericString ans = new AddNumericString();
        int actualResult = ans.add("1,2,3,4,5");
        assertEquals(15, actualResult);
    }

    @Test
    public void testAddNewLineDelimiter() {
        AddNumericString ans = new AddNumericString();
        int actualResult = ans.add("1\n2,3");
        assertEquals(6, actualResult);
    }

    @Test
    public void testAddCustomDelimiter() {
        AddNumericString ans = new AddNumericString();
        int actualResult = ans.add("//;\n1;2");
        assertEquals(3, actualResult);
    }

    @Test
    public void testAddNegativeNumber() {
        AddNumericString ans = new AddNumericString();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ans.add("1,-2,3");
        });
        assertEquals("Negative numbers not allowed: [-2]", exception.getMessage());
    }

    @Test
    public void testAddMultipleNegativeNumbers() {
        AddNumericString ans = new AddNumericString();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ans.add("1,-2,3,-4");
        });
        assertEquals("Negative numbers not allowed: [-2, -4]", exception.getMessage());
    }
}
