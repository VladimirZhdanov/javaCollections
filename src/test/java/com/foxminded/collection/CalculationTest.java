package com.foxminded.collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @since 0.1
 */
class CalculationTest {

    /**
     * Line separator depends on your OS.
     */
    public static final String LINE_SEPARATOR = System.lineSeparator();
    public SimpleCacheManager simpleCacheManager;
    public Calculation calculation;

    @BeforeEach
    public void setUp() {
        simpleCacheManager = new SimpleCacheManager();
        calculation = new Calculation(simpleCacheManager);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWenNullIsPassed() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                calculation.getResult(null));
        assertEquals("Expected String but the input was null...", exception.getMessage());
    }

    @Test
    public void shouldReturnCorrectedCalculationOfSymbolsWhenPutString() {
        StringBuilder expected = new StringBuilder();
        String actual = calculation.getResult("hello world!");
        expected.append("hello world!").append(LINE_SEPARATOR)
                .append("\" \" - 1").append(LINE_SEPARATOR)
                .append("\"!\" - 1").append(LINE_SEPARATOR)
                .append("\"r\" - 1").append(LINE_SEPARATOR)
                .append("\"d\" - 1").append(LINE_SEPARATOR)
                .append("\"e\" - 1").append(LINE_SEPARATOR)
                .append("\"w\" - 1").append(LINE_SEPARATOR)
                .append("\"h\" - 1").append(LINE_SEPARATOR)
                .append("\"l\" - 3").append(LINE_SEPARATOR)
                .append("\"o\" - 2").append(LINE_SEPARATOR);
        assertEquals(expected.toString(), actual,
                "Should return a corrected calculation");
    }
}