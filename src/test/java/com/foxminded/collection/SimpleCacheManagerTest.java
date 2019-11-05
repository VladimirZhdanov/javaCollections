package com.foxminded.collection;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @since 0.1
 */
class SimpleCacheManagerTest {
    public SimpleCacheManager simpleCacheManager;
    Map<Character, Integer> testMap;


    @BeforeEach
    public void setUp() {
        simpleCacheManager = new SimpleCacheManager();
        testMap = new HashMap<>();
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWenNullIsPassed1() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                simpleCacheManager.put(null, testMap));
        assertEquals("Expected String as key and Map value but cacheKey or value was null...",
                exception.getMessage());
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWenNullIsPassed2() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                simpleCacheManager.put("smth", null));
        assertEquals("Expected String as key and Map value but cacheKey or value was null...",
                exception.getMessage());
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWenNullIsPassed3() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                simpleCacheManager.get(null));
        assertEquals("Expected String as key but cacheKey was null...", exception.getMessage());
    }

    @Test
    public void shouldReturnCorrectedCalculationOfSymbolsWhenPutString() {
        simpleCacheManager.put("hello world!", testMap);
        Map<Character, Integer> actual = simpleCacheManager.get("hello world!");
        assertEquals(testMap, actual,
                "Should return the test map");
    }
}