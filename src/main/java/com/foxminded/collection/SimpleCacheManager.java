package com.foxminded.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * Saves a result of calculation(state of class Calculation).
 *
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @since 0.1
 */
public class SimpleCacheManager {

    /**
     * Container for cache.
     */
    private Map<String, Map<Character, Integer>> cache = new HashMap<>();

    /**
     * Puts result of calculation(state of class Calculation) to the map.
     *
     * @param cacheKey - key - String
     * @param value - map with result of calculation(state of class Calculation) - Map
     */
    public void put(String cacheKey, Map<Character, Integer> value) {
        if (cacheKey == null || value == null) {
            throw new IllegalArgumentException("Expected String as key and Map value but cacheKey or value was null...");
        }
        cache.put(cacheKey, value);
    }

    /**
     * Gets an map with result of calculation(state of class Calculation).
     *
     * @param cacheKey - key - String
     * @return - return map with result of calculation(state of class Calculation) - map
     */
    public Map<Character, Integer> get(String cacheKey) {
        if (cacheKey == null) {
            throw new IllegalArgumentException("Expected String as key but cacheKey was null...");
        }
        return cache.get(cacheKey);
    }
}
